package com.example.login.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.launcher.ARouter
import com.wj.common.service.UserService
import kotlinx.coroutines.launch

class RegisterModel constructor() : ViewModel() {

    init {
        ARouter.getInstance().inject(this)
    }

    @JvmField
    @Autowired
    var repository: UserService? = null

    val n = MutableLiveData("")
    val p = MutableLiveData("")
    val mail = MutableLiveData("")
    val enable = MutableLiveData(false)

    /**
     * 用户名改变回调的函数
     */
    fun onNameChanged(s: CharSequence) {
        //n.set(s.toString())
        n.value = s.toString()
        judgeEnable()
    }

    /**
     * 邮箱改变的时候
     */
    fun onEmailChanged(s: CharSequence) {
        //n.set(s.toString())
        mail.value = s.toString()
        judgeEnable()
    }

    /**
     * 密码改变的回调函数
     */
    fun onPwdChanged(s: CharSequence) {
        //p.set(s.toString())
        p.value = s.toString()
        judgeEnable()
    }

    private fun judgeEnable(){
        enable.value = p.value!!.isNotEmpty()
                && n.value!!.isNotEmpty()
                && mail.value!!.isNotEmpty()
    }

    fun register() {
        viewModelScope.launch {
            repository?.register(mail.value!!, n.value!!, p.value!!)
        }
    }

}