package com.example.carwardagency.ui.theme.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.carwardagency.R
import com.example.carwardagency.components.CButton
import com.example.carwardagency.components.DontHaveAnAccount
import com.example.carwardagency.navigation.ROUTE_LOGIN
import com.example.carwardagency.navigation.ROUTE_SIGNUP

@Composable
fun Welcomescreen(navController: NavHostController,
)
{
    Box(
        modifier =Modifier.fillMaxSize()
    ){
        Image(painter = painterResource(id = R.drawable.white),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )

        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
        ){

//            Spacer(modifier = Modifier.weight(if))

            Image(painter = painterResource(id = R.drawable.app_icon),
                contentDescription = null,
                modifier = Modifier
                    .width(200.dp)
                    .height(200.dp),
                contentScale = ContentScale.Fit
            )
            Text(text = "WELCOME TO LUNAR",
                fontSize = 25.sp,
                fontWeight = FontWeight(700),
                fontFamily = FontFamily.Serif,
                color= MaterialTheme.colorScheme.primary
            )
            Text(text = "A good mechanic is he whom befriends his tools",
                textAlign = TextAlign.Center,
                fontFamily= FontFamily.Serif,
                fontSize = 18.sp,
                fontWeight = FontWeight(500),
                color=MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(60.dp))

            CButton(text = "Login In With Email",
                onClick = {
                    navController.navigate("login")
                }
            )

            DontHaveAnAccount(
                onSignupTap = {
                    navController.navigate("signup")
                }
            )




        }
    }
}
@Preview(showBackground = true, widthDp = 320, heightDp = 648)
@Composable
fun Welcomescreenprev() {
    Welcomescreen(rememberNavController())
}