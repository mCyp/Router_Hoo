package com.example.shoe.ui.adapter

import androidx.recyclerview.widget.DiffUtil

class ShoeDiffCallback: DiffUtil.ItemCallback<com.example.entity.data.Shoe>() {
    override fun areItemsTheSame(oldItem: com.example.entity.data.Shoe, newItem: com.example.entity.data.Shoe): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: com.example.entity.data.Shoe, newItem: com.example.entity.data.Shoe): Boolean {
        return oldItem == newItem
    }
}