package org.example.teagithubkmp.presentatioin.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.teacomputers.teagithub.presentation.auth.AuthUiState
import org.example.teagithubkmp.presentatioin.base.EventHandler
import org.example.teagithubkmp.presentatioin.composable.Loading
import com.teacomputers.teagithub.presentation.composable.TAnimationContent
import org.example.teagithubkmp.presentatioin.repos.navigateToReposScreen
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun AuthScreen() {
    val viewModel: AuthViewModel = koinViewModel()
//        viewModelStoreOwner = LocalContext.current as ComponentActivity
//    )
    val state by viewModel.state.collectAsState()
//    val context = LocalContext.current
    EventHandler(viewModel.effect) { effect, navController ->
        when (effect) {
//            is AuthUiEffect.HandleOauthIntent -> {
//                Toast.makeText(
//                    context,
//                    context.getString(R.string.opening_github_for_login),
//                    Toast.LENGTH_LONG
//                ).show()
//                context.startActivity(effect.intent)
//            }

            is AuthUiEffect.SendToast -> {
//                Toast.makeText(context, effect.message, Toast.LENGTH_LONG).show()
            }

            is AuthUiEffect.NavigateToReposScreen -> {
                navController.navigateToReposScreen(effect.accessToken)
            }
        }
    }

    AuthContent(state, viewModel)
}

@Composable
fun AuthContent(
    state: AuthUiState, listener: AuthInteractionListener
) {
    Scaffold { innerPadding ->
        TAnimationContent(
            state = state.isLoading,
            content = {
                Box(
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        modifier = Modifier
                            .padding(top = 36.dp)
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
//                        Icon(
//                            painter = painterResource(id = R.drawable.github_logo),
//                            contentDescription = "Github Icon",
//                            modifier = Modifier.size(56.dp),
//                            tint = MaterialTheme.colorScheme.secondary
//                        )
//                        Text(
//                            text = stringResource(R.string.welcome_to_github),
//                            style = MaterialTheme.typography.titleLarge,
//                            color = MaterialTheme.colorScheme.secondary,
//                        )
                    }
//                    TFilledButton(
//                        label = stringResource(R.string.login),
//                        onClick = listener::onClickLogin,
//                        textStyle = MaterialTheme.typography.labelLarge
//                    )
                }
            },
            loadingContent = { Loading(state = state.isLoading) },
        )
    }
}

@Composable
@Preview
fun AuthScreenPreview() {
//    TeaGithubTheme {
        AuthContent(
            state = AuthUiState(),
            listener = object : AuthInteractionListener {
                override fun onClickLogin() {}
            }
        )
//    }
}
