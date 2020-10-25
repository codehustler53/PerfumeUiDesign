package com.codehustlers.youtube.codehustlers101

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.codehustlers.youtube.codehustlers101.`interface`.IRemoveDot
import com.codehustlers.youtube.codehustlers101.adapter.CategoryTypeAdapter
import com.codehustlers.youtube.codehustlers101.adapter.ProductDetailAdapter
import com.codehustlers.youtube.codehustlers101.model.CategoryTypeModel
import com.codehustlers.youtube.codehustlers101.model.ProductDetailModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), IRemoveDot {

    private lateinit var categoryTypeAdapter: CategoryTypeAdapter

    private lateinit var listOfTypeCategories: List<CategoryTypeModel>
    private lateinit var listOfProducts: List<ProductDetailModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        ivMenu.setOnClickListener {
            if(clDrawerMenu.visibility == View.VISIBLE){
                clDrawerMenu.visibility = View.GONE
                clDrawerMenu.startAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_out_left))
                ivMenu.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_menu))
            } else {
                clDrawerMenu.visibility = View.VISIBLE
                clDrawerMenu.startAnimation(AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left))
                ivMenu.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_arrow_back))
            }
        }

        listOfTypeCategories = arrayListOf(
            CategoryTypeModel(1, "SUGGESTED"),
            CategoryTypeModel(2, "POPULAR"),
            CategoryTypeModel(3, "FLORAL")
        )

        listOfProducts = arrayListOf(
            ProductDetailModel("Bright Crystal", "$35.00"),
            ProductDetailModel("Rose Crystal", "$3.00"),
            ProductDetailModel("English Crystal", "$25.00")
        )


        categoryTypeAdapter = CategoryTypeAdapter(listOfTypeCategories, this)

        rvProductDrawerCategory.adapter = categoryTypeAdapter

        rvProductDrawerCategory.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        rvProducts.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvProducts.adapter = ProductDetailAdapter(listOfProducts)
    }

    override fun selected(pos: Int) {
        rvProductDrawerCategory[pos].findViewById<TextView>(R.id.tvProductTypeCategoryName)
            .setTextColor(ContextCompat.getColor(this, android.R.color.black))
        rvProductDrawerCategory[pos].findViewById<View>(R.id.vDot).visibility = View.INVISIBLE
    }
}