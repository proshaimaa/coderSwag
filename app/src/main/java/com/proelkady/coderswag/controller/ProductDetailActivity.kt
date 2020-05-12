package com.proelkady.coderswag.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.proelkady.coderswag.R
import com.proelkady.coderswag.adapters.ProductAdapter
import com.proelkady.coderswag.model.Product
import com.proelkady.coderswag.service.DataService
import com.proelkady.coderswag.utilities.EXTRA_PRODUCT
import kotlinx.android.synthetic.main.activity_product_detail.*

class ProductDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        val product = intent.getParcelableExtra<Product>(EXTRA_PRODUCT)
        val resourceId = resources.getIdentifier(product?.image, "drawable", packageName)
        detailImage.setImageResource(resourceId)
        detailName.text = product?.title
        detailPrice.text = product?.price
    }
}
