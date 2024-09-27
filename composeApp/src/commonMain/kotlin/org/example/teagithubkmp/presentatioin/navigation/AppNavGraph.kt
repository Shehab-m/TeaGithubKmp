package org.example.teagithubkmp.presentatioin.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.teacomputers.teagithub.presentation.navigation.Screens
import org.example.teagithubkmp.presentatioin.repos.reposRoute
import org.example.teagithubkmp.presentatioin.splash.splashRoute
import org.example.teagithubkmp.presentatioin.auth.authRoute

fun NavGraphBuilder.appNavGraph() {
    navigation(
        startDestination = Screens.SplashScreen.route,
        route = Graph.APP
    ) {
        authRoute()
        reposRoute()
        splashRoute()
    }
}