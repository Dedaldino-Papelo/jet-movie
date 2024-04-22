package com.example.movieinfoapp.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.example.movieinfoapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun PasswordTextInput(modifier: Modifier = Modifier){
    OutlinedTextField(
        value = "",
        onValueChange = { },
        label = { Text(text = "Password") },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Lock,
                tint = colorResource(R.color.button_color),
                contentDescription = ""
            )
        },
        modifier = modifier,
    )

}