package com.phanphuongnam.paginganddatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.viewModels
import com.phanphuongnam.paginganddatabase.presentation.BeerViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}