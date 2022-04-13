package com.example.service.db.dao

import androidx.room.*
import com.example.entity.data.StorageData

/**
 * StorageData的Dao
 */
@Dao
interface StorageDataDao {
    @Query("SELECT * FROM storage_data WHERE id=:key")
    fun findStorageDataByKey(key: String): StorageData?

    @Query("SELECT * FROM storage_data")
    fun getAllStorageData(): List<StorageData>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertStorageData(data: StorageData)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertStorageData(data: List<StorageData>)

    @Delete
    fun deleteStorageData(data: StorageData)

    @Update
    fun updateStorageData(data: StorageData)
}