package com.github.nam_younghoon.recyclerviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager

        val adapter = RecyclerAdapter()
        addItem(adapter)
        recyclerView.adapter = adapter

    }
}

fun addItem(adapter: RecyclerAdapter) {
    adapter.addItem(ItemData("1", "하나"))
    adapter.addItem(ItemData("2", "둘"))
    adapter.addItem(ItemData("3", "셋"))
    adapter.addItem(ItemData("4", "넷"))
    adapter.addItem(ItemData("5", "다섯"))
    adapter.addItem(ItemData("6", "여섯"))
    adapter.addItem(ItemData("7", "일곱"))
    adapter.addItem(ItemData("7", "일곱"))
    adapter.addItem(ItemData("7", "일곱"))
    adapter.addItem(ItemData("7", "일곱"))
    adapter.addItem(ItemData("7", "일곱"))
}