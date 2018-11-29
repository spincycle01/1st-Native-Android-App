package com.example.adamhome.msgsharingapp.models

import com.example.adamhome.msgsharingapp.R

data class Hobby(var title: String)


//data for recycler view, the title properties
object Supplier {

    val hobbies = listOf(
        Hobby("Exercising"),
        Hobby("Reading"),
        Hobby("Walking"),
        Hobby("Sleeping"),
        Hobby("Watching TV"),
        Hobby("Studying"),
        Hobby("Photography"),
        Hobby("Painting"),
        Hobby("Cooking"),
        Hobby("Writing"),
        Hobby("Gardening"),
        Hobby("Dancing"),
        Hobby("Drawing"),
        Hobby("Hiking"),
        Hobby("Knitting"),
        Hobby("Bird Watching"),
        Hobby("Shopping"),
        Hobby("Hunting"),
        Hobby("Fishing"),
        Hobby("Gaming"),
        Hobby("Gambling"),
        Hobby("Programming"),
        Hobby("Playing Chess"),
        Hobby("Sewing"),
        Hobby("Woodworking"),
        Hobby("Scrapbooking"),
        Hobby("Sculpting"),
        Hobby("Crochet"),
        Hobby("Running"),
        Hobby("Scuba Diving"),
        Hobby("Surfing"),
        Hobby("Pottery"),
        Hobby("Origami"),
        Hobby("Baking"),
        Hobby("Playing the Guitar"),
        Hobby("Home brewing")
    )
}