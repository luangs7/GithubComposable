package com.luan.teste.git.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.luan.teste.designsystem.ui.theme.AppTheme
import com.luan.teste.designsystem.ui.theme.TopBar
import com.luan.teste.git.drawer.DrawerView
import com.luan.teste.git.drawer.NavDrawerItem
import com.luan.teste.git.drawer.Navigation
import com.luan.teste.presentation.profile.details.ProfileNavItem

@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
              MainView {
                  onBackPressed()
              }
            }
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun MainView(
    onNavigationBack: () -> Unit
) {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()
    val currentBackStackEntry = navController.currentBackStackEntryAsState()
    val isMenu = currentBackStackEntry.value?.destination?.route?.contains(ProfileNavItem.ProfileDetails.route)?.not() ?: true
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopBar(
            scope = scope,
            scaffoldState = scaffoldState,
            isMenu = isMenu,
            hasBack = isMenu.not(),
            navigationIconClick = { onNavigationBack.invoke() }
        ) },
        drawerBackgroundColor = Color.White,
        drawerScrimColor = Color.Black.copy(alpha = 0.4f),
        drawerContent = {
           DrawerView(scope = scope, scaffoldState = scaffoldState, navController = navController)
        },
    ) {
        Navigation(navController = navController)
    }

}

@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppTheme {
        MainView{

        }
    }
}