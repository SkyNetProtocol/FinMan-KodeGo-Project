package com.example.finman1.database.relations

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "income_table")
data class IncomeTable(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "incomeType") val incomeType: String,
    @ColumnInfo(name = "quantity") val quantity: String,
    @ColumnInfo(name = "date") val date: String,
    @ColumnInfo(name = "resource") val resource: String

)
