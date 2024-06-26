package com.example.carwardagency.ui.theme.screens.signup

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.carwardagency.R
import com.example.carwardagency.data.AuthViewModel
import com.example.carwardagency.navigation.ROUTE_MECHANICS
import com.example.carwardagency.ui.theme.screens.login.Icon

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SignupScreen(navController: NavHostController){
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var pass by remember { mutableStateOf(TextFieldValue("")) }
    var confirmpass by remember { mutableStateOf(TextFieldValue(""))}
//    var UName by remember { mutableStateOf(TextFieldValue(""))}
    var passwordVisible by remember { mutableStateOf(false) }
    val context= LocalContext.current
    Surface(
        color = Color.White,
        modifier = Modifier.fillMaxSize()
    ) {

        Box(modifier = Modifier.fillMaxSize()){

            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier= Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp)
            ) {
                Image(painter = painterResource(id = R.drawable.app_icon),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 54.dp)
                        .height(100.dp)
                        .align(Alignment.CenterHorizontally)
                        .offset(x = (-20).dp)
                )
                Text(text = "Sign up",
                    style= androidx.compose.ui.text.TextStyle(
                        fontSize = 24.sp,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight(500),
                        color = Color.Black
                    ),
                    modifier= Modifier.align(Alignment.CenterHorizontally)
                )
                Text(text = "Join now to get covered 24/7 on the road",
                    style = androidx.compose.ui.text.TextStyle(
                        fontSize = 20.sp,
                        fontFamily = FontFamily.Serif,
                        color = Color.Black
                    ),
                    modifier= Modifier
                        .align(Alignment.Start)
                        .padding(bottom = 24.dp)
                )



                TextField(
                    value = email,
                    onValueChange = { email = it },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = "mail"
                        )
                    },
                    placeholder = {
                        Text(
                            text = "Enter email",
                            style = androidx.compose.ui.text.TextStyle(
                                fontSize = 18.sp,
                                fontFamily = FontFamily.Serif,
                                color = Color.Gray
                            )
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        disabledContainerColor = Color.Transparent,
                        focusedIndicatorColor = Color(0xFFbec2C2),
                        unfocusedIndicatorColor = Color(0xFFbec2C2),
                    )
                )

                TextField(
                    value = pass,
                    onValueChange = { pass = it },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Lock,
                            contentDescription = "mail"
                        )
                    },
                    placeholder = {
                        Text(
                            text = "Enter password",
                            style = androidx.compose.ui.text.TextStyle(
                                fontSize = 18.sp,
                                fontFamily = FontFamily.Serif,
                                color = Color.Gray
                            )
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp, bottom = 8.dp),
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        val image =
                            if (passwordVisible) Icons.Filled.toString() else Icons.Filled.toString()
                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            Icon(
                                image,
                                contentDescription = if (passwordVisible) "Hide password" else "Show password"
                            )

                        }
                    },
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        disabledContainerColor = Color.Transparent,
                        focusedIndicatorColor = Color(0xFFbec2C2),
                        unfocusedIndicatorColor = Color(0xFFbec2C2),
                    )
                )



                TextField(
                    value = confirmpass,
                    onValueChange = { confirmpass = it },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Lock,
                            contentDescription = "mail"
                        )
                    },
                    placeholder = {
                        Text(
                            text = "Confirm  password",
                            style = androidx.compose.ui.text.TextStyle(
                                fontSize = 18.sp,
                                fontFamily = FontFamily.Serif,
                                color = Color.Gray
                            )
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp, bottom = 8.dp),
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        val image =
                            if (passwordVisible) Icons.Filled.toString() else Icons.Filled.toString()
                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            Icon(
                                image,
                                contentDescription = if (passwordVisible) "Hide password" else "Show password"
                            )

                        }
                    },
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        disabledContainerColor = Color.Transparent,
                        focusedIndicatorColor = Color(0xFFbec2C2),
                        unfocusedIndicatorColor = Color(0xFFbec2C2),
                    )
                )



                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick ={
                        navController.navigate(ROUTE_MECHANICS)
                        val mysignup= AuthViewModel(navController,context)
                        mysignup.signup(email.text.trim(),pass.text.trim(),confirmpass.text.trim())
                    },
                    shape = MaterialTheme.shapes.small,
                    colors = ButtonDefaults.buttonColors(
                        containerColor= Color((0xFF3C9A92))
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text(text = "Sign up",
                        style = androidx.compose.ui.text.TextStyle(
                            fontSize= 22.sp,
                            fontFamily = FontFamily.Serif,
                            fontWeight = FontWeight(500),
                            color = Color.Black
                        )
                    )

                }

//                CButton(text = "Sign up")

                Row (
                    modifier = Modifier.padding(top = 12.dp, bottom = 52.dp)
                ){
                    Text(text = "Already have an account?",
                        style= androidx.compose.ui.text.TextStyle(
                            fontSize = 13.sp,
                            fontFamily = FontFamily.Serif,
                            color = Color.Black
                        )
                    )
                    Text(text = "Sign in",
                        style = androidx.compose.ui.text.TextStyle(
                            fontSize = 13.sp,
                            fontFamily = FontFamily.Serif,
                            fontWeight = FontWeight(500),
                            color = Color.Gray
                        )
                    )

                }


            }
        }

    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true, widthDp = 320, heightDp = 640)
@Composable
fun SignupscreenPrev() {
    SignupScreen(rememberNavController())
}
