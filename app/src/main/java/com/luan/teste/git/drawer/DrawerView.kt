package com.luan.teste.git.drawer

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun DrawerView(
    scope: CoroutineScope, scaffoldState: ScaffoldState, navController: NavController
) {
    val items = provideDrawerItems()
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry.value?.destination?.route

    Column {
        items.forEach {
            DrawerItem(item = it, selected = it.route == currentRoute, onItemClick = { item ->
                navController.navigate(item.route) {
                    navController.graph.startDestinationRoute?.let { route ->
                        popUpTo(route) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                }
                scope.launch { scaffoldState.drawerState.close() }
            })
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "Developed by Luan",
            color = Color.Black,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(12.dp)
        )
    }
}

@Composable
fun DrawerItem(item: NavDrawerItem, selected: Boolean, onItemClick: (NavDrawerItem) -> Unit) {
    val background = if (selected) Color.Gray.copy(alpha = 0.15f) else Color.White
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = { onItemClick(item) })
            .height(45.dp)
            .background(background)
            .padding(start = 16.dp, top = 16.dp)
    ) {
        Text(
            text = item.title,
            fontSize = 16.sp,
            color = Color.Black
        )
    }
}