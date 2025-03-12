package com.megmilk.jetpackcomposepractice.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.megmilk.jetpackcomposepractice.R
import com.megmilk.jetpackcomposepractice.ui.component.TextFieldSample
import com.megmilk.jetpackcomposepractice.ui.theme.Screen

@Composable
fun DetailScreen(title: String, text: String, onClick: () -> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize(),// fillMaxSizeは、画面いっぱいに表示するための関数
        color = MaterialTheme.colorScheme.secondary// colorSchemeは、Material Designの色を設定するための関数
    ) {
        Column {
            Text(text = title, modifier = Modifier.height(40.dp).width(100.dp))
            TextFieldSample()
            Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "イラスト屋")
            Text(text = text, modifier = Modifier.height(40.dp).width(100.dp))
            Text(text = "指定します", modifier = Modifier.background(
                Color(0xFF00FF00)
            ))
            Text("Modifier",
                modifier = Modifier.padding(
                    horizontal = 16.dp,// 左右
                    vertical = 45.dp// 上下
                ).background(
                    Color(color = 0xFF00FF00)
                )
            )
            // 余白を開ける
            Spacer(Modifier.size(16.dp))
            Button(
                onClick = {
                    println("call")
                },
                // Uses ButtonDefaults.ContentPadding by default
                contentPadding = PaddingValues(
                    start = 20.dp,
                    top = 12.dp,
                    end = 20.dp,
                    bottom = 12.dp
                )
            ) {
                // Inner content including an icon and a text label
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = "Favorite",
                    modifier = Modifier.size(ButtonDefaults.IconSize)
                )
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text("Like")
            }
            // 余白を開ける
            Spacer(Modifier.size(16.dp))
            ExtendedFloatingActionButton(
                onClick = onClick,
                icon = {
                    Icon(
                        Icons.Default.Done,
                        contentDescription = "Favorite"
                    )
                },
                text = { Text("次へ") }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDetail() {
    DetailScreen(Screen.DETAIL.title, "パラメータ"){}
}