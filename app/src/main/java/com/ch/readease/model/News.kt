package com.ch.readease.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.UUID

@Parcelize
data class News(
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val content: String,
    val author: String,
    val imgUrl: String
) : Parcelable
