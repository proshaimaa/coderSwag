package com.proelkady.coderswag.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.proelkady.coderswag.R
import com.proelkady.coderswag.adapters.CategoryAdapter
import com.proelkady.coderswag.service.DataService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter : CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryAdapter(this, DataService.categories)
        categoryListView.adapter = adapter
    }
}
