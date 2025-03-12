package com.megmilk.jetpackcomposepractice.ui.theme

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.megmilk.jetpackcomposepractice.ui.screen.DetailScreen
import com.megmilk.jetpackcomposepractice.ui.screen.TopScreen

enum class Screen(val route: String, val title: String) {
    TOP("top", "トップ"),
    DETAIL("detail", "詳細"),
}

class Navigation {
    companion object {
        @Composable
        fun Destination(navController: NavHostController) {
            NavHost(
                navController = navController,
                startDestination = Screen.TOP.route
            ) {
                composable(
                    route = Screen.TOP.route,
                ) {
                    TopScreen(Screen.TOP.title) {
                        navController.navigate("${Screen.DETAIL.route}/送りたいパラメータ")
                    }
                }
                composable(
                    route = "${Screen.DETAIL.route}/{text}",
                    arguments = listOf(
                        navArgument("text") { type = NavType.StringType },
                    )
                ) { backStackEntry ->
                    val text = backStackEntry.arguments?.getString("text") ?: ""
                    DetailScreen(Screen.DETAIL.title, text) {
                        navController.navigateUp()
                    }
                }
            }
        }
    }
}