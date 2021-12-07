package com.example.library.models

data class Material(
    val authors: List<Author>,
    val authorsIds: List<String>,
    val categories: List<Category>,
    val categoriesIds: List<String>,
    val description: String,
    val genres: List<Genre>,
    val genresIds: List<String>,
    val id: String,
    val image: Image,
    val imageId: String,
    val isbn: String,
    val materialCopiesIds: List<String>,
    val pageNumber: Int,
    val publishersIds: List<String>,
    val publishers: List<Publisher>,
    val title: String
)