package com.luan.teste.data.remote.profile.model

import com.luan.teste.data.repository.profile.model.UserData

fun UserResponse.toRepo():UserData{
    return UserData(
        avatarUrl = avatarUrl,
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
        twitterUsername = twitterUsername
    )
}