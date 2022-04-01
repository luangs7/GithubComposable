package com.luan.estar.navigation

object Destinations {
    const val Repositories = "repositories"
    const val EmojiList = "emojilist"
    const val Profile = "profile"
    const val ProfileDetails = "profile/details/{${DestinationArgs.Username}}"
}

object DestinationArgs {
    const val Username = "username"
}

object DestinationDrawer {
    const val Repositories = "Repositorios"
    const val EmojiList = "Avatares"
    const val Profile = "Perfil"
    const val ProfileDetails = "Details"
}

object DestinationDeepLink {
    fun passUsername(username: String) = "profile/details/$username"
}