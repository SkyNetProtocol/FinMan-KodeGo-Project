package com.example.finman1.database.relations

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "expense_table")
data class ExpensesTable(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "expenseType") val expenseType: String,
    @ColumnInfo(name = "quantity") val quantity: String,
    @ColumnInfo(name = "date") val date: String,
    @ColumnInfo(name = "particulars") val particulars: String
)
