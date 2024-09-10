package com.ch.readease.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.UUID

@Parcelize
data class Author(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val imgUrl: String,
) : Parcelable
