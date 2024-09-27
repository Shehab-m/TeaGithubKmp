package org.example.teagithubkmp.presentatioin.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.ktor.utils.io.errors.IOException
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

abstract class BaseViewModel<S, E>(initialState: S) : ViewModel(), BaseInteractionListener {

    protected val _state = MutableStateFlow(initialState)
    val state = _state.asStateFlow()

    protected val _effect = MutableSharedFlow<E?>()
    val effect = _effect.asSharedFlow().mapNotNull { it }

    protected fun <T> tryToExecute(
        function: suspend () -> T,
        onSuccess: (T) -> Unit,
        onError: (Exception) -> Unit,
        inScope: CoroutineScope = viewModelScope
    ): Job {
        return runWithErrorCheck(onError, inScope) {
            val result = function()
            print("Result: tryToExecute: $result")
            onSuccess(result)
        }
    }

    protected fun updateState(updater: (S) -> S) {
        _state.update(updater)
    }

    protected fun sendEffect(effect: E) {
        viewModelScope.launch(Dispatchers.IO) {
            _effect.emit(effect)
        }
    }

    private fun runWithErrorCheck(
        onError: (Exception) -> Unit,
        inScope: CoroutineScope = viewModelScope,
        dispatcher: CoroutineDispatcher = Dispatchers.IO,
        function: suspend () -> Unit
    ): Job {
        return inScope.launch(dispatcher) {
            try {
                function()
            } catch (exception: Exception) {
                when (exception) {
                    is IOException -> {
                        print("IOException: ${exception.message}")
                        onError(exception)
                    }

                    is IllegalArgumentException -> {
                        print("IllegalException: ${exception.message}")
                        onError(exception)
                    }
                    else -> {
                        print("UnknownException: ${exception.message}")
                        onError(exception)
                    }
                }
            }
        }
    }

}