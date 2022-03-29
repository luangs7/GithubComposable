package com.luan.teste.data.repository.profile.model

import com.luan.teste.domain.model.profile.User

fun UserData.toDomain(): User {
    return User(
        avatar = avatarUrl,
        bio = bio,
        url = url,
        blog = blog,
        company = company,
        email = email,
        followers = followers,
        following = following,
        id = id,
        location = location,
        login = login,
        name = name,
        twitter_username = twitterUsername
    )
}

fun User.toRepo(): UserData {
    return UserData(
        avatarUrl = avatar,
        bio = bio,
        url = url,
        blog = blog,
        company = company,
        email = email,
        followers = followers,
        following = following,
        id = id,
        location = location,
        login = login,
        name = name,
        twitterUsername = twitter_username
    )
}