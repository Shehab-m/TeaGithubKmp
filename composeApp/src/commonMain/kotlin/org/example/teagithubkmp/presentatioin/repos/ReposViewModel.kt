package org.example.teagithubkmp.presentatioin.repos

import androidx.lifecycle.SavedStateHandle
import org.example.teagithubkmp.domain.model.Repo
import org.example.teagithubkmp.domain.usecase.GetReposUseCase
import org.example.teagithubkmp.presentatioin.base.BaseViewModel

class ReposViewModel(
    private val getReposUseCase: GetReposUseCase,
    savedStateHandle: SavedStateHandle
) : BaseViewModel<ReposUiState, ReposUiEffect>(ReposUiState()), ReposInteractionListener {

    private val accessToken = ReposArgs(savedStateHandle).accessToken

    init {
        getRepos(accessToken)
    }

    private fun getRepos(accessToken: String) {
        updateState { it.copy(isError = false, isLoading = true) }
        tryToExecute(
            { getReposUseCase(accessToken) },
            ::onSuccessGetRepos,
            ::onError
        )
    }

    private fun onSuccessGetRepos(repos: List<Repo>) {
        updateState { it.copy(isLoading = false, repos = repos.map { it.toUIState() }) }
    }

    private fun onError(error: Exception) {
        print("onError: ${error.message}")
        updateState { it.copy(isError = true, isLoading = false) }
        sendEffect(ReposUiEffect.SendToast("Something went wrong. Please try again."))
    }

    override fun onClickTryAgain() {
        getRepos(accessToken)
    }
}