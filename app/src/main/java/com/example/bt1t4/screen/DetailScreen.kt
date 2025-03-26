package com.example.bt1t4.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bt1t4.R

@Composable
fun DetailScreen(navController: NavController, quote: String) {
    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 10.dp)
                    .padding(top = 10.dp)
            ){
                IconButton(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier.align(Alignment.CenterStart) // Đặt nút "Back" ở bên trái
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.img_2),
                        contentDescription = "Back",
                        modifier = Modifier.size(40.dp)
                    )
                }

                Text(
                    text = "Detail",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF2196F3),
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    ) { padding ->
        Box(modifier = Modifier.padding(vertical = 50.dp)) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "\"$quote\"", fontSize = 18.sp, textAlign = TextAlign.Center,
                        modifier = Modifier.padding(horizontal = 50.dp))
                Spacer(modifier = Modifier.height(40.dp))
                Image(
                    painter = painterResource(id = R.drawable.img_1),
                    contentDescription = "Quote",
                    modifier = Modifier
                        .width(296.dp)
                        .height(444.dp)
                )
                Spacer(modifier = Modifier.weight(1f))
                Button(onClick = { navController.popBackStack("root_screen", false) },
                    modifier = Modifier.width(315.dp).height(53.dp),
                    colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF2196F3)
                    )
                ) {
                    Text(text = "BACK TO ROOT", color = Color.White, fontSize = 20.sp)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    DetailScreen(navController = rememberNavController(), quote = "The only way to do great work is to love what you do.")
}
