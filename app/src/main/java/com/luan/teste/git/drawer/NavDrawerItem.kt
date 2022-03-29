package com.luan.teste.git.drawer

sealed class NavDrawerItem(var route: String, var title: String) {
    object Repositories : NavDrawerItem("repositories", "Repositorios")
    object EmojiList : NavDrawerItem("avatarlist", "Avatares")
    object Profile : NavDrawerItem("profile", "Perfil")
}


fun provideDrawerItems() = listOf(
    NavDrawerItem.Repositories,
    NavDrawerItem.EmojiList,
    NavDrawerItem.Profile
)
