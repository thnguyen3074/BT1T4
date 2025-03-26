package com.example.bt1t4.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bt1t4.R

@Composable
fun ListScreen(navController: NavController) {
    val allItems  = (1..1_000_000).map { "$it | The only way to do great work is to love what you do." }
    val listState = rememberLazyListState()
    var loadedItems by remember { mutableStateOf(allItems.take(5)) }

    LaunchedEffect(listState.firstVisibleItemIndex) {
        if (listState.firstVisibleItemIndex + listState.layoutInfo.visibleItemsInfo.size >= loadedItems.size) {
            loadedItems = allItems.take(loadedItems.size + 5)
        }
    }

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
                    text = "LazyColumn",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF2196F3),
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    ) { padding ->
        Box(modifier = Modifier.padding(top = 10.dp, bottom = 20.dp)) {
            LazyColumn(state = listState, modifier = Modifier.padding(padding)) {
                items(loadedItems, key = { it }) { item ->
                    ListItem(item, onClick = { navController.navigate("detail_screen/${item}") })
                }
            }
        }
    }
}
@Composable
fun ListItem(text: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp, horizontal = 15.dp)
            .background(Color(0x4D2196F3), shape = RoundedCornerShape(10.dp))
            .height(90.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text,
            fontSize = 18.sp,
            color = Color.Black,
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.img_3),
            contentDescription = "Go to Detail",
            modifier = Modifier
                .size(40.dp)
                .padding(end = 16.dp)
                .clickable(onClick = onClick)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun UIComponentsListPreview() {
    ListScreen(navController = rememberNavController())
}