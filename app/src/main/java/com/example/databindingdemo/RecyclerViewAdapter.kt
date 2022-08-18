package com.example.databindingdemo

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.databindingdemo.databinding.RecyclerlistItemBinding

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {
    var items = ArrayList<RecyclerData>()

    fun setDataList(data: ArrayList<RecyclerData>) {
        this.items =data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter.MyViewHolder {
        val layout = LayoutInflater.from(parent.context)
        val binding = com.example.databindingdemo.databinding.RecyclerlistItemBinding.inflate(layout)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    class MyViewHolder(val binding: RecyclerlistItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(data: RecyclerData){
            binding.recyclerData = data
            binding.executePendingBindings()
        }
    }

    companion object{
        @JvmStatic
        @BindingAdapter("loadImage")
        fun loadImage(thubmImage: ImageView, url: String){
            Glide.with(thubmImage)
                .load(url)
                .circleCrop()
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .fallback(R.drawable.ic_launcher_foreground)
                .into(thubmImage)
        }
    }
}