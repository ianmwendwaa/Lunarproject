package com.example.carwardagency.components

import androidx.compose.runtime.Composable
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DontHaveAnAccount(
    onSignupTap: () -> Unit = {},
) {

    Row (
        modifier = Modifier.padding(top = 12.dp, bottom = 52.dp)
    ){
        Text(text = "Don't have an account?",
            style= TextStyle(
                fontSize = 15.sp,
                fontFamily = FontFamily.SansSerif,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        )
        Text(text = "Sign up",
            style = TextStyle(
                fontSize = 15.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight(500),
                color = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.clickable {
                onSignupTap()
            }
        )

    }

}