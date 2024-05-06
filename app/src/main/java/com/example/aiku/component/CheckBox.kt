package com.example.aiku.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aiku.R
import com.example.aiku.data.Padding
import com.example.aiku.ui.theme.MainOrange
import com.example.aiku.ui.theme.unselectedOrange

@Composable
fun CheckBoxWithTitle(
    checkedState: Boolean,
    onCheckedChange: ((Boolean) -> Unit)?,
    checkedColor: Color = Color.Black,
    uncheckedColor: Color = Color.Black,
    checkmarkColor: Color = Color.White,
    isChecked: () -> Unit = {}, //수정

    title: @Composable () -> Unit

) {

    // Checkbox 색상정의
    val checkboxColors = CheckboxDefaults.colors(
        checkedColor = checkedColor, // 체크된 상태의 색상 (테두리 + 배경)
        uncheckedColor = uncheckedColor, // 체크되지 않은 상태의 색상
        checkmarkColor = checkmarkColor, // 체크 마크의 색상
        disabledCheckedColor = Color.Gray, // 비활성화 상태에서 선택되었을 때
        disabledUncheckedColor = Color.Gray, //비활성화 상태에서 선택되지 않았을 때
        disabledIndeterminateColor = Color.Gray //?
    )

    Row(
        modifier = Modifier
            .toggleable(
                value = checkedState,
                onValueChange = {
                    if (onCheckedChange != null) {
                        onCheckedChange(!checkedState)
                    }
                },
                role = Role.Checkbox
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start

    ) {
        Checkbox(
            modifier = Modifier //checkbox defalut padding 삭제
                .size(18.dp),
            checked = checkedState,
            onCheckedChange = onCheckedChange,
            enabled = true, //활성, 비활성
            colors = checkboxColors
        )

        Spacer(modifier = Modifier.width(12.dp)) // 6dp 간격 추가

        title()


        if (checkedState) {
            //체크박스가 선택되었을 때
            //isChecked()

        } else {
            //체크박스가 선택되지 않았을 때

        }
    }

}

@Composable
fun CheckboxWithCheckmark(
    padding: Padding = Padding(),
    checkedState: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    checkedColor: Color = Color.Black,
    uncheckedColor: Color = Color.Black,
    checkedCheckmarkColor: Color = Color.White,
    uncheckedCheckmarkColor: Color = Color.White,
    title: @Composable () -> Unit

) {

    var checkmarkColor: Color
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(
                start = padding.start,
                top = padding.top,
                end = padding.end,
                bottom = padding.bottom
            )
            .clickable(onClick = { onCheckedChange(!checkedState) })
    ) {
        Box(
            modifier = Modifier
                .size(18.dp)
                .background(
                    color = if (checkedState) checkedColor else uncheckedColor,
                    shape = RoundedCornerShape(5.dp)
                )
        ) {
            if (checkedState) checkmarkColor = checkedCheckmarkColor
            else checkmarkColor = uncheckedCheckmarkColor

            Image(
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(12.dp, 8.25.dp),
                painter = painterResource(id = R.drawable.ic_checkmark),
                contentDescription = "체크마크",
                colorFilter = ColorFilter.tint(color = checkmarkColor)
            )

        }
        Spacer(modifier = Modifier.width(8.dp))
        title()
    }
}

@Composable
fun Checkmark(
    padding: Padding = Padding(),
    checkedState: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    text: String

) {

    var checkmarkColor: Color
    Row(
        modifier = Modifier
            .padding(
            start = padding.start,
            top = padding.top,
            end = padding.end,
            bottom = padding.bottom
        ),
        verticalAlignment = Alignment.CenterVertically,

        ) {

        Box(
            modifier = Modifier
                .background(color = Color.Transparent)
                .clickable(onClick = { onCheckedChange(!checkedState) })
        ) {
            if (checkedState) checkmarkColor = MainOrange
            else checkmarkColor = unselectedOrange
            Image(
                modifier = Modifier
                    .size(16.dp, 11.dp),
                painter = painterResource(id = R.drawable.ic_checkmark),
                contentDescription = "체크마크",
                colorFilter = ColorFilter.tint(color = checkmarkColor)
            )

        }

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = text,
            fontSize = 16.sp,
            fontFamily = FontFamily(Font(R.font.pretendard_light)),
            textDecoration = TextDecoration.Underline,
            modifier = Modifier.clickable(onClick = {})
        )
    }
}