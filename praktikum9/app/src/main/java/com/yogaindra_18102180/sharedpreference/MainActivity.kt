package com.yogaindra_18102180.sharedpreference

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yogaindra_18102180.sharedpreference.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = getString(R.string.main_title)
    }
}