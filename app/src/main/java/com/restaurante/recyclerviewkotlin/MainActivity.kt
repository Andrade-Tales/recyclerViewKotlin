package com.restaurante.recyclerviewkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var foodList: ArrayList<Food>
    private lateinit var foodAdapter: FoodAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        foodList = ArrayList()

        foodList.add(Food(R.drawable.paneer_butter_masala1, "Panner Butter Masala"))
        foodList.add(Food(R.drawable.pizza1, "Pizza"))
        foodList.add(Food(R.drawable.dosa1, "Dosa"))
        foodList.add(Food(R.drawable.veg_biryani, "Veg Biryani"))
        foodList.add(Food(R.drawable.pasta1, "Pasta"))
        foodList.add(Food(R.drawable.noodles1, "Noodles"))

//        foodList.add(Food(R.drawable.paneer_butter_masala1, "Panner Butter Masala"))
//        foodList.add(Food(R.drawable.pizza1, "Pizza"))
//        foodList.add(Food(R.drawable.dosa1, "Dosa"))
//        foodList.add(Food(R.drawable.veg_biryani, "Veg Biryani"))
//        foodList.add(Food(R.drawable.pasta1, "Pasta"))
//        foodList.add(Food(R.drawable.noodles1, "Noodles"))

        foodAdapter = FoodAdapter(foodList)
        recyclerView.adapter = foodAdapter

        foodAdapter.onItemClick = {
            val intent = Intent(this, DetailedActivity::class.java)
            intent.putExtra("food", it)

            startActivity(intent)
        }
    }
}