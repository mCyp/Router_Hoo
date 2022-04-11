package com.example.service.db.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.service.db.AppDataBase
import com.example.service.db.dao.UserDao
import com.example.service.db.data.User
import com.example.service.db.provider.UserService
import com.wj.common.constant.UrlConstant
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext

/**
 * 用户处理仓库
 */
@Route(path = UrlConstant.SERVICE_USER)
class UserRepository constructor(): UserService {

    private lateinit var userDao: UserDao
    /**
     * 根据id选择用户
     */
    override fun findUserById(id:Long):LiveData<User>
            = userDao.findUserById(id)

    /**
     * 登录用户
     */
    override fun login(account: String, pwd: String):LiveData<User?>
            = userDao.login(account,pwd)

    /**
     * 更新用户
     */
    override suspend fun updateUser(user: User) {
        withContext(IO){
            userDao.updateUser(user)
        }
    }

    /**
     * 注册一个用户
     */
    override suspend fun register(email: String, account: String, pwd: String):Long {
        return withContext(IO) {
             userDao.insertUser(User(account, pwd, email,"https://raw.githubusercontent.com/mCyp/Photo/master/1560651318109.jpeg"))
        }
    }

    override fun init(context: Context) {
        userDao = AppDataBase.getInstance(context).userDao()
    }
}