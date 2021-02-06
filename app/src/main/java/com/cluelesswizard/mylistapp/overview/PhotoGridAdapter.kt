package com.cluelesswizard.mylistapp.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cluelesswizard.mylistapp.databinding.GridViewItemBinding
import com.cluelesswizard.mylistapp.network.ResponseModel

class PhotoGridAdapter( val onClickListener: OnClickListener ) :
    ListAdapter<ResponseModel, PhotoGridAdapter.PhotoViewHolder>(DiffCallback) {

    class PhotoViewHolder(private var binding: GridViewItemBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(property: ResponseModel) {
            binding.property = property
            // This is important, because it forces the data binding to execute immediately,
            // which allows the RecyclerView to make the correct view size measurements
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<ResponseModel>() {
        override fun areItemsTheSame(oldItem: ResponseModel, newItem: ResponseModel): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: ResponseModel, newItem: ResponseModel): Boolean {
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
        val property = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(property)
        }
        holder.bind(property)
    }

    /** Custom listener that handles clicks on [RecyclerView] items.*/
    class OnClickListener(val clickListener: (property:ResponseModel) -> Unit) {
        fun onClick(property:ResponseModel) = clickListener(property)
    }
}
