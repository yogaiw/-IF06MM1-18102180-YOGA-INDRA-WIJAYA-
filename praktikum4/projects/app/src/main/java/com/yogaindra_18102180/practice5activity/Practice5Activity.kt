package com.yogaindra_18102180.practice5activity

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.util.jar.Manifest

class Practice5Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practice5)

        setupPermissions()

        val btnProdi: Button = findViewById(R.id.btnProdi)
        val inputProdi: EditText = findViewById(R.id.inputProdi)
        val btnCallBrowser: Button = findViewById(R.id.btnCallBrowser)
        val btnCallCamera: Button = findViewById(R.id.btnCallCamera)
        val btnCallPhone: Button = findViewById(R.id.btnCallPhone)
        val inputPhoneNumber: EditText = findViewById(R.id.inputPhoneNumber)
        val btnFragment: Button = findViewById(R.id.btnFragment)

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

        btnCallBrowser.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("http://ittelkom-pwt.ac.id")
            startActivity(intent)
        }

        btnCallCamera.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }

        btnCallPhone.setOnClickListener {
            val phoneNumber = inputPhoneNumber.getText()
            if (phoneNumber.isEmpty()) {
                inputPhoneNumber.error = "Nomor Telpon Tidak Boleh Kosong"
                return@setOnClickListener
            }
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:" + phoneNumber)
            startActivity(intent)
        }

        btnFragment.setOnClickListener {
            val intent = Intent(this, Practice5ForFragmentActivity::class.java)
            startActivity(intent)
        }
    }

    val CALL_REQUEST_CODE = 100
    @SuppressLint("MissingPermission")
    private fun setupPermissions() {
        val permission = ContextCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE)
        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE), CALL_REQUEST_CODE)
        }
    }
}