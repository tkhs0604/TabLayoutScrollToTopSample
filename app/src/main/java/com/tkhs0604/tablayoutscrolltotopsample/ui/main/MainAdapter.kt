package com.tkhs0604.tablayoutscrolltotopsample.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tkhs0604.tablayoutscrolltotopsample.databinding.ListitemMainBinding

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ListitemMainBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.text.text = "item: ${position + 1}"
    }

    override fun getItemCount(): Int {
        // dummy item count
        return 100
    }

    inner class ViewHolder(
        val binding: ListitemMainBinding
    ) : RecyclerView.ViewHolder(binding.root)

}