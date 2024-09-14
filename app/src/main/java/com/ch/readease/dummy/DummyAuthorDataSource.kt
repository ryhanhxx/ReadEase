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
                name = "Bitcoin",
                imgUrl = "https://raw.githubusercontent.com/ryhanhxx/ReadEase_Asset/main/ic_bitcoin.png"
            ),
            Author(
                name = "Tesla",
                imgUrl = "https://raw.githubusercontent.com/ryhanhxx/ReadEase_Asset/main/ic_tesla.png"
            ),
            Author(
                name = "Apple",
                imgUrl = "https://raw.githubusercontent.com/ryhanhxx/ReadEase_Asset/main/ic_apple.png"
            ),
            Author(
                name = "Wall Street Journal",
                imgUrl = "https://raw.githubusercontent.com/ryhanhxx/ReadEase_Asset/main/ic_wsj.png"
            ),
        )
    }
}