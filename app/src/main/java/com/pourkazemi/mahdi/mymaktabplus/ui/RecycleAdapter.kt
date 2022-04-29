package com.pourkazemi.mahdi.mymaktabplus.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.pourkazemi.mahdi.mymaktabplus.data.remotedata.model.PictureItem
import com.pourkazemi.mahdi.mymaktabplus.databinding.ImageitemsBinding
import javax.inject.Inject

class RecycleAdapter @Inject constructor() :
    ListAdapter<PictureItem, RecycleAdapter.MyViewHolder>(PictureDiffCall) {

    class MyViewHolder(
        private val binding: ImageitemsBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun mBind(pictureItem: PictureItem)=binding.apply {
            Glide.with(root)
                .load(pictureItem.download_url)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageView)
            textView.text=pictureItem.author
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): RecycleAdapter.MyViewHolder {
       return MyViewHolder(
           ImageitemsBinding.inflate(
              LayoutInflater.from(parent.context),
              parent,
              false
           )
       )
    }


    override fun onBindViewHolder(
        holder: RecycleAdapter.MyViewHolder, position: Int
    ) {
        holder.mBind(getItem(position))
    }
}

object PictureDiffCall : DiffUtil.ItemCallback<PictureItem>() {

    override fun areItemsTheSame(oldItem: PictureItem, newItem: PictureItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: PictureItem, newItem: PictureItem): Boolean {
        return oldItem == newItem
    }

}