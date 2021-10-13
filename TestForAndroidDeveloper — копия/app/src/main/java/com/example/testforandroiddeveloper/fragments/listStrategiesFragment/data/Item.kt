package com.example.testforandroiddeveloper.fragments.listStrategiesFragment.data

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Item (
    val id : Int,
    val title: String,
    @DrawableRes val image: Int,
    val text: String,
): Parcelable