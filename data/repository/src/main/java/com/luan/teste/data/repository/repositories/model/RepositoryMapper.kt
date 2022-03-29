package com.luan.teste.data.repository.repositories.model

import com.luan.teste.domain.model.repositories.Owner
import com.luan.teste.domain.model.repositories.Repository

fun RepositoryData.toDomain(): Repository {
    return Repository(
        id = id,
        name = name,
        fullName = fullName,
        owner = owner.toDomain(),
        description = description,
        starCount= starCount
    )
}

fun OwnerData.toDomain(): Owner {
    return Owner(
        username = login,
        id = id,
        avatar = avatarUrl
    )
}

fun Repository.toRepo(): RepositoryData {
    return RepositoryData(
        id = id,
        name = name,
        fullName = fullName,
        owner = owner.toRepo(),
        description = description,
        starCount = starCount
    )
}

fun Owner.toRepo(): OwnerData {
    return OwnerData(
        login = username,
        id = id,
        avatarUrl = avatar,
        type = "user",
        url = String()
    )
}
