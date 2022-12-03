package com.stefan.prak09.Api

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * @author Stefanus - 2072013
 * **
 */

@Parcelize
data class ArticlesJson(
    @SerializedName ("articles") val articles: ArrayList<Article>,
    @SerializedName ("status") val status: String,
    @SerializedName ("totalResults") val totalResults: Int
) :Parcelable