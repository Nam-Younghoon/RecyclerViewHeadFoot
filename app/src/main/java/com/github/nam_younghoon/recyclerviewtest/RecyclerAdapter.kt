package com.github.nam_younghoon.recyclerviewtest

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class RecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val TYPE_HEADER = 0
    val TYPE_ITEM = 1
    val TYPE_FOOTER = 2
    lateinit var context : Context

    private val listData = ArrayList<ItemData>()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        context = parent.context
        var holder : RecyclerView.ViewHolder
        var view : View

        if(viewType == TYPE_HEADER) {
            view = LayoutInflater.from(context).inflate(R.layout.header, parent, false)
            holder = HeaderViewHolder(view)
        } else if (viewType == TYPE_FOOTER) {
            view = LayoutInflater.from(context).inflate(R.layout.footer, parent, false)
            holder = FooterViewHolder(view)
        } else {
            view = LayoutInflater.from(context).inflate(R.layout.item, parent, false)
            holder = ItemViewHolder(view)
        }

        return holder

    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is HeaderViewHolder) {
            val headerViewHolder = holder as HeaderViewHolder
        } else if (holder is FooterViewHolder) {
            val footerViewHolder = holder as FooterViewHolder
        } else {
            val itemViewHolder = holder as ItemViewHolder
            itemViewHolder.bind(listData.get(position - 1))
        }
    }


    override fun getItemCount(): Int {
        return listData.size + 2
    }

    override fun getItemViewType(position: Int): Int {
        if(position == 0) {
            return TYPE_HEADER
        } else if (position == listData.size + 1) {
            return TYPE_FOOTER
        } else {
            return TYPE_ITEM
        }
    }

    fun addItem(data: ItemData) {
        listData.add(data)
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val title = itemView.findViewById<TextView>(R.id.title)
        private val body = itemView.findViewById<TextView>(R.id.body)

        fun bind(data: ItemData) {
            title.text = data.title
            body.text = data.body
        }
    }
}

data class ItemData(
    val title: String,
    val body: String,
)