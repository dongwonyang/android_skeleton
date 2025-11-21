package com.example.feature.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.feature.home.databinding.ItemHomeTextBinding

class SampleListAdapter(): ListAdapter<String, RecyclerView.ViewHolder>(HomeDiffUtil()) {

    private enum class ViewType {
        TYPE1, TYPE2
    }


    class HomeViewHolder(
        private val binding: ItemHomeTextBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String) = with(binding) {
            tvHomeText1.text = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            ViewType.TYPE1.ordinal -> {
                val view = ItemHomeTextBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                HomeViewHolder(view)
            }
            else -> throw IllegalStateException()
        }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int
    ) {
        val item = getItem(position) ?: return

        when (holder) {
            is HomeViewHolder -> {
                holder.bind(item)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            else -> ViewType.TYPE1.ordinal
        }
    }
}



class HomeDiffUtil : DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(
        oldItem: String,
        newItem: String,
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: String,
        newItem: String,
    ): Boolean {
        return oldItem == newItem
    }
}