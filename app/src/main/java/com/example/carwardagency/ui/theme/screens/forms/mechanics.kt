package com.example.carwardagency.ui.theme.screens.forms

import android.annotation.SuppressLint
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.carwardagency.R
import com.example.carwardagency.models.MechanicsViewModel
import com.example.carwardagency.navigation.ROUTE_EDIT_MECHS

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MechanicsScreen(navController: NavController, mechanicsViewModel: MechanicsViewModel) {

    val title by remember { mutableStateOf("Mechanics Dashboard") }

    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(
                    text = title,
                    maxLines = 1,
                    fontSize = 35.sp,
                    letterSpacing = 0.sp,
                    textDecoration = TextDecoration.Underline,
                    color = Color.DarkGray,
                    fontFamily = FontFamily.SansSerif,
                    overflow = TextOverflow.Ellipsis
                ) },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.secondaryContainer
                ),
                modifier = Modifier
                    .fillMaxWidth(),
                scrollBehavior = scrollBehavior
            )
        },
        content = {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues = PaddingValues(top = 45.dp, bottom = 24.dp))
            ) {
                item {
                    NameSection(mechanicsViewModel)
                }
                item {
                    BioSection(mechanicsViewModel)
                }
                item {
                    ExperienceSection(mechanicsViewModel )
                }
                item {
                    EmailSection(mechanicsViewModel)
                }
                item {
                    ContactSection(mechanicsViewModel)
                }
                item {
                    EditButton(navController)
                }


            }
        })
}

