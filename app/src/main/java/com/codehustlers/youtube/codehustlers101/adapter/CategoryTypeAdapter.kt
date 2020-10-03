package com.codehustlers.youtube.codehustlers101.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.codehustlers.youtube.codehustlers101.R
import com.codehustlers.youtube.codehustlers101.`interface`.IRemoveDot
import com.codehustlers.youtube.codehustlers101.model.CategoryTypeModel

class CategoryTypeAdapter(val listOfItems: List<CategoryTypeModel>, val iRemoveDot: IRemoveDot): RecyclerView.Adapter<CategoryTypeAdapter.ViewHolder>() {

    private var selectedPosition = -1

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){

        val productTypeName: TextView = view.findViewById(R.id.tvProductTypeCategoryName)
        val vDot: View = view.findViewById(R.id.vDot)
        val llItem: View = view.findViewById(R.id.llItem)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_product_type_category, parent, false))
    }

    override fun getItemCount(): Int {
        return listOfItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.productTypeName.text = listOfItems[holder.adapterPosition].productName
        if(listOfItems[holder.adapterPosition].isSelected){
            holder.productTypeName.setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.colorDrawerHome))
            holder.vDot.visibility = View.VISIBLE
        } else {
            holder.productTypeName.setTextColor(ContextCompat.getColor(holder.itemView.context, android.R.color.black))
            holder.vDot.visibility = View.INVISIBLE
        }

        holder.llItem.setOnClickListener {
            if(selectedPosition != -1){
                iRemoveDot.selected(selectedPosition)
                listOfItems[selectedPosition].isSelected = false
            }
            selectedPosition = holder.adapterPosition
            listOfItems[holder.adapterPosition].isSelected = true
            holder.productTypeName.setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.colorDrawerHome))
            holder.vDot.visibility = View.VISIBLE
        }

    }

}