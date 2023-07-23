package com.example.finman1.database.relations

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "balanceSheet_table")
data class BalanceSheetTable(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "totalLiability") val totalLiabilities: String,
    @ColumnInfo(name = "totalAssets") val totalAssets: String,
    @ColumnInfo(name = "date") val date: String,

)
