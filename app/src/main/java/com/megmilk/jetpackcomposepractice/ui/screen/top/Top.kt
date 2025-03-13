package com.megmilk.jetpackcomposepractice.ui.screen.top

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.megmilk.jetpackcomposepractice.ui.theme.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopScreen(title: String, onClick: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("ホーム") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary, // 背景色
                    titleContentColor = MaterialTheme.colorScheme.onPrimary // タイトルの文字色
                ),
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
        ) {
            val fruits = listOf("Apple", "Orange", "Grape", "Peach", "Strawberry")
            LazyColumn {
                itemsIndexed(fruits) { index, fruit ->
                    ListItem(
                        leadingContent = { Icon(Icons.Default.Star, contentDescription = null) },
                        headlineContent = { Text(fruit) },
                        supportingContent = { Text(fruit) },
                        modifier = Modifier.clickable { onClick() }
                    )
                    HorizontalDivider(thickness = 1.dp)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    TopScreen(Screen.TOP.title){}
}