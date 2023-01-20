package com.ashwani.composesample.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ashwani.composesample.common.AppNavConstants
import com.ashwani.composesample.model.SampleData
import com.ashwani.composesample.screens.profile.ProfileScreen
import com.ashwani.composesample.ui.ConversationScreen
import com.ashwani.composesample.ui.SplashScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    // navigateUp specially use in case our app opne through any deeplink and on back we want popout from our app and back to same deeplink source
    val navigateUp = {
        navController.navigateUp()
        Unit
    }
    NavHost(
        navController = navController, startDestination = AppNavConstants.SPLASH_SCREEN
    ) {
        composable(AppNavConstants.SPLASH_SCREEN) {
            SplashScreen(navController = navController)
        }
        // Main Screen
        composable(AppNavConstants.CONVERSATION_SCREEN) {
            ConversationScreen(messages = SampleData.conversationSample, onButtonClick = {
                navController.popBackStack()
            })
        }

        // Profile Screen
        composable(AppNavConstants.PROFILE_SCREEN) {
            ProfileScreen(navController = navController)
        }
    }
}

