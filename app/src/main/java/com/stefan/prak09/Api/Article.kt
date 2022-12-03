package com.stefan.prak09.Api

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * @author Vina Anjelina - 2072022
 * **
 */

@Parcelize
data class Article(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String
) : Parcelable