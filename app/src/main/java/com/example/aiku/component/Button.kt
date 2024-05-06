package com.example.aiku.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp
import com.example.aiku.data.Border
import com.example.aiku.data.Margin
import com.example.aiku.data.Padding
import com.example.aiku.data.Shadow
import com.example.aiku.data.Size

@Composable
fun CustomButton(
    enabled : Boolean = true,
    shape: Shape,
    background: Color,
    size: Size = Size(),
    border: Border = Border(0.dp, Color.Transparent, RoundedCornerShape(8.dp)),
    shadow: Shadow = Shadow(0.dp),
    padding: Padding = Padding(),
    content: @Composable RowScope.() -> Unit, //도형 안에 들어갈 컨텐츠
    onClick: () -> Unit = {}

) {
    Button(
        enabled = enabled,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = background,
            disabledContainerColor = background),
        modifier = Modifier
            .fillMaxWidth()
            .height(size.height)
            .background(color = background, shape = shape)
            .border(
                width = border.width,
                brush = SolidColor(border.color),
                shape = border.shape
            )
            .shadow(
                elevation = shadow.elevation,
                shadow.shape,
                shadow.clip,
                shadow.ambientColor,
                shadow.spotColor
            ),
        contentPadding = PaddingValues(
            start = padding.start,
            top = padding.top,
            end = padding.end,
            bottom = padding.end
        ),
        content = content
    )
}