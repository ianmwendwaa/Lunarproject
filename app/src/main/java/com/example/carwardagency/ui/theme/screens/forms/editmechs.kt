package com.example.carwardagency.ui.theme.screens.forms

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.carwardagency.data.uploadviewmodel
import com.example.carwardagency.models.MechanicsViewModel
import com.example.carwardagency.navigation.ROUTE_MECHANICS


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Editmechs(navController: NavHostController, mechanicsViewModel: MechanicsViewModel) {

    var title by remember { mutableStateOf("Mechanics App") }


    var context=LocalContext.current
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    var authoredFirstName by remember { mutableStateOf(mechanicsViewModel.firstName) }
    var authoredLastName by remember { mutableStateOf(mechanicsViewModel.lastName) }
    var editedemail by remember { mutableStateOf(mechanicsViewModel.email) }
    var autheredBio by remember { mutableStateOf(mechanicsViewModel.bio) }
    var editedexperience by remember { mutableStateOf(mechanicsViewModel.experience) }
    var editedcontact by remember { mutableStateOf(mechanicsViewModel.contact) }

    // Create a scaffold with a top app bar
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = title,
                        maxLines = 1,
                        fontSize = 24.sp,
                        letterSpacing = 0.sp,
                        fontFamily = FontFamily.SansSerif,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.secondaryContainer
                ),
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Card(
                                modifier = Modifier
                                    .width(70.dp)
                                    .height(40.dp),
                                shape = RoundedCornerShape(14.dp)
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxSize(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Icon(
                                        imageVector = Icons.Filled.ArrowBack,
                                        contentDescription = "Localized description",
                                        tint = MaterialTheme.colorScheme.onPrimaryContainer
                                    )
                                }
                            }
                        }

                    }
                },
                modifier = Modifier
                    .fillMaxWidth(),
                scrollBehavior = scrollBehavior
            )
        },
        content = {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        paddingValues = PaddingValues(
                            top = 80.dp,
                            start = 24.dp,
                            end = 24.dp,
                            bottom = 24.dp
                        )
                    )
            ) {

                item {
                    UpdateText()
                }

                item {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 40.dp)
                    ) {

                        val bioMaxLength = 600
                        val bioMinLength = 15
                        val experienceMaxLength=600
                        val experienceMinLength=60
                        val maxLength = 20
                        val minLength = 3


                        Text(
                            text = "Mechanics First Name",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 4.dp),
                            textAlign = TextAlign.Start,
                            color = MaterialTheme.colorScheme.onPrimaryContainer,
                            fontFamily = FontFamily.Serif,
                            fontSize = 12.sp
                        )

                        TextField(
                            value = authoredFirstName,
                            onValueChange = { authoredFirstName = it },
                            placeholder = {
                                Text(
                                    text = "Enter First Name",
                                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                                    fontFamily = FontFamily.SansSerif,
                                    fontWeight = FontWeight(300),
                                    fontSize = 12.sp
                                )
                            },
                            shape = RoundedCornerShape(12.dp),
                            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                            colors = TextFieldDefaults.textFieldColors(
                                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                                cursorColor = MaterialTheme.colorScheme.tertiary,
                                disabledLabelColor = MaterialTheme.colorScheme.primaryContainer,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent
                            ),
                            trailingIcon = {
                                IconButton(onClick = { authoredFirstName = "" }) {
                                    if (authoredFirstName.length in minLength..maxLength) {
                                        Icon(
                                            imageVector = Icons.Outlined.Check,
                                            tint = Color(0xFF006400),
                                            contentDescription = null
                                        )
                                    } else {
                                        Icon(
                                            imageVector = Icons.Outlined.Clear,
                                            tint = Color.Red,
                                            contentDescription = null
                                        )
                                    }
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(52.dp),
                        )



                        Text(
                            text = "Mechanics Last Name",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 4.dp, top = 12.dp),
                            textAlign = TextAlign.Start,
                            color = MaterialTheme.colorScheme.onPrimaryContainer,
                            fontFamily = FontFamily.SansSerif,
                            fontSize = 12.sp
                        )

                        TextField(
                            value = authoredLastName,
                            onValueChange = { authoredLastName = it },
                            placeholder = {
                                Text(
                                    text = "Enter Last Name",
                                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                                    fontFamily = FontFamily.SansSerif,
                                    fontWeight = FontWeight(300),
                                    fontSize = 12.sp
                                )
                            },
                            shape = RoundedCornerShape(12.dp),
                            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                            colors = TextFieldDefaults.textFieldColors(
                                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                                cursorColor = MaterialTheme.colorScheme.tertiary,
                                disabledLabelColor = MaterialTheme.colorScheme.primaryContainer,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent
                            ),
                            trailingIcon = {
                                IconButton(onClick = { authoredLastName = "" }) {
                                    if (authoredLastName.length in minLength..maxLength) {
                                        Icon(
                                            imageVector = Icons.Outlined.Check,
                                            tint = Color(0xFF006400),
                                            contentDescription = null
                                        )
                                    } else {
                                        Icon(
                                            imageVector = Icons.Outlined.Clear,
                                            tint = Color.Red,
                                            contentDescription = null
                                        )
                                    }
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(52.dp),
                        )


                        Text(
                            text = "Mechanic's Email",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 4.dp, top = 12.dp),
                            textAlign = TextAlign.Start,
                            color = MaterialTheme.colorScheme.onPrimaryContainer,
                            fontFamily = FontFamily.Serif,
                            fontSize = 12.sp
                        )

                        TextField(
                            value = editedemail,
                            onValueChange = { editedemail = it },
                            placeholder = {
                                Text(
                                    text = "Enter email address",
                                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                                    fontFamily = FontFamily.Serif,
                                    fontWeight = FontWeight(300),
                                    fontSize = 12.sp
                                )
                            },
                            shape = RoundedCornerShape(12.dp),
                            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                            colors = TextFieldDefaults.textFieldColors(
                                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                                cursorColor = MaterialTheme.colorScheme.tertiary,
                                disabledLabelColor = MaterialTheme.colorScheme.primaryContainer,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent
                            ),
                            trailingIcon = {
                                IconButton(onClick = { editedemail = "" }) {
                                    if (editedemail.length in minLength..maxLength) {
                                        Icon(
                                            imageVector = Icons.Outlined.Check,
                                            tint = Color(0xFF006400),
                                            contentDescription = null
                                        )
                                    } else {
                                        Icon(
                                            imageVector = Icons.Outlined.Clear,
                                            tint = Color.Red,
                                            contentDescription = null
                                        )
                                    }
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(52.dp),
                        )


                        Text(
                            text = "Contact",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 4.dp, top = 12.dp),
                            textAlign = TextAlign.Start,
                            color = MaterialTheme.colorScheme.onPrimaryContainer,
                            fontFamily = FontFamily.Serif,
                            fontSize = 12.sp
                        )

                        TextField(
                            value = editedcontact,
                            onValueChange = { editedcontact = it },
                            placeholder = {
                                Text(
                                    text = "Mechanics phone number",
                                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                                    fontFamily = FontFamily.Serif,
                                    fontWeight = FontWeight(300),
                                    fontSize = 12.sp
                                )
                            },
                            shape = RoundedCornerShape(12.dp),
                            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                            colors = TextFieldDefaults.textFieldColors(
                                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                                cursorColor = MaterialTheme.colorScheme.tertiary,
                                disabledLabelColor = MaterialTheme.colorScheme.primaryContainer,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent
                            ),
                            trailingIcon = {
                                IconButton(onClick = { editedcontact   = "" }) {
                                    if (editedcontact.length in minLength..maxLength) {
                                        Icon(
                                            imageVector = Icons.Outlined.Check,
                                            tint = Color(0xFF006400),
                                            contentDescription = null
                                        )
                                    } else {
                                        Icon(
                                            imageVector = Icons.Outlined.Clear,
                                            tint = Color.Red,
                                            contentDescription = null
                                        )
                                    }
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(52.dp),
                        )



                        Text(
                            text = "Years of expertise",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 4.dp, top = 12.dp),
                            textAlign = TextAlign.Start,
                            color = MaterialTheme.colorScheme.onPrimaryContainer,
                            fontFamily = FontFamily.Serif,
                            fontSize = 12.sp
                        )

                        TextField(
                            value = editedexperience,
                            onValueChange = { editedexperience = it },
                            placeholder = {
                                Text(
                                    text = "Enter Bio",
                                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                                    fontFamily = FontFamily.Serif,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 12.sp
                                )
                            },
                            shape = RoundedCornerShape(12.dp),
                            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                            colors = TextFieldDefaults.textFieldColors(
                                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                                cursorColor = MaterialTheme.colorScheme.tertiary,
                                disabledLabelColor = MaterialTheme.colorScheme.primaryContainer,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent
                            ),
                            trailingIcon = {
                                IconButton(onClick = { editedexperience = "" }) {
                                    if (editedexperience.length in experienceMinLength..experienceMaxLength) {
                                        Icon(
                                            imageVector = Icons.Outlined.Check,
                                            tint = Color(0xFF006400),
                                            contentDescription = null
                                        )
                                    } else {
                                        Icon(
                                            imageVector = Icons.Outlined.Clear,
                                            tint = Color.Red,
                                            contentDescription = null
                                        )
                                    }
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(80.dp),
                        )
                    }
                }

                item{
                    Button(
                        onClick = {
                            mechanicsViewModel.firstName = authoredFirstName
                            mechanicsViewModel.lastName = authoredLastName
                            mechanicsViewModel.email = editedemail
                            mechanicsViewModel.experience = editedexperience
                            mechanicsViewModel.bio = autheredBio
                            mechanicsViewModel.contact = editedcontact


                            val mechanicRepository = uploadviewmodel(navController,context)
                            mechanicRepository.saveMechanics(authoredFirstName.trim(),authoredLastName.trim(),
                                editedemail.trim(),editedexperience.trim(),autheredBio.trim(), editedcontact.trim())
                            navController.navigate("mechanics")
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                            .padding(top = 32.dp, bottom = 24.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor= Color((0xFF3C9A92))
                        ),
                        elevation = ButtonDefaults.buttonElevation(20.dp)
                    ) {
                        Text(
                            text = "Save Mechanics",
                            fontFamily = FontFamily.Serif,
                            fontWeight = FontWeight(300),
                            fontSize = 14.sp
                        )
                    }
                    Button(
                        onClick = {
                            mechanicsViewModel.firstName = authoredFirstName
                            mechanicsViewModel.lastName = authoredLastName
                            mechanicsViewModel.email = editedemail
                            mechanicsViewModel.experience = editedexperience
                            mechanicsViewModel.bio = autheredBio
                            mechanicsViewModel.contact = editedcontact

                            navController.navigate("mechanics")
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                            .padding(top = 32.dp, bottom = 24.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor= Color((0xFF3C9A92))
                        ),
                        elevation = ButtonDefaults.buttonElevation(20.dp)
                    ) {
                        Text(
                            text = "Update Mechanics",
                            fontFamily = FontFamily.Serif,
                            fontWeight = FontWeight(300),
                            fontSize = 14.sp
                        )
                    }


                }

            }
        })

}

@Composable
fun UpdateText() {
    Column(
        modifier = Modifier
    ) {
        Text(
            text = "Edit your list",
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = 32.sp,
            letterSpacing = 0.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif,
            modifier = Modifier
        )

        Text(
            text = "Update your mechanics' preferences by making adjustments using the form below.",
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = 16.sp,
            letterSpacing = 0.sp,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.Serif,
            modifier = Modifier
        )
    }
}


@Preview(showBackground = true)
@Composable
fun EditMechanicScreenPreview() {
    val navController = rememberNavController()
    val viewModel = MechanicsViewModel(/* Initialize with sample data */)
    Editmechs(navController = navController, mechanicsViewModel = viewModel)
}