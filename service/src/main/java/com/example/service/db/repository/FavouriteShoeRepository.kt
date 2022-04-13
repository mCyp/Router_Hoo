package com.example.service.db.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.entity.data.FavouriteShoe
import com.example.service.db.AppDataBase
import com.example.service.db.dao.FavouriteShoeDao
import com.example.service.db.dao.ShoeDao
import com.wj.common.constant.UrlConstant
import com.wj.common.service.FavouriteShoeService
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import java.util.*

@Route(path = UrlConstant.SERVICE_FAV_SHOE)
class FavouriteShoeRepository constructor():
    FavouriteShoeService {

    private lateinit var favouriteShoeDao: FavouriteShoeDao

    /**
     * 查看某个用户是否有喜欢记录
     */
    override fun findFavouriteShoe(userId:Long,shoeId:Long):LiveData<FavouriteShoe?>
            = favouriteShoeDao.findFavouriteShoeByUserIdAndShoeId(userId, shoeId)

    /**
     * 收藏一双鞋
     */
    override suspend fun createFavouriteShoe(userId:Long,shoeId: Long){
        withContext(IO){
            favouriteShoeDao.insertFavouriteShoe(FavouriteShoe(shoeId,userId, Calendar.getInstance()))
        }
    }

    override fun init(context: Context) {
        favouriteShoeDao = AppDataBase.getInstance(context).favouriteShoeDao()
    }

}