package com.proelkady.coderswag.controller

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.proelkady.coderswag.R
import com.proelkady.coderswag.adapters.ProductAdapter
import com.proelkady.coderswag.service.DataService
import com.proelkady.coderswag.utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_product.*

class ProductActivity : AppCompatActivity() {

    lateinit var adapter : ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)
        adapter = ProductAdapter(this,DataService.getProducts(categoryType))

        var spanCount = 2
        val orientation = resources.configuration.orientation
        if(orientation == Configuration.ORIENTATION_LANDSCAPE){
            spanCount = 3
        }
        val screenSize = resources.configuration.screenWidthDp
        if(screenSize > 720 ){
            spanCount = 3
        }

        val layoutManager = GridLayoutManager(this,spanCount)
        productListView.layoutManager = layoutManager
        productListView.adapter = adapter
    }
}
