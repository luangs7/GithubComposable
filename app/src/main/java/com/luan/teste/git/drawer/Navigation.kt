package com.luan.teste.git.drawer

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.luan.teste.presentation.emoji.EmojiListView
import com.luan.teste.presentation.profile.details.ProfileNavItem
import com.luan.teste.presentation.profile.details.ProfileView
import com.luan.teste.presentation.profile.search.ProfileSearchView
import com.luan.teste.presentation.repositories.RepoListView

@ExperimentalFoundationApi
@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = NavDrawerItem.Repositories.route) {
        composable(NavDrawerItem.Repositories.route) {
            RepoListView()
        }

        composable(NavDrawerItem.EmojiList.route) {
            EmojiListView()
        }

        composable(NavDrawerItem.Profile.route) {
            ProfileSearchView(navController)
        }

        composable("${ProfileNavItem.ProfileDetails.route}/{username}",
            arguments = listOf(navArgument("username") { type = NavType.StringType })
        ) { backStackEntry ->
            backStackEntry.arguments?.getString("username")?.let {
                ProfileView(username = it)
            }
        }

    }
}