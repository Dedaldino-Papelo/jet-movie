package com.example.movieinfoapp.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.movieinfoapp.R

@Composable
fun CommonButton(
    onClick: () -> Unit,
    @StringRes label: Int,
    modifier: Modifier = Modifier
){
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(2.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(R.color.button_color)
            )
    ) {
        Text(
            text = stringResource(label),
            color = colorResource(R.color.black)
        )
    }
}