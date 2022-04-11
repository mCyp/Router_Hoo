package com.example.service.db.provider

import androidx.lifecycle.LiveData
import androidx.paging.PagingSource
import com.alibaba.android.arouter.facade.template.IProvider
import com.example.service.db.data.Shoe

interface ShoeService: IProvider {
    fun getPageShoes(startIndex: Long, endIndex: Long): List<Shoe>
    fun getShoeById(id: Long):LiveData<Shoe>
    fun getShoesByUserId(userId: Long): LiveData<List<Shoe>>
    fun insertShoes(shoes: List<Shoe>)
    fun getAllShoesPagingSource(): PagingSource<Int, Shoe>
    fun getShoesByBrandPagingSource(brand: Array<String>): PagingSource<Int, Shoe>
}