package org.example.teagithubkmp.presentatioin.base

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import org.example.teagithubkmp.presentatioin.navigation.LocalNavigationProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest

@Composable
fun <E : BaseUiEffect> EventHandler(
    effect: Flow<E>,
    navHostController: NavHostController = LocalNavigationProvider.current,
    function: (E, NavHostController) -> Unit,
) {

    LaunchedEffect(key1 = Unit) {
        effect.collectLatest { effect ->
            function(effect, navHostController)
        }
    }
}