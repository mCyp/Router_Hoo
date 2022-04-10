package com.example.shoe.ui.adapter

import androidx.recyclerview.widget.DiffUtil

class ShoeDiffCallback: DiffUtil.ItemCallback<com.example.service.db.data.Shoe>() {
    override fun areItemsTheSame(oldItem: com.example.service.db.data.Shoe, newItem: com.example.service.db.data.Shoe): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: com.example.service.db.data.Shoe, newItem: com.example.service.db.data.Shoe): Boolean {
        return oldItem == newItem
    }
}