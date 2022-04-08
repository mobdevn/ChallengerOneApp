package com.android.challengeroneapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.challengeroneapp.R
import com.android.challengeroneapp.model.ProductListDataModel

class ProducListAdapter(val list: List<ProductListDataModel>) :
    RecyclerView.Adapter<ProducListAdapter.DataViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_list_view, parent, false)

        return DataViewHolder(view)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val productData = list[position]
        // To-Do holder.prodImage.setImageResource(productData.productImageUrl)
        holder.prodName.text = productData.productName
        holder.prodDesc.text = productData.productDescription
        holder.prodCost.text = productData.productCost
    }

    override fun getItemCount(): Int = list.size

    inner class DataViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val prodImage: ImageView = itemView.findViewById(R.id.product_image)
        val prodName: TextView = itemView.findViewById(R.id.product_name)
        val prodDesc: TextView = itemView.findViewById(R.id.product_desc)
        val prodCost: TextView = itemView.findViewById(R.id.product_amount)
        val addToCart: Button = itemView.findViewById(R.id.product_add_to_cart)
        val buyNow: Button = itemView.findViewById(R.id.product_buy_now)
    }
}