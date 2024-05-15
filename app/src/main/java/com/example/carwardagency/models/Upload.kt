package com.example.carwardagency.models

class User1{

    var firstName:String=""
    var lastName :String=""
    var email :String=""
    var bio :String=""
    var experience :String=""

    constructor(firstName:String,lastName:String,email:String, bio:String,experience:String){
        this.firstName=firstName
        this.lastName=lastName
        this.email=email
        this.bio=bio
        this.experience=experience
    }
    constructor()
}