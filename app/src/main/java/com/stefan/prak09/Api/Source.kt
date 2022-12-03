package com.stefan.prak09.Api

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * @author Vina Anjelina - 2072022
 * **
 */

@Parcelize
data class Source(
    @SerializedName ("id") val id: String,
    @SerializedName ("name") val name: String
) : Parcelable