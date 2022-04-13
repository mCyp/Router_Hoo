package com.example.service.db.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import androidx.paging.PagingSource
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.entity.data.Shoe
import com.example.service.db.AppDataBase
import com.example.service.db.dao.ShoeDao
import com.wj.common.constant.UrlConstant
import com.wj.common.service.ShoeService

@Route(path = UrlConstant.SERVICE_SHOE)
class ShoeRepository constructor(): ShoeService {
    private lateinit var shoeDao: ShoeDao

    /**
     * 通过id的范围寻找鞋子
     */
    override fun getPageShoes(startIndex: Long, endIndex: Long): List<Shoe> =
        shoeDao.findShoesByIndexRange(startIndex, endIndex)

    /**
     * 通过Id查询一双鞋
     */
    override fun getShoeById(id: Long):LiveData<Shoe> = shoeDao.findShoeByIdLD(id)

    /**
     * 查询用户收藏的鞋
     */
    override fun getShoesByUserId(userId: Long): LiveData<List<Shoe>> = shoeDao.findShoesByUserId(userId)

    /**
     * 插入鞋子的集合
     */
    override fun insertShoes(shoes: List<Shoe>) = shoeDao.insertShoes(shoes)

    override fun getAllShoesPagingSource(): PagingSource<Int, Shoe> = shoeDao.getAllShoesLD()

    override fun getShoesByBrandPagingSource(brand: Array<String>): PagingSource<Int, Shoe> =
        shoeDao.findShoesByBrandLD(brand)

    override fun init(context: Context) {
        shoeDao = AppDataBase.getInstance(context).shoeDao()
    }
}