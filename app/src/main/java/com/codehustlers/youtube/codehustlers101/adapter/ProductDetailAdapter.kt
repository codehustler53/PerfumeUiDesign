package com.codehustlers.youtube.codehustlers101.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.codehustlers.youtube.codehustlers101.ProductDetailActivity
import com.codehustlers.youtube.codehustlers101.R
import com.codehustlers.youtube.codehustlers101.model.ProductDetailModel

class ProductDetailAdapter(var listOfProducts: List<ProductDetailModel>): RecyclerView.Adapter<ProductDetailAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false))
    }

    override fun getItemCount(): Int {
        return listOfProducts.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.productName.text = listOfProducts[holder.adapterPosition].productName
        holder.productPrice.text = listOfProducts[holder.adapterPosition].productPrice
        if(listOfProducts[holder.adapterPosition].isFav){
            holder.isFav.setImageDrawable(ContextCompat.getDrawable(holder.itemView.context, R.drawable.ic_fav))
        } else {
            holder.isFav.setImageDrawable(ContextCompat.getDrawable(holder.itemView.context, R.drawable.ic_fav_unfilled))
        }
        holder.isFav.setOnClickListener {
            if(listOfProducts[holder.adapterPosition].isFav){
                listOfProducts[holder.adapterPosition].isFav = false
                holder.isFav.setImageDrawable(ContextCompat.getDrawable(holder.itemView.context, R.drawable.ic_fav_unfilled))
            } else {
                listOfProducts[holder.adapterPosition].isFav = true
                holder.isFav.setImageDrawable(ContextCompat.getDrawable(holder.itemView.context, R.drawable.ic_fav))
            }
        }

        holder.item.setOnClickListener {
            val intent = Intent(holder.itemView.context, ProductDetailActivity::class.java)
            intent.putExtra("ProductDetail", listOfProducts[holder.adapterPosition])
            holder.itemView.context.startActivity(intent)
//            Toast.makeText(holder.itemView.context, "Open Product Detail", Toast.LENGTH_SHORT).show()
        }

    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        var productName = view.findViewById<TextView>(R.id.tvProductName)
        var productPrice = view.findViewById<TextView>(R.id.tvProductPrice)
        var isFav = view.findViewById<ImageView>(R.id.ivFav)
        var item = view.findViewById<ConstraintLayout>(R.id.clItem)
    }

}