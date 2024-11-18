package com.example.deportes

data class Sport(
    val name: String,
    val icon: Int,  // Resource ID of the image
    var isSelected: Boolean = false
)
