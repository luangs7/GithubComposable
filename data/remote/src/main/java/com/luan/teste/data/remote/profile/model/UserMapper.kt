package com.luan.teste.data.remote.profile.model

import com.luan.teste.data.repository.profile.model.UserData

fun UserResponse.toRepo():UserData{
    return UserData(
        avatarUrl = avatarUrl,
        bio = bio.orEmpty(),
        url = htmlUrl,
        blog = blog.orEmpty(),
        company = company.orEmpty(),
        email = email.orEmpty(),
        followers = followers,
        following = following,
        id = id,
        location = location.orEmpty(),
        login = login.orEmpty(),
        name = name.orEmpty(),
        twitterUsername = twitterUsername.orEmpty()
    )
}