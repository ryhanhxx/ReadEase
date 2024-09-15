package com.ch.readease.model.response


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class NewsResponse(
    @SerializedName("articles")
    val articles: MutableList<Article>,
    @SerializedName("status")
    val status: String?,
    @SerializedName("totalResults")
    val totalResults: Int?
)