package com.example.finman1.database.relations

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "assets_table")
data class AssetsTable(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "assetType") val assetType: String,
    @ColumnInfo(name = "quantity") val quantity: String,
    @ColumnInfo(name = "date") val date: String,
    @ColumnInfo(name = "particulars") val particulars: String
)
