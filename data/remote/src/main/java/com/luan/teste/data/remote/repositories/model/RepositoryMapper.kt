package com.luan.teste.data.remote.repositories.model

import com.luan.teste.data.repository.repositories.model.OwnerData
import com.luan.teste.data.repository.repositories.model.RepositoryData

fun RepositoryResponse.toRepo(): RepositoryData {
    return RepositoryData(
        id = id,
        name = name,
        fullName = fullName,
        owner = ownerResponseData.toRepo(),
        description = description ?: String(),
        starCount = stargazersCount
    )
}

fun OwnerResponse.toRepo(): OwnerData {
    return OwnerData(
        login = login,
        id = id,
        avatarUrl = avatarUrl,
        type = type,
        url = url
    )
}
