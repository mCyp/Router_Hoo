package com.example.entity.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * 鞋表
 */
@Entity(tableName = "shoe")
data class Shoe(
    @ColumnInfo(name = "shoe_name") var name: String = ""
    , @ColumnInfo(name = "shoe_description") var description: String = ""
    , @ColumnInfo(name = "shoe_price") var price: Float = 0f
    , @ColumnInfo(name = "shoe_brand") var brand: String = ""
    , @ColumnInfo(name = "shoe_imgUrl") var imageUrl: String = ""
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0

    fun getPriceStr():String{
        return price.toString()
    }
}