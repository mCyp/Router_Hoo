package com.example.service.db.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.service.db.AppDataBase
import com.example.service.db.dao.StorageDataDao
import com.example.service.db.dao.UserDao
import com.example.service.db.data.StorageData
import com.example.service.db.data.User
import com.example.service.db.provider.StorageService
import com.wj.common.constant.UrlConstant
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext

/**
 * StorageData 仓库
 */
@Route(path = UrlConstant.SERVICE_STORAGE)
class StorageDataRepository constructor():
    StorageService {

    private lateinit var storageDataDao: StorageDataDao

    override fun insertOneStorageData(data: StorageData){
        storageDataDao.insertStorageData(data)
    }

    override fun findStorageDataById(id: String): StorageData? {
        return storageDataDao.findStorageDataByKey(id)
    }

    override fun init(context: Context) {
        storageDataDao = AppDataBase.getInstance(context).storageDataDao()
    }

}