package com.example.movieinfoapp.ui.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.sp
import com.example.movieinfoapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun PasswordTextInput(
    password: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = password,
        onValueChange = { onValueChange(it) },
        label = {
            Text(
                text = "Password",
                color = colorResource(R.color.button_color)
            )
        },
        textStyle = TextStyle(colorResource(R.color.white), fontSize = 13.sp),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        visualTransformation = PasswordVisualTransformation(),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,
            focusedIndicatorColor = colorResource(R.color.button_color)
        ),
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