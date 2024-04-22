package com.example.movieinfoapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movieinfoapp.R
import com.example.movieinfoapp.ui.components.CommonButton
import com.example.movieinfoapp.ui.theme.MovieInfoAppTheme

@Composable
fun SplashScreen(
    onButtonClicked: () -> Unit,
    onSignUpClicked: () -> Unit,
    modifier: Modifier = Modifier
){
    Box(modifier = modifier.fillMaxSize()) {
        Image(
            painter = painterResource(R.drawable.banner),
            contentScale = ContentScale.Crop,
            contentDescription = null,
            modifier = modifier
                .fillMaxSize()
        )
        Column(
            modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .background(
                    color = colorResource(R.color.black).copy(0.9f),
                    RoundedCornerShape(topEnd = 20.dp, topStart = 20.dp)
                )
        ) {
            Column(
                modifier = modifier
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(R.string.splash_title),
                    color = colorResource(R.color.white),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = stringResource(R.string.splash_subtitle),
                    color = colorResource(R.color.white),
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold,
                )
            }
            
            Column(
                modifier = modifier
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                CommonButton(
                    onClick = onButtonClicked,
                    label = R.string.login_txt,
                    modifier = modifier
                        .fillMaxWidth()
                )
               OutlinedButton(
                   onClick = onSignUpClicked,
                   shape = RoundedCornerShape(2.dp),
                   modifier = modifier
                       .fillMaxWidth()
                       .padding(bottom = 20.dp)
               ) {
                   Text(
                       text = stringResource(R.string.signup_txt),
                       color = colorResource(R.color.button_color),
                       fontWeight = FontWeight.Bold
                   )
               }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview(){
    MovieInfoAppTheme {
        SplashScreen(
            onButtonClicked = {},
            onSignUpClicked = {}
        )
    }
}