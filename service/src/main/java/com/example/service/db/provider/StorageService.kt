package com.example.service.db.provider

import com.alibaba.android.arouter.facade.template.IProvider
import com.example.service.db.data.StorageData

interface StorageService : IProvider {
    fun insertOneStorageData(data: StorageData)
    fun findStorageDataById(id: String): StorageData?
}