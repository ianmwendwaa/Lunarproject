package com.example.carwardagency.data

import android.app.ProgressDialog
import android.widget.Toast
import androidx.navigation.NavHostController
import com.example.carwardagency.navigation.ROUTE_LOGIN
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class uploadviewmodel(navController: NavHostController, var context: android.content.Context) {
    var authRepository: AuthViewModel
    var progress: ProgressDialog

    init {
        authRepository = AuthViewModel(navController, context)
        if (!authRepository.isLoggedIn()) {
                navController.navigate(ROUTE_LOGIN)
            }
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")
    }

    class Mechanics(
        val authoredFirstName: String,
        val authoredLastName: String,
        val editedemail: String,
        val autheredBio: String,
        val experience: String,
        val contact: String,

        )


    fun saveMechanics(
        authoredFirstName: String,
        authoredLastName: String,
        editedemail: String,
        autheredBio: String,
        experience: String,
        contact: String,
    ) {
        var currentUser = FirebaseAuth.getInstance().currentUser
        var userId = currentUser?.uid
        if (userId != null) {
            var mechanicdata = Mechanics(
                authoredFirstName,
                authoredLastName,
                editedemail,
                autheredBio,
                experience,
                contact,
            )
            var mechanicsRef = FirebaseDatabase.getInstance().getReference()
                .child("User/$userId")
            progress.show()
            mechanicsRef.setValue(mechanicdata).addOnCompleteListener {
                progress.dismiss()
                if (it.isSuccessful) {
                    Toast.makeText(context, "Saved successful", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "ERROR: ${it.exception!!.message}", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }
}
