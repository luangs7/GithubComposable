package com.luan.teste.git.drawer

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.luan.estar.navigation.DestinationArgs
import com.luan.teste.presentation.emoji.EmojiListView
import com.luan.teste.presentation.profile.details.ProfileNavItem
import com.luan.teste.presentation.profile.details.ProfileView
import com.luan.teste.presentation.profile.search.ProfileSearchView
import com.luan.teste.presentation.repositories.RepoListView
import com.luan.teste.presentation.repositories.RepoListViewModel
import org.koin.androidx.compose.getViewModel

@ExperimentalFoundationApi
@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = NavDrawerItem.Repositories.route) {
        composable(NavDrawerItem.Repositories.route) {
            RepoListView(getViewModel())
        }

        composable(NavDrawerItem.EmojiList.route) {
            EmojiListView(getViewModel())
        }

        composable(NavDrawerItem.Profile.route) {
            ProfileSearchView(navController, getViewModel())
        }

        composable(ProfileNavItem.ProfileDetails.route,
            arguments = listOf(navArgument(DestinationArgs.Username) { type = NavType.StringType })
        ) { backStackEntry ->
            backStackEntry.arguments?.getString(DestinationArgs.Username)?.let {
                ProfileView(getViewModel(), username = it)
            }
        }

    }
}