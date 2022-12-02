package com.developer.week1.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    var dateOfBirt : String? = "",
    val testType : String? = ""
) :Parcelable
