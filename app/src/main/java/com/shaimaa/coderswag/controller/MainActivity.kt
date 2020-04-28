package com.shaimaa.coderswag.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.shaimaa.coderswag.R
import com.shaimaa.coderswag.adapters.CategoryAdapter
import com.shaimaa.coderswag.services.DataService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter : CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryAdapter(this,DataService.categories)

        categoryListView.adapter = adapter

    }
}
