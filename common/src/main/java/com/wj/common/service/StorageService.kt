package com.wj.common.service

import com.alibaba.android.arouter.facade.template.IProvider
import com.example.entity.data.StorageData

interface StorageService : IProvider {
    fun insertOneStorageData(data: StorageData)
    fun findStorageDataById(id: String): StorageData?
}