package com.example.bt1t4.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bt1t4.R

@Composable
fun RootScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.img),
            contentDescription = "Navigation",
            modifier = Modifier.size(220.dp).padding(top = 80.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Navigation",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 60.dp).padding(bottom = 10.dp)
        )
        Text(
            text = "is a framework that simplifies the implementation of navigation between different UI components (activities, fragments, or composables) in an app",
            textAlign = TextAlign.Center,
            style = androidx.compose.ui.text.TextStyle(
                color = Color(0xFF4A4646),
                fontSize = 16.sp
            ),
            modifier = Modifier.padding(bottom = 150.dp)
        )
        Button(
            onClick = { navController.navigate("list_screen") },
            modifier = Modifier.width(315.dp).height(53.dp),
            colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                containerColor = Color(0xFF2196F3)
            )
        ) {
            Text(text = "PUSH", color = Color.White, fontSize = 20.sp)
        }
    }
}