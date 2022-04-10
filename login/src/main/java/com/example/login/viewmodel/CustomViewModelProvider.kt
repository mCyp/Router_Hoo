package com.example.login.viewmodel

import android.content.Context
import com.example.login.viewmodel.factory.LoginModelFactory
import com.example.login.viewmodel.factory.RegisterModelFactory

/**
 * ViewModel提供者
 */
object CustomViewModelProvider {

    fun providerRegisterModel(context: Context): RegisterModelFactory {
        val repository: com.example.service.db.repository.UserRepository = com.example.service.db.RepositoryProvider.providerUserRepository(context)
        return RegisterModelFactory(repository)
    }

    fun providerLoginModel(context: Context): LoginModelFactory {
        val repository: com.example.service.db.repository.UserRepository = com.example.service.db.RepositoryProvider.providerUserRepository(context)
        return LoginModelFactory(repository, context)
    }
}