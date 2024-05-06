package com.example.aiku.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aiku.R
import com.example.aiku.data.Padding

@Composable
fun TextTitle(
    padding: Padding = Padding(),
    text: String,
    color: Color = Color.Black,
    fontSize: Int
) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = padding.start,
                top = padding.top,
                end = padding.end,
                bottom = padding.bottom
            ),
        text = text,
        color = color,
        fontSize = fontSize.sp,
        fontFamily = FontFamily(Font(R.font.recipekorea)),
        textAlign = TextAlign.Center
    )
}