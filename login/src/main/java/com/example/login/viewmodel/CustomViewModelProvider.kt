package com.example.login.viewmodel

import com.example.login.viewmodel.factory.LoginModelFactory
import com.example.login.viewmodel.factory.RegisterModelFactory

/**
 * ViewModel提供者
 */
object CustomViewModelProvider {

    fun providerRegisterModel(): RegisterModelFactory {
        return RegisterModelFactory()
    }

    fun providerLoginModel(): LoginModelFactory {
        return LoginModelFactory()
    }
}