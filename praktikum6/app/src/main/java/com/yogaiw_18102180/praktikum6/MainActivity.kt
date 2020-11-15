package com.yogaiw_18102180.praktikum6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.yogaiw_18102180.praktikum6.adapter.ListMyDataAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val list = ArrayList<MyData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_mydata.setHasFixedSize(true)
        list.addAll(getListMyDatas())
        showRecyclerList()
    }

    fun getListMyDatas(): ArrayList<MyData> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val listMyData = ArrayList<MyData>()
        for (position in dataName.indices) {
            val myData = MyData(
                dataName[position],
                dataDescription[position],
                dataPhoto[position]
            )
            listMyData.add(myData)
        }
        return listMyData
    }
    private fun showRecyclerList() {
        rv_mydata.layoutManager = LinearLayoutManager(this)
        val listMyDataAdapter = ListMyDataAdapter(list)
        rv_mydata.adapter = listMyDataAdapter
    }
}