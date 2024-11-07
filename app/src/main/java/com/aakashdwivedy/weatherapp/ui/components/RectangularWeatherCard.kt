package com.aakashdwivedy.weatherapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aakashdwivedy.weatherapp.ui.theme.BgColor

@Composable
fun RectangularWeatherCard(
    text1: String, text2: String,
    icon1: Int, icon2: Int,
    tint: Boolean
) {
    Row(
        Modifier
            .fillMaxWidth()
            .background(Color.White, shape = RoundedCornerShape(16.dp))
            .padding(24.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        RectangularWeatherCardItem(Modifier.fillMaxWidth(0.5f), text1, icon1, tint)
        RectangularWeatherCardItem(Modifier.fillMaxWidth(), text2, icon2, tint)
    }
    Spacer(Modifier.height(16.dp))
}

@Composable
fun RectangularWeatherCardItem(
    modifier: Modifier = Modifier,
    text: String,
    icon: Int,
    tint: Boolean
) {
    Row(
        modifier = modifier,
        horizontalArrangement = if (tint) Arrangement.Center else Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier.size(if (tint) 24.dp else 32.dp),
            painter = painterResource(icon),
            contentDescription = "image",
            colorFilter = if (tint) ColorFilter.tint(BgColor) else null
        )
        Text(
            modifier = Modifier.padding(start = 16.dp),
            text = text,
            fontSize = if (tint) 20.sp else 18.sp
        )
    }
}