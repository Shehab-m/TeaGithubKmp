package org.example.teagithubkmp.presentatioin.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.example.teagithubkmp.presentatioin.auth.navigateToAuthScreen
import org.example.teagithubkmp.presentatioin.base.EventHandler
import org.example.teagithubkmp.presentatioin.repos.navigateToReposScreen
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SplashScreen(viewModel: SplashViewModel = koinViewModel()) {
    EventHandler(effect = viewModel.effect) { effect, navController ->
        when (effect) {
            SplashUiEffect.NavigateToAuthScreen -> {
                navController.navigateToAuthScreen()
            }

            is SplashUiEffect.NavigateToReposScreen -> {
                navController.navigateToReposScreen(effect.accessToken)
            }
        }
    }
    SplashContent()
}

@Composable
fun SplashContent() {
    val iconAlpha = remember { Animatable(0f) }
    LaunchedEffect(Unit) {
        iconAlpha.animateTo(1f, animationSpec = tween(1500))
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue),
        contentAlignment = Alignment.Center
    ) {
//        Icon(
//            modifier = Modifier.size(280.dp).alpha(iconAlpha.value),
//            painter = painterResource(id = R.drawable.github_logo),
//            contentDescription = stringResource(R.string.splash_icon),
//            tint = MaterialTheme.colorScheme.background
//        )
    }
}

@Composable
@Preview
fun SplashScreenPreview() {
//    TeaGithubTheme {
        SplashContent()
//    }
}
