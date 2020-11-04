package com.yogaindra_18102180.practice5activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class Practice5Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practice5)

        val btnProdi: Button = findViewById(R.id.btnProdi)
        val inputProdi: EditText = findViewById(R.id.inputProdi)

        btnProdi.setOnClickListener {
            val namaProdi = inputProdi.text.toString()

            if (namaProdi.isEmpty()) {
                inputProdi.error = "Prodi Tidak Boleh Kosong!"
                return@setOnClickListener
            }

            val moveWithDataIntent = Intent(this@Practice5Activity, Practice5ReadDataActivity::class.java)
            moveWithDataIntent.putExtra(Practice5ReadDataActivity.EXTRA_PRODI, namaProdi)
            startActivity(moveWithDataIntent)
        }
    }
}