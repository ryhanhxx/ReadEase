package com.ch.readease.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "newses")
data class NewsEntity (
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
)