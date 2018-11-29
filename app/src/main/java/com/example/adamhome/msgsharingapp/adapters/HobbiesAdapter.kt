package com.example.adamhome.msgsharingapp.adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.adamhome.msgsharingapp.models.Hobby
import com.example.adamhome.msgsharingapp.R
import kotlinx.android.synthetic.main.list_item.view.*

//create a custom adapter class to link model classes to recyclerView
class HobbiesAdapter(val context: Context, private val hobbies: List<Hobby>) : RecyclerView.Adapter<HobbiesAdapter.MyViewHolder>(){

    //responsible for creating each viewHolder item
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        //layout Inflater returns layout as a view
        //layout/first parameter is file with data, 2nd is parent ViewGroup, 3rd is false for attaching layout to root
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, p0, false )
        return MyViewHolder(view)
    }

    //responsible for returning length hobbies List
    override fun getItemCount(): Int {
        return hobbies.size
    }

    //responsible for binding data to the views created in onCreateViewHolder
    //combine data with view
    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {
        val hobby = hobbies[p1]
        p0.setData(hobby, p1)
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){


        var currentHobby: Hobby? = null
        var currentPosition: Int = 0

        //item responsiveness, show toast message, pass activity
        init {
            //clicking on the hobby
            itemView.setOnClickListener{
                currentHobby?.let {
                Toast.makeText(context, currentHobby!!.title + ' ' + context.getString(R.string.clicked), Toast.LENGTH_SHORT).show()
                }
            }
    
            //for the share image link
            itemView.imgShare.setOnClickListener{

                currentHobby?.let {
                    //to share message user enters in edit text, add this statement
                    val message: String = context.getString(R.string.my_hobby_is) + ' ' + currentHobby!!.title

                    //don't need to add parameters to intent(), because don't know target
                    val intent = Intent()
                    intent.action = Intent.ACTION_SEND

                    //Intent.EXTRA_TEXT is a key that is recognized by other apps, predefined,
                    // second parameter is message val
                    intent.putExtra(Intent.EXTRA_TEXT, message)
                    //define type of message that is being sent
                    intent.type = "text/plain"

                    context.startActivity(Intent.createChooser(intent, context.getString(R.string.select_app_list)))
                }
            }
        }
        //set each list item to itemView, accessing txvTitle id
        fun setData(hobby: Hobby?, pos: Int) {
            hobby?.let {
                itemView.txvTitle.text = hobby.title
            }

            this.currentHobby = hobby
            this.currentPosition = pos
        }
    }
    
}