package com.example.adamhome.msgsharingapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //code for 1st button response
        btnShowToast.setOnClickListener {

            //check if working, display message to logcat
            Log.i("MainActivity", "Button was clicked !")


            //display message to user on activity. Use toast statement
            //must pass the Activity it will appear in as the first parameter (this), the msg is the 2nd parameter
            //3rd parameter is the duration of the msg
            //.show() method is used for displaying
            Toast.makeText(this, "Page Still Under Construction", Toast.LENGTH_SHORT).show()
        }

        //code for 2nd button response
        btnSendMsgToSecondActivity.setOnClickListener {

            //use edit text field, extracting data out of it and converting it to string, store in variable message
            val message: String = etUserMessage.text.toString()

            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()


            //this is EXPLICIT INTENT - we know the target of our intent (Second Activity)
            //to navigate from one activity to the other, define intent
            //first parameter is current Activity (this), 2nd parameter is address of target activity - SecondActivity name
            //use the concept of kotlin reflection :: class.java
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

    }
}







