package com.yogaiw_18102180.praktikum6.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.yogaiw_18102180.praktikum6.DetailActivity
import com.yogaiw_18102180.praktikum6.MyData
import com.yogaiw_18102180.praktikum6.R

class GridMyDataAdapter(val listMyDatas: ArrayList<MyData>, val context: Context) : RecyclerView.Adapter<GridMyDataAdapter.GridViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): GridViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_grid, viewGroup, false)
        return GridViewHolder(view)
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        Glide.with(holder.itemView.context).load(listMyDatas[position].photo).apply(RequestOptions().override(350, 550)).into(holder.imgPhoto)

        val myData = listMyDatas[position]

        holder.itemView.setOnClickListener {
            val moveWithObjectIntent = Intent(context, DetailActivity::class.java)
            moveWithObjectIntent.putExtra(DetailActivity.EXTRA_MYDATA, myData)
            context.startActivity(moveWithObjectIntent)
        }
    }

    override fun getItemCount(): Int {
        return listMyDatas.size
    }

    inner class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }
}