package com.megmilk.jetpackcomposepractice.ui.screen.top

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.megmilk.jetpackcomposepractice.ui.component.CommonScaffold
import com.megmilk.jetpackcomposepractice.ui.theme.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopScreen(navController: NavHostController, title: String, onClick: () -> Unit) {
    CommonScaffold(navController, title, isBack = false) {
        val fruits = listOf("Apple", "Orange", "Grape", "Peach", "Strawberry","Apple", "Orange", "Grape", "Peach", "Strawberry","Apple", "Orange", "Grape", "Peach", "Strawberry","Apple", "Orange", "Grape", "Peach", "Strawberry","Apple", "Orange", "Grape", "Peach", "Strawberry")
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

@Preview(showBackground = true)
@Composable
private fun Preview() {
    val navController = rememberNavController()
    TopScreen(navController, Screen.TOP.title){}
}