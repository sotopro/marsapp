package com.danielsoto.marsapps.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.danielsoto.marsapps.databinding.GridViewItemBinding
import com.danielsoto.marsapps.network.Photo

class PhotoGridAdapter :
        ListAdapter<Photo, PhotoGridAdapter.PhotosViewHolder>(DiffCallback) {

    class PhotosViewHolder(
        private val binding: GridViewItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(photos : Photo) {
            binding.photo = photos
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Photo>() {
        override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return  oldItem.imgSrcUrl == newItem.imgSrcUrl
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) : PhotosViewHolder {
        return  PhotosViewHolder(
            GridViewItemBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override  fun onBindViewHolder(holder: PhotosViewHolder, position: Int ) {
        val photo = getItem(position)
        holder.bind(photo)
    }

        }