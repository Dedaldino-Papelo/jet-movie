package com.example.movieinfoapp.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.example.movieinfoapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailTextInput(
    email: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
){
    OutlinedTextField(
        modifier = modifier,
        value = email,
        onValueChange = { onValueChange(it) },
        label = { Text(text = "Email") },
        textStyle = TextStyle(colorResource(R.color.white), fontSize = 13.sp),
        placeholder = { Text(text = "example@gmail.com") },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Email,
                tint = colorResource(R.color.button_color),
                contentDescription = "emailicon"
            )
        }
    )
}