package com.aakashdwivedy.weatherapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SquareWeatherCards(
    title1: String, title2: String,
    value1: String, value2: String,
    icon1: Int, icon2: Int
) {
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        SquareWeatherCardsItem(Modifier.weight(1f), title1, value1, icon1)
        Spacer(Modifier.width(16.dp))
        SquareWeatherCardsItem(Modifier.weight(1f), title2, value2, icon2)
    }
    Spacer(Modifier.height(16.dp))
}

@Composable
fun SquareWeatherCardsItem(
    modifier: Modifier = Modifier,
    title: String,
    value: String,
    icon: Int
) {
    Box(
        modifier
            .fillMaxWidth()
            .height(150.dp)
            .background(Color.White, shape = RoundedCornerShape(16.dp))
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier.size(32.dp),
                    painter = painterResource(icon),
                    contentDescription = "title"
                )
                Text(
                    modifier = Modifier.padding(start = 16.dp),
                    text = title,
                    color = Color.DarkGray
                )
            }
            Spacer(Modifier.height(8.dp))
            Text(text = value, fontSize = 20.sp)
        }
    }
}