package com.yowkey.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.yowkey.data.models.WeatherType
import com.yowkey.ui.R
import com.yowkey.ui.components.theme.cloudyComplementColorStart
import kotlinx.datetime.LocalTime

@Preview
@Composable
fun WeatherContainer(
    weatherType: WeatherType = WeatherType.SUNNY,
    time: LocalTime = LocalTime(23, 30),
    onClick: () -> Unit = {},
) {
    val context = LocalContext.current
    val imageLoader = remember { createImageLoader(context) }

    var gifLoading by remember { mutableIntStateOf(R.drawable.loading3) }
    var borderStroke by remember { mutableStateOf(White) }
    Column(
        Modifier
            .background(Transparent, shape = RoundedCornerShape(8.dp))
            .border(BorderStroke(1.dp, borderStroke), shape = RoundedCornerShape(8.dp))
            .height(100.dp)
            .width(250.dp)
            .padding(12.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = time.toString(),
                    color = White,
                    style = TextStyle(
                        fontSize = 25.sp
                    )
                )
                Text(
                    text = weatherType.toString(),
                    color = White,
                    style = TextStyle(
                        fontSize = 30.sp
                    )
                )
            }
            Image(
                modifier = Modifier
                    .size(100.dp)
                    .clickable(onClick = onClick),
                painter = rememberAsyncImagePainter(gifLoading, imageLoader),
                contentDescription = null
            )
        }
    }
}