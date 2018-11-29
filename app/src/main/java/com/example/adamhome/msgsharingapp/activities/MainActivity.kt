package com.example.adamhome.msgsharingapp.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import com.example.adamhome.msgsharingapp.R
import com.example.adamhome.msgsharingapp.showToast
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        //code for 1st button response
        btnShowToast.setOnClickListener {

            //check if working, display message to logcat
            Log.i("MainActivity", getString(R.string.Button_test_in_logcat))


            //display message to user on activity. Use toast statement
            //must pass the Activity it will appear in as the first parameter (this), the msg is the 2nd parameter
            //3rd parameter is the duration of the msg
            //.show() method is used for displaying
            //Toast.makeText(this, getString(R.string.print_to_screen), Toast.LENGTH_SHORT).show()
            showToast(getString(R.string.print_to_screen))
        }

        //code for 2nd button response
        btnSendMsgToSecondActivity.setOnClickListener {

            //use edit text field, extracting data out of it and converting it to string, store in variable message
            val message: String = etUserMessage.text.toString()

            //Toast.makeText(this, message, Toast.LENGTH_SHORT).show()


            //this is EXPLICIT INTENT - we know the target of our intent (Second Activity)
            //to navigate from one activity to the other, define intent
            //first parameter is current Activity (this), 2nd parameter is address of target activity - SecondActivity name
            //use the concept of kotlin reflection :: class.java
            val intent = Intent(this, SecondActivity::class.java)

            //to pass 'message' to SecondActivity, use 'intent' object, with putExtra function
            //first value is the key, the 2nd is the string of user input
            intent.putExtra("user_message", message)

            startActivity(intent)
        }

        //code for 3rd button response
        //IMPLICIT INTENT - not sure where my target is
        btnShareToOtherApps.setOnClickListener {

            //to share message user enters in edit text, add this statement
            val message: String = etUserMessage.text.toString()

            //don't need to add parameters to intent(), because don't know target
            val intent = Intent()
            intent.action = Intent.ACTION_SEND

            //Intent.EXTRA_TEXT is a key that is recognized by other apps, predefined,
            // second parameter is message val
            intent.putExtra(Intent.EXTRA_TEXT, message)
            //define type of message that is being sent
            intent.type = "text/plain"

            startActivity(Intent.createChooser(intent, getString(R.string.select_app)))

        }



        //code for 4th button response, to send to 3rd activity
        btnSendMsgToThirdActivity.setOnClickListener {

            //this is EXPLICIT INTENT - we know the target of our intent (Third Activity)
            //to navigate from one activity to the other, define intent
            //first parameter is current Activity (this), 2nd parameter is address of target activity - SecondActivity name
            //use the concept of kotlin reflection :: class.java
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }
    }
}







