package com.wj.common.service

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import androidx.paging.PagingSource
import com.alibaba.android.arouter.facade.template.IProvider
import com.example.entity.data.Shoe
import kotlinx.coroutines.flow.Flow

interface ShoeService: IProvider {
    fun getPageShoes(startIndex: Long, endIndex: Long): List<Shoe>
    fun getShoeById(id: Long):LiveData<Shoe>
    fun getShoesByUserId(userId: Long): LiveData<List<Shoe>>
    fun insertShoes(shoes: List<Shoe>)
    fun getAllShoesPagingSource(): PagingSource<Int, Shoe>
    fun getShoesByBrandPagingSource(brand: Array<String>): PagingSource<Int, Shoe>
}