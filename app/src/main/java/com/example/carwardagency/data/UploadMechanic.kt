@file:Suppress("DEPRECATION", "unused", "UNUSED_PARAMETER")

package com.example.carwardagency.data

import android.app.ProgressDialog
import android.widget.Toast
import androidx.navigation.NavHostController
import com.example.carwardagency.models.Mechanics
import com.example.carwardagency.navigation.ROUTE_LOGIN
import com.google.firebase.database.FirebaseDatabase

class uploadviewmodel(navController: NavHostController, var context: android.content.Context) {
    var authRepository: AuthViewModel
    var progress: ProgressDialog

    init {
        authRepository = AuthViewModel(navController, context)
        if (!authRepository.isloggedin()) {
            navController.navigate(ROUTE_LOGIN)
        }
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")
    }

    class Mechanics(
        val userId: String,
        val authoredFirstName: String,
        val authoredLastName: String,
        val editedemail: String,
        val autheredBio: String,
        val experience: String,
        val contact:String,

        )


    fun saveMechanic(
        authoredFirstName: String,
        authoredLastName: String,
        editedemail: String,
        autheredBio: String,
        experience: String,
        contact: String,
    ) {
        val id = System.currentTimeMillis().toString()
        val mechanics = Mechanics(
            authoredFirstName,
            authoredLastName,
            editedemail,
            autheredBio,
        )
        val mechanicRef = FirebaseDatabase.getInstance().getReference()
            .child("User/$id")
        progress.show()
        mechanicRef.setValue(mechanics).addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful) {
                Toast.makeText(context, "Saved successful", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "ERROR: ${it.exception!!.message}", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    fun updateMechanic(
        userId: String,
        authoredFirstName: String,
        authoredLastName: String,
        editedemail: String,
    ) {
        val mechanics = Mechanics(
            userId,
            authoredFirstName,
            authoredLastName,
            editedemail,
        )
        val mechanicRef = FirebaseDatabase.getInstance().getReference()
            .child("User/$userId")
        progress.show()
        mechanicRef.setValue(mechanics).addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful) {
                Toast.makeText(context, "Update successful", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "ERROR: ${it.exception!!.message}", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}
