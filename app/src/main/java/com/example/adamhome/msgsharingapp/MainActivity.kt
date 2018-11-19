package com.example.adamhome.msgsharingapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //code for button response
        btnShowToast.setOnClickListener {

            //check if working, display message to logcat
            Log.i("MainActivity", "Button was clicked !")


            //display message to user on activity. Use toast statement
            //must pass the Activity it will appear in as the first parameter (this), the msg is the 2nd parameter
            //3rd parameter is the duration of the msg
            //.show() method is used for displaying
            Toast.makeText(this, "Button was clicked !", Toast.LENGTH_SHORT).show()
        }
    }
}







