package com.luan.teste.data.profile.model

import com.luan.teste.domain.profile.User

fun UserResponse.toDomain():User{
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