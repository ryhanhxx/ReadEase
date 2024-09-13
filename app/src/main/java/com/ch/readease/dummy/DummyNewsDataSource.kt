package com.ch.readease.dummy

import com.ch.readease.model.News

interface DummyNewsDataSource {
    fun getNewsData(): List<News>
}

class DummyNewsDataSourceImpl() : DummyNewsDataSource {
    override fun getNewsData(): List<News> {
        return mutableListOf(
            News(
                title = "Judul Artikel 1",
                content = "Isi artikel 1",
                author = "Author 1",
                imgUrl = "https://example.com/image2.jpg"
            ),
            News(
                title = "Judul Artikel 2",
                content = "Isi artikel 2",
                author = "Author 2",
                imgUrl = "https://example.com/image2.jpg"
            ),
            News(
                title = "Judul Artikel 3",
                content = "Isi artikel 3",
                author = "Author 3",
                imgUrl = "https://example.com/image2.jpg"
            ),
            News(
                title = "Judul Artikel 4",
                content = "Isi artikel 4",
                author = "Author 4",
                imgUrl = "https://example.com/image2.jpg"
            ),
            News(
                title = "Judul Artikel 5",
                content = "Isi artikel 5",
                author = "Author 5",
                imgUrl = "https://example.com/image2.jpg"
            ),
            News(
                title = "Judul Artikel 6",
                content = "Isi artikel 6",
                author = "Author 6",
                imgUrl = "https://example.com/image2.jpg"
            ),
        )
    }
}