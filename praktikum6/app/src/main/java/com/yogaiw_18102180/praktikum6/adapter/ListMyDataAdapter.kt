package com.yogaiw_18102180.praktikum6.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.yogaiw_18102180.praktikum6.DetailActivity
import com.yogaiw_18102180.praktikum6.MyData
import com.yogaiw_18102180.praktikum6.R
import kotlinx.android.synthetic.main.item_list.view.*

class ListMyDataAdapter(private val listMyData: ArrayList<MyData>, val context: Context) : RecyclerView.Adapter<ListMyDataAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listMyData[position])

        val myData = listMyData[position]

        holder.itemView.setOnClickListener {
            val moveWithObjectIntent = Intent(context, DetailActivity::class.java)
            moveWithObjectIntent.putExtra(DetailActivity.EXTRA_MYDATA, myData)
            context.startActivity(moveWithObjectIntent)
        }
    }

    override fun getItemCount(): Int = listMyData.size

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(myData: MyData) {
            with(itemView){
                Glide.with(itemView.context).load(myData.photo).apply(RequestOptions().override(55, 55)).into(img_item_photo)
                tv_item_name.text = myData.name
                tv_item_description.text = myData.description
            }
        }
    }
}