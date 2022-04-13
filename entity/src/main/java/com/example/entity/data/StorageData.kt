package com.example.entity.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * 存储优化中用来测试的表
 */
@Entity(tableName = "storage_data")
data class StorageData(
    @PrimaryKey(autoGenerate = false) var id: String = "",
    @ColumnInfo(name = "storage_value") var value: String = ""
)