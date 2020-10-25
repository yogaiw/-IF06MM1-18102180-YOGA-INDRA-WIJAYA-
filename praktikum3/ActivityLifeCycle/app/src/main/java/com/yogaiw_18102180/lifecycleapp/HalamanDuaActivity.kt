package com.yogaiw_18102180.lifecycleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class HalamanDuaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_halaman_dua)
    }

    override fun onStart() {
        super.onStart()
        printState("Halaman satu On Start")
    }

    override fun onResume() {
        super.onResume()
        printState("Halaman satu On Resume")
    }

    override fun onPause() {
        super.onPause()
        printState("Halaman satu On Pause")
    }

    override fun onStop() {
        super.onStop()
        printState("Halaman satu On Stop")
    }

    override fun onRestart() {
        super.onRestart()
        printState("Halaman satu On Restart")
    }

    override fun onDestroy() {
        super.onDestroy()
        printState("Halaman satu On Destroy")
    }

    fun printState(msg: String) {
        Log.d("ActivityState",msg)
        Toast.makeText(applicationContext,msg, Toast.LENGTH_SHORT).show()
    }
}