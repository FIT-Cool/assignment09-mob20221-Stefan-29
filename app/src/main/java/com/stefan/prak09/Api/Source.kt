package com.stefan.prak09.Api

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * @author Vina Anjelina - 2072022
 * **
 */

@Parcelize
data class Source(
    val id: String,
    val name: String
) : Parcelable