package com.ch.readease.presentation.news

import android.os.Bundle
import androidx.lifecycle.ViewModel
import com.ch.readease.model.News

class NewsViewModel(private val extras: Bundle?) : ViewModel() {
    val news = extras?.getParcelable<News>(NewsActivity.NEWS_KEY)
}