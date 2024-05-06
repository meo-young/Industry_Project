package com.example.aiku.data

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Size(val width: Dp = 0.dp, val height: Dp = 0.dp)
data class Border(val width: Dp, val color: Color, val shape: Shape)
data class Padding(val start: Dp = 0.dp, val end: Dp = 0.dp, val top: Dp = 0.dp, val bottom: Dp = 0.dp)
data class Margin(val start: Dp = 0.dp, val end: Dp = 0.dp, val top: Dp = 0.dp, val bottom: Dp = 0.dp)
data class Shadow(
    val elevation: Dp,
    val shape: Shape = RectangleShape,
    val clip: Boolean = elevation > 0.dp,
    val ambientColor: Color = DefaultShadowColor,
    val spotColor: Color = DefaultShadowColor
)
