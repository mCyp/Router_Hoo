package com.example.login.viewmodel.factory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.login.viewmodel.LoginModel
import com.example.service.db.repository.UserRepository

class LoginModelFactory(
    private val repository: UserRepository
    , private val context: Context
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginModel(repository) as T
    }
}