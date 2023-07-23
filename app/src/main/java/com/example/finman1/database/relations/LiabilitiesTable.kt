package com.example.finman1.database.relations

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "liability_table")
data class LiabilitiesTable(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "liabilityType") val liabilityType: String,
    @ColumnInfo(name = "quantity") val quantity: String,
    @ColumnInfo(name = "date") val date: String,
    @ColumnInfo(name = "particulars") val particulars: String
)
