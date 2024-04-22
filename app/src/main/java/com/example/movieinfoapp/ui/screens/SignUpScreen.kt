package com.example.movieinfoapp.ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movieinfoapp.R
import com.example.movieinfoapp.ui.components.CommonButton
import com.example.movieinfoapp.ui.components.EmailTextInput
import com.example.movieinfoapp.ui.components.PasswordTextInput
import com.example.movieinfoapp.ui.theme.MovieInfoAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(modifier: Modifier = Modifier){
    var email by rememberSaveable { mutableStateOf("") }

    Log.d("email", email)

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.auth_bg_color)),
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = stringResource(R.string.signup_txt),
            color = colorResource(R.color.white),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = modifier.fillMaxWidth()
        )
        Spacer(modifier = modifier.height(50.dp))

        Column(
            modifier = modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            EmailTextInput(
                email = email,
                onValueChange = { email = it },
                modifier = modifier.fillMaxWidth()
            )

            OutlinedTextField(
                modifier = modifier.fillMaxWidth(),
                value = "",
                label = { Text(text = "Username") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        tint = colorResource(R.color.button_color),
                        contentDescription = "username"
                    )
                },
                onValueChange = {}
            )
            PasswordTextInput(
                modifier = modifier.fillMaxWidth()
            )
        }
        Spacer(modifier = modifier.height(30.dp))

        Column(
            modifier = modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            CommonButton(
                modifier = modifier.fillMaxWidth(),
                onClick = {  },
                label = R.string.create_account
            )
            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Already have an account?",
                    color = colorResource(R.color.white),
                )
                Spacer(modifier = modifier.size(5.dp))

                Text(
                    text = "Login",
                    color = colorResource(R.color.white),
                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview(){
    MovieInfoAppTheme {
        SignUpScreen()
    }
}