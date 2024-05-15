package com.example.carwardagency.models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MechanicsViewModel : ViewModel() {
    var firstName by mutableStateOf("Ian")
    var lastName by mutableStateOf("Mwendwa")
    var contact by mutableStateOf("0791930433")
    var email by mutableStateOf("ianmwendwa@gmail.com")
    var bio by mutableStateOf("He is a middle-aged adequately experienced mechanic in his field. A man who knows his way around the garage and befriends literally every tools in his toolbox. Truly, a keeper owing to his reliability. ")
    var experience by mutableStateOf(" He has been rotting in the same workshop for at least 7 years! He is definitely not a rookie messing up your car's internal organs.")
}