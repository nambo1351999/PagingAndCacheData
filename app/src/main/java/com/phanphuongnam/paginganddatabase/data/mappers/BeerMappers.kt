package com.phanphuongnam.paginganddatabase.data.mappers

import com.phanphuongnam.paginganddatabase.data.local.BeerEntity
import com.phanphuongnam.paginganddatabase.data.remote.BeerDto
import com.phanphuongnam.paginganddatabase.domain.Beer

fun BeerDto.toBeerEntity(): BeerEntity {
    return BeerEntity(
        id = id,
        name = name,
        tagline = tagline,
        description = description,
        firstBrewed = first_brewed,
        imageUrl = image_url
    )
}

fun BeerEntity.toBeer(): Beer {
    return Beer(
        id = id,
        name = name,
        tagline = tagline,
        description = description,
        firstBrewed = firstBrewed,
        imageUrl = imageUrl
    )
}