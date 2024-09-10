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
                imgUrl = "https://raw.githubusercontent.com/ryhanhxx/ReadEase/master/app/src/main/res/drawable/img_author_1.png"
            ),
            Author(
                name = "Author 2",
                imgUrl = "https://raw.githubusercontent.com/ryhanhxx/ReadEase/master/app/src/main/res/drawable/img_author_2.png"
            ),
            Author(
                name = "Author 3",
                imgUrl = "https://raw.githubusercontent.com/ryhanhxx/ReadEase/master/app/src/main/res/drawable/img_author_3.png"
            ),
            Author(
                name = "Author 4",
                imgUrl = "https://raw.githubusercontent.com/ryhanhxx/ReadEase/master/app/src/main/res/drawable/img_author_4.png"
            ),
            Author(
                name = "Author 5",
                imgUrl = "https://raw.githubusercontent.com/ryhanhxx/ReadEase/master/app/src/main/res/drawable/img_author_4.png"
            ),
        )
    }
}