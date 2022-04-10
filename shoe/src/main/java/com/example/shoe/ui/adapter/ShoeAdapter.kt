package com.example.shoe.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.launcher.ARouter
import com.example.shoe.databinding.ShoeRecyclerItemBinding
import com.example.shoe.ui.activity.DetailActivity
import com.wj.common.constant.BaseConstant
import com.wj.common.constant.UrlConstant

/**
 * 鞋子的适配器 配合Data Binding使用
 */
class ShoeAdapter constructor(val context: Context) :
        PagingDataAdapter<com.example.service.db.data.Shoe, ShoeAdapter.ViewHolder>(ShoeDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
                ShoeRecyclerItemBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false
                )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val shoe = getItem(position)
        holder.apply {
            bind(onCreateListener(shoe!!.id, shoe.imageUrl), shoe)
            itemView.tag = shoe
        }
    }

    /**
     * Holder的点击事件
     */
private fun onCreateListener(id: Long, url: String): View.OnClickListener {
    return View.OnClickListener {
        val transitionName = "${id}-${url}"
        it.transitionName = transitionName
        ARouter.getInstance().build(UrlConstant.DETAIL_URL)
            .withLong(BaseConstant.DETAIL_SHOE_ID, id)
            .withString(BaseConstant.CUS_TRANSITION_NAME, transitionName)
            .navigation()
        // DetailActivity.start(context, id, it as ConstraintLayout, transitionName)
    }
}


    class ViewHolder(private val binding: ShoeRecyclerItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: View.OnClickListener, item: com.example.service.db.data.Shoe) {
            binding.apply {
                this.listener = listener
                // this.ivShoe.setOnClickListener(listener)
                this.shoe = item
                executePendingBindings()
            }
        }
    }
}