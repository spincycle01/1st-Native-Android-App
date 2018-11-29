package com.example.adamhome.msgsharingapp.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.adamhome.msgsharingapp.adapters.HobbiesAdapter
import com.example.adamhome.msgsharingapp.R
import com.example.adamhome.msgsharingapp.models.Supplier
import kotlinx.android.synthetic.main.activity_third.*

class ThirdActivity : AppCompatActivity() {

//    this is to initialize the recycler view
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        // call function
        setupRecyclerView()

    }

    private fun setupRecyclerView() {
        //    want to layout vertical orientation,
        //    parameter - pass in this Activity
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        //attach layoutManager to recyclerview
        recyclerView.layoutManager = layoutManager

        //  initialize HobbiesAdapter
        //  2 parameters - context of calling activity (this)
        //  and list of hobbies (List<hobbies>) or in model class Supplier.hobbies
        val adapter =
            HobbiesAdapter(this, Supplier.hobbies)

        recyclerView.adapter = adapter
    }
}
