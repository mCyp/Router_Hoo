package com.example.shoe.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.shoe.databinding.FavouriteRecyclerItemBinding
import com.wj.common.constant.BaseConstant
import com.example.shoe.ui.activity.DetailActivity

/**
 * 收藏记录的适配器
 */
class FavouriteAdapter constructor(val context: Context) : ListAdapter<com.example.entity.data.Shoe, FavouriteAdapter.FavouriteViewHolder>(ShoeDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteViewHolder {
        return FavouriteViewHolder(
            FavouriteRecyclerItemBinding.inflate(
                LayoutInflater.from(parent.context)
                , parent
                , false
            )
        )
    }

    override fun onBindViewHolder(holder: FavouriteViewHolder, position: Int) {
        val shoe = getItem(position)
        holder.apply {
            bind(onCreateListener(shoe.id), shoe)
            itemView.tag = shoe
        }
    }

    /**
     * FavouriteViewHolder的点击事件
     */
    private fun onCreateListener(id: Long): View.OnClickListener {
        return View.OnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(BaseConstant.DETAIL_SHOE_ID, id)
            context.startActivity(intent)
        }
    }


    class FavouriteViewHolder(private val binding: FavouriteRecyclerItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: View.OnClickListener, item: com.example.entity.data.Shoe) {
            binding.apply {
                this.listener = listener
                this.shoe = item
                executePendingBindings()
            }
        }
    }
}