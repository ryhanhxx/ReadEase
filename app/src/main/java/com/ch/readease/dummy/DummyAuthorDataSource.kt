package com.ch.readease.dummy

import com.ch.readease.R
import com.ch.readease.model.Author

interface DummyAuthorDataSource {
    fun getAuthorData(): List<Author>
}

class DummyAuthorDataSourceImpl() : DummyAuthorDataSource {
    override fun getAuthorData(): List<Author> {
        return mutableListOf(
            Author(
                name = "Author 1",
                imageUrl = R.drawable.img_author_1.toString()
            ),
            Author(
                name = "Author 2",
                imageUrl = R.drawable.img_author_2.toString()
            ),
            Author(
                name = "Author 3",
                imageUrl = R.drawable.img_author_3.toString()
            ),
            Author(
                name = "Author 4",
                imageUrl = R.drawable.img_author_4.toString()
            ),
        )
    }
}