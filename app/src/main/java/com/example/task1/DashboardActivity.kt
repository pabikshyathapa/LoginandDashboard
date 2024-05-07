package com.example.task1

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.task1.adapter.RecyclerViewAdapter

class DashboardActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    var nameList = ArrayList<String>()
    var desriptionList = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_dashboard)

        recyclerView = findViewById(R.id.recyclerView)
        nameList.add("Apple")
        nameList.add("Mango")
        desriptionList.add("This is apple")
        desriptionList.add("This is mango")

        var adapter = RecyclerViewAdapter(nameList,desriptionList)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.Remember)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.task1.R

class RecyclerViewAdapter(var nameList: ArrayList<String>,
                          var descriptionList: ArrayList<String>) : RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>() {

    class RecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //bind views from layout file
        var title: TextView = view.findViewById(R.id.title)
        var description: TextView = view.findViewById(R.id.description)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        // when users opens activity this method links layout file to our activity
        var view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.recyclersample, parent, false)
        return RecyclerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return nameList.size
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.title.text = nameList[position]
        holder.description.text = descriptionList[position]
    }
}
//} This one is for adapter <?xml version="1.0" encoding="utf-8"?>
//<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
//xmlns:app="http://schemas.android.com/apk/res-auto"
//xmlns:tools="http://schemas.android.com/tools"
//android:id="@+id/checkBoxOne"
//android:layout_width="match_parent"
//android:layout_height="match_parent"
//tools:context=".LoginActivity">
//
//<androidx.recyclerview.widget.RecyclerView
//android:id="@+id/recyclerView"
//android:layout_width="409dp"
//android:layout_height="729dp"
//android:layout_marginStart="1dp"
//android:layout_marginBottom="1dp"
//app:layout_constraintBottom_toBottomOf="parent"
//app:layout_constraintStart_toStartOf="parent" />
//</androidx.constraintlayout.widget.ConstraintLayout> XML file of dashboard sample of recycler view: Last one is of sample recycler view This much
//
//import android.os.Bundle
//import androidx.activity.enableEdgeToEdge
//import androidx.appcompat.app.AppCompatActivity
//import androidx.core.view.ViewCompat
//import androidx.core.view.WindowInsetsCompat
//
