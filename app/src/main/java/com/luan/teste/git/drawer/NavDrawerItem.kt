package com.luan.teste.git.drawer

import com.luan.estar.navigation.DestinationDrawer
import com.luan.estar.navigation.Destinations

sealed class NavDrawerItem(var route: String, var title: String) {
    object Repositories : NavDrawerItem(Destinations.Repositories, DestinationDrawer.Repositories)
    object EmojiList : NavDrawerItem(Destinations.EmojiList, DestinationDrawer.EmojiList)
    object Profile : NavDrawerItem(Destinations.Profile, DestinationDrawer.Profile)
}


fun provideDrawerItems() = listOf(
    NavDrawerItem.Repositories,
    NavDrawerItem.EmojiList,
    NavDrawerItem.Profile
)
