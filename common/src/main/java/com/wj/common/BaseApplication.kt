package com.wj.common

import android.app.Application
import android.content.Context
import android.util.Log
import com.alibaba.android.arouter.launcher.ARouter
import com.tencent.mmkv.MMKV
import com.tencent.mmkv.MMKVLogLevel

open class BaseApplication :Application(){

    override fun onCreate() {
        super.onCreate()
        context = this

        // MMKV 初始化
        val root = context.filesDir.absolutePath + "/mmkv"
        MMKV.initialize(root, MMKVLogLevel.LevelInfo)

        ARouter.openLog()
        ARouter.openDebug()
        ARouter.init(this)
        Log.d("wangjie","ARouter 初始化成功")
    }

    companion object {
        lateinit var context: Context
    }
}