package com.wj.common.service

import androidx.lifecycle.LiveData
import com.alibaba.android.arouter.facade.template.IProvider
import com.example.entity.data.User

interface UserService : IProvider {
    fun findUserById(id: Long): LiveData<User>
    fun login(account: String, pwd: String): LiveData<User?>
    suspend fun updateUser(user: User)
    suspend fun register(email: String, account: String, pwd: String): Long
}