package com.cluelesswizard.mylistapp.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cluelesswizard.mylistapp.databinding.GridViewItemBinding
import com.cluelesswizard.mylistapp.model.Product
import com.cluelesswizard.mylistapp.model.ResponseModel

class PhotoGridAdapter( val onClickListener: OnClickListener ) :
    ListAdapter<Product, PhotoGridAdapter.PhotoViewHolder>(DiffCallback) {

    class PhotoViewHolder(private var binding: GridViewItemBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product) {
            binding.product = product
            // This is important, because it forces the data binding to execute immediately,
            // which allows the RecyclerView to make the correct view size measurements
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.id == newItem.id
        }
    }

    /** Create new [RecyclerView] item views (invoked by the layout manager) */
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): PhotoViewHolder {
        return PhotoViewHolder(GridViewItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    /** Replaces the contents of a view (invoked by the layout manager) */
    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val product = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(product)
        }
        holder.bind(product)
    }

    /** Custom listener that handles clicks on [RecyclerView] items.*/
    class OnClickListener(val clickListener: (product: Product) -> Unit) {
        fun onClick(product: Product) = clickListener(product)
    }
}
