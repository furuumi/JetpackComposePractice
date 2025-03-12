package com.megmilk.jetpackcomposepractice.ui.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

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