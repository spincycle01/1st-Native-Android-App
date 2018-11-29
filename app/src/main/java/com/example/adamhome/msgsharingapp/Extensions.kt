package com.example.adamhome.msgsharingapp

import android.app.Activity
import android.widget.Toast

//Add function showToast to Activity Class
fun Activity.showToast(message: String) {

    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}