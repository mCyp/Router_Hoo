package com.example.login.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.login.viewmodel.RegisterModel
import com.example.service.db.repository.UserRepository

class RegisterModelFactory(
    private val repository: UserRepository
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return RegisterModel(repository) as T
    }
}