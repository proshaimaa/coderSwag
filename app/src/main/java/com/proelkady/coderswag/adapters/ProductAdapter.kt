package com.proelkady.coderswag.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.proelkady.coderswag.R
import com.proelkady.coderswag.model.Product

class ProductAdapter(val context: Context,val products : List<Product>, val itemClick: (Product) -> Unit ) : RecyclerView.Adapter<ProductAdapter.ProductHolder>() {

    inner class ProductHolder(itemView: View,itemClick: (Product) -> Unit) : RecyclerView.ViewHolder(itemView){

        val productImage = itemView.findViewById<ImageView>(R.id.detailImage)
        val productName = itemView.findViewById<TextView>(R.id.detailName)
        val productPrice = itemView.findViewById<TextView>(R.id.detailPrice)

        fun bindProduct(product : Product, context : Context){

            val resourceId = context.resources.getIdentifier(product.image,"drawable",context.packageName)
            productImage?.setImageResource(resourceId)
            productName?.text = product.title
            productPrice?.text = product.price
            itemView.setOnClickListener { itemClick (product) }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.product_list_item,parent,false)
        return ProductHolder(view,itemClick)
    }

    override fun getItemCount(): Int {
        return products.count()
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        holder.bindProduct(products[position],context)
    }
}