package com.example.adamhome.msgsharingapp.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.adamhome.msgsharingapp.R
import com.example.adamhome.msgsharingapp.showToast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //to extract the value from MainActivity, use getIntent (property - intent), with properties extras
        //assign to val bundle: Bundle?
        val bundle: Bundle? = intent.extras

        //use safe call operator ?.let {}
        bundle?.let {
            //extract incoming string, use the key as the argument
            val msg = bundle.getString("user_message")

            //Toast statement to display msg - pop up
            //Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
             showToast(msg)

            //display message to textview
            //need textview id from SecondActivity, which creates kotlinx import statement
            //property getText/SetText --> text, assign it to msg
            txvUserMessage.text = msg

        }

        //send message to third another app
        //IMPLICIT INTENT - not sure where my target is
        thirdImage.setOnClickListener {

            bundle?.let {
                //extract incoming string, use the key as the argument
                val msg = bundle.getString("user_message")

                //don't need to add parameters to intent(), because don't know target
                val intent = Intent()
                intent.action = Intent.ACTION_SEND

                //Intent.EXTRA_TEXT is a key that is recognized by other apps, predefined,
                // second parameter is message val
                intent.putExtra(Intent.EXTRA_TEXT, msg)
                //define type of message that is being sent
                intent.type = "text/plain"

                startActivity(Intent.createChooser(intent, getString(R.string.select_app)))
            }
        }

    }
}
