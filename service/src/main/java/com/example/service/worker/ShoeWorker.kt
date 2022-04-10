package com.example.service.worker

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.wj.common.constant.BaseConstant
import com.wj.common.util.AppPrefsUtils
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import java.lang.Exception

class ShoeWorker(
    context: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {

    private val TAG by lazy {
        ShoeWorker::class.java.simpleName
    }

    // 指定Dispatchers
    override val coroutineContext: CoroutineDispatcher
        get() = Dispatchers.IO

    override suspend fun doWork(): Result = coroutineScope {
        try {
            applicationContext.assets.open("shoes.json").use {
                JsonReader(it.reader()).use {
                    val shoeType = object : TypeToken<List<com.example.service.db.data.Shoe>>() {}.type
                    val shoeList: List<com.example.service.db.data.Shoe> = Gson().fromJson(it, shoeType)

                    val shoeDao = com.example.service.db.RepositoryProvider.providerShoeRepository(applicationContext)
                    shoeDao.insertShoes(shoeList)
                    for (i in 0..6) {
                        for (shoe in shoeList) {
                            shoe.id += shoeList.size
                        }
                        shoeDao.insertShoes(shoeList)
                    }
                    AppPrefsUtils.putBoolean(BaseConstant.IS_FIRST_LAUNCH,false)
                    Result.success()
                }

            }
        } catch (ex: Exception) {
            Log.e(TAG, "Error seeding database", ex)
            Result.failure()
        }
    }
}