package com.example.bt1t4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bt1t4.screen.DetailScreen
import com.example.bt1t4.screen.ListScreen
import com.example.bt1t4.screen.RootScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "root_screen") {
                composable("root_screen") { RootScreen(navController) }
                composable("list_screen") { ListScreen(navController) }
                composable("detail_screen/{quote}") { backStackEntry ->
                    val quote = backStackEntry.arguments?.getString("quote") ?: ""
                    DetailScreen(navController, quote)
                }
            }
        }
    }
}
