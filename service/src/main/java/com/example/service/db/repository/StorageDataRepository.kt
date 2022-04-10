package com.example.service.db.repository

import androidx.lifecycle.LiveData
import com.example.service.db.dao.StorageDataDao
import com.example.service.db.dao.UserDao
import com.example.service.db.data.StorageData
import com.example.service.db.data.User
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext

/**
 * StorageData 仓库
 */
class StorageDataRepository private constructor(private val storageDataDao: StorageDataDao) {

    /**
     * 获取所有的数据
     */
    fun getAllStorageData() = storageDataDao.getAllStorageData()

    fun insertAllStorageData(data: List<StorageData>) {
        storageDataDao.insertStorageData(data)
    }

    fun insertOneStorageData(data: StorageData){
        storageDataDao.insertStorageData(data)
    }

    fun findStorageDataById(id: String): StorageData? {
        return storageDataDao.findStorageDataByKey(id)
    }


    companion object {
        @Volatile
        private var instance: StorageDataRepository? = null

        fun getInstance(storageDataDao: StorageDataDao): StorageDataRepository =
            instance ?: synchronized(this) {
                instance
                    ?: StorageDataRepository(storageDataDao).also {
                    instance = it
                }
            }

    }
}