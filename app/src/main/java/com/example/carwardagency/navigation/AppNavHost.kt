package com.example.carwardagency.navigation

import android.os.Build
import androidx.activity.compose.BackHandler
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.carwardagency.models.MechanicsViewModel
import com.example.carwardagency.ui.theme.screens.forms.Editmechs
import com.example.carwardagency.ui.theme.screens.forms.MechanicsScreen
import com.example.carwardagency.ui.theme.screens.home.Welcomescreen
import com.example.carwardagency.ui.theme.screens.login.LoginScreen
import com.example.carwardagency.ui.theme.screens.signup.SignupScreen
import com.example.carwardagency.ui.theme.screens.splashscreen.SplashScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppNavHost(modifier: Modifier =Modifier, navController: NavHostController = rememberNavController(), startDestination:String= ROUTE_WELCOME) {

    BackHandler {
        navController.popBackStack()

    }

    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = startDestination
    ) {
        composable(ROUTE_SPLASH) {
            SplashScreen(navController)
        }
        composable(ROUTE_WELCOME) {
            Welcomescreen(navController)
        }
//        composable(ROUTE_HOME) {
//            HomeScreen(navController)
//        }
        composable(ROUTE_LOGIN) {
            LoginScreen(navController)
        }
        composable(ROUTE_SIGNUP) {
            SignupScreen(navController)
        }
//        composable(ROUTE_MECHANICS){
//            AddMechanicsScreen(navController)
//        }
        composable(ROUTE_EDIT_MECHS){
            Editmechs(navController, mechanicsViewModel = MechanicsViewModel())
        }
        composable(ROUTE_MECHANICS){
            MechanicsScreen(navController, mechanicsViewModel = MechanicsViewModel())
        }
    }
}