@Composable
fun NameSection(mechanicsViewModel: MechanicsViewModel) {

    val bounceAnimation = rememberInfiniteTransition()
    val translateY by bounceAnimation.animateFloat(
        initialValue = -16f,
        targetValue = 16f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 450, easing = LinearOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ), label = "Animation"
    )

    val scaleAnimation = rememberInfiniteTransition()
    val scale by scaleAnimation.animateFloat(
        initialValue = 1f,
        targetValue = 1.2f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)
            .background(
                color = MaterialTheme.colorScheme.primary,
                RoundedCornerShape(bottomEnd = 100.dp, bottomStart = 95.dp)

            )
            .padding(12.dp),
        contentAlignment = Alignment.Center
    ) {

        Column(
            modifier = Modifier
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
                contentAlignment = Alignment.TopEnd

            ) {
                Icon(
                    painter = painterResource(id = R.drawable.circle),
                    contentDescription = "Circle",
                    tint = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.7f),
                    modifier = Modifier
                        .size(160.dp)
                        .scale(scale)

                )
                Image(
                    painter = painterResource(
                        id = R.drawable.avatar
                    ),
                    contentDescription = "Avatar",
                    modifier = Modifier
                        .size(160.dp)
                        .graphicsLayer {
                            translationY = translateY // Apply translationY to the icon
                        }
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.BottomStart
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Text(
                        text = "Hello, My names are: ",
                        color = Color.White,
                        fontSize = 32.sp,
                        letterSpacing = 0.sp,
                        textAlign = TextAlign.Left,
                        fontFamily =  FontFamily.Serif,
                        modifier = Modifier
                    )
                    Text(
                        text = mechanicsViewModel.firstName,
                        color = Color.White,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 36.sp,
                        letterSpacing = 0.sp,
                        textAlign = TextAlign.Left,
                        fontFamily = FontFamily.Serif,
                        modifier = Modifier
                    )
                    Text(
                        text = mechanicsViewModel.lastName,
                        color = Color.White,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 36.sp,
                        letterSpacing = 0.sp,
                        textAlign = TextAlign.Left,
                        fontFamily =FontFamily.Serif,
                        modifier = Modifier
                            .padding(bottom = 3.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun BioSection(mechanicsViewModel: MechanicsViewModel) {
    Column(
        modifier = Modifier
            .padding(top = 32.dp, start = 24.dp, end = 24.dp)
    ) {
        Text(
            text = "About Mr.Ian",
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = 32.sp,
            letterSpacing = 0.sp,
            textAlign = TextAlign.Left,
            fontWeight = FontWeight.ExtraBold,
            fontFamily =FontFamily.Serif,
            modifier = Modifier
        )

        val maxLines = 4 // Maximum number of lines to display initially

        var expanded by remember { mutableStateOf(false) }

        val text = buildAnnotatedString {
            withStyle(style = SpanStyle(fontFamily = FontFamily.SansSerif)) {
                val maxLines = if (expanded) Int.MAX_VALUE else 4 // Maximum number of lines to display initially
                val textToShow = if (mechanicsViewModel.bio.length > maxLines * 25) {
                    mechanicsViewModel.bio.substring(0, maxLines * 25)
                } else {
                    mechanicsViewModel.bio
                }
                append(textToShow)
                if (mechanicsViewModel.bio.length > maxLines * 25) {
                    // Add a "Read more" link at the end
                    withStyle(style = SpanStyle(textDecoration = TextDecoration.None, color = Color.Gray)) {
                        append("... Read more")
                    }
                }
            }
        }

        Text(
            text = text,
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onSurface,
            maxLines = if (expanded) Int.MAX_VALUE else maxLines,
            letterSpacing = 0.sp,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Left,
            fontFamily = FontFamily.Serif,
            modifier = Modifier.clickable { expanded = !expanded }
        )
    }
}
@Composable
fun ExperienceSection(mechanicsViewModel: MechanicsViewModel) {
    Column(
        modifier = Modifier
            .padding(top = 32.dp, start = 24.dp, end = 24.dp)
    ) {
        Text(
            text = "Years of experience",
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = 32.sp,
            letterSpacing = 0.sp,
            textAlign = TextAlign.Left,
            fontWeight = FontWeight.ExtraBold,
            fontFamily =FontFamily.Serif,
            modifier = Modifier
        )

        val maxLines = 4 // Maximum number of lines to display initially

        var expanded by remember { mutableStateOf(false) }

        val text = buildAnnotatedString {
            withStyle(style = SpanStyle(fontFamily = FontFamily.SansSerif)) {
                val maxLines = if (expanded) Int.MAX_VALUE else 4 // Maximum number of lines to display initially
                val textToShow = if (mechanicsViewModel.experience.length > maxLines * 25) {
                    mechanicsViewModel.experience.substring(0, maxLines * 25)
                } else {
                    mechanicsViewModel.experience
                }
                append(textToShow)
                if (mechanicsViewModel.experience.length > maxLines * 25) {
                    // Add a "Read more" link at the end
                    withStyle(style = SpanStyle(textDecoration = TextDecoration.None, color = Color.Gray)) {
                        append("... Read more")
                    }
                }
            }
        }

        Text(
            text = text,
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onSurface,
            maxLines = if (expanded) Int.MAX_VALUE else maxLines,
            letterSpacing = 0.sp,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Left,
            fontFamily = FontFamily.SansSerif,
            modifier = Modifier.clickable { expanded = !expanded }
        )
    }
}
@Composable
fun EmailSection(mechanicsViewModel: MechanicsViewModel) {
    Row(
        modifier = Modifier
            .padding(top = 24.dp, start = 24.dp, end = 24.dp)
    ) {
        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.email_icon),
                contentDescription = "Email Handle",
                modifier = Modifier
                    .size(16.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = mechanicsViewModel.email,
                fontSize = 16.sp,
                letterSpacing = 0.sp,
                textAlign = TextAlign.Left,
                fontFamily = FontFamily.SansSerif,
                modifier = Modifier
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

    }
}
@Composable
    fun ContactSection(mechanicsViewModel: MechanicsViewModel) {
        Row(
            modifier = Modifier
                .padding(top = 24.dp, start = 24.dp, end = 24.dp)
        ) {
            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.email_icon),
                    contentDescription = "contacts Handle",
                    modifier = Modifier
                        .size(16.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = mechanicsViewModel.contact,
                    fontSize = 16.sp,
                    letterSpacing = 0.sp,
                    textAlign = TextAlign.Left,
                    fontFamily = FontFamily.SansSerif,
                    modifier = Modifier
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

        }

        Spacer(modifier = Modifier.width(16.dp))



        }

@Composable
fun EditButton(navController: NavController) {
    Button(
        onClick = {
            navController.navigate(ROUTE_EDIT_MECHS)
                  },
                shape = RoundedCornerShape(15.dp),
                colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.onTertiaryContainer),
                modifier = Modifier
                    .width(200.dp)
                    .height(100.dp)
                    .padding(top = 25.dp, bottom = 25.dp, start = 25.dp, end = 25.dp),
                elevation = ButtonDefaults.buttonElevation(40.dp)
    ) {
        Text(
            text = "Edit",
            fontSize = 18.sp,
            letterSpacing = 0.sp,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.SansSerif

                )
            }
        }



@Composable
@Preview
fun MechanicsScreenPreview() {
    val navController = rememberNavController()
    val mechanicsViewModel = remember { MechanicsViewModel() }

    MechanicsScreen(navController = navController, mechanicsViewModel = mechanicsViewModel)
}

