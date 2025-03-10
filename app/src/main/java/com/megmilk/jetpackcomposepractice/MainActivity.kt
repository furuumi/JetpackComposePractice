package com.megmilk.jetpackcomposepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.megmilk.jetpackcomposepractice.ui.theme.JetpackComposePracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Window()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Window() {
    Box(Modifier.safeDrawingPadding()) {
        JetpackComposePracticeTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),// fillMaxSizeは、画面いっぱいに表示するための関数
                color = MaterialTheme.colorScheme.secondary// colorSchemeは、Material Designの色を設定するための関数
            ) {
                Greeting(name = "Android")
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Column {
        TextFieldSample()
        Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "イラスト屋")
        Text(text = "幅を", modifier = Modifier.height(40.dp).width(100.dp))
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
            onClick = { /* ... */ },
            icon = {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = "Favorite"
                )
            },
            text = { Text("Like") }
        )
    }
}

// TextFiled用のComposableを作成
@OptIn(ExperimentalMaterial3Api::class)// これを付けるとExperimentalなAPIを使えるようになる
@Composable
// TextFieldSampleという名前のComposableを作成
fun TextFieldSample() {
    // rememberSaveableは、画面回転などで状態がリセットされないようにするためのもの
    val inputValue = rememberSaveable { mutableStateOf("") }
    TextField(
        value = inputValue.value,
        onValueChange = { inputValue.value = it },// ラムダ式の引数はitで受け取れる
        label = { /*TODO*/ },
        modifier = Modifier.padding(0.dp)
    )
}