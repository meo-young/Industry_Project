package com.example.aiku.screen.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aiku.R
import com.example.aiku.component.CheckboxWithCheckmark
import com.example.aiku.component.Checkmark
import com.example.aiku.component.CustomButton
import com.example.aiku.data.Padding
import com.example.aiku.data.Size
import com.example.aiku.ui.theme.AiKUTheme
import com.example.aiku.ui.theme.KakaoBlack
import com.example.aiku.ui.theme.MainOrange
import com.example.aiku.ui.theme.unselectedOrange

@Composable
fun SignUpTermScreen() {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxSize()
            .verticalScroll(state = scrollState)
            .background(Color.White)
            .padding(start = 20.dp, end = 20.dp, bottom = 36.dp)
    ) {

        Column {
            Image(
                modifier = Modifier
                    .padding(top = 93.61.dp, bottom = 3.dp)
                    .size(85.2.dp, 68.07.dp),
                painter = painterResource(id = R.drawable.ic_logo_character_hi),
                contentDescription = "로고 캐릭터"
            )

            Text(
                text = "AiKU에\n오신 것을 환영합니다!",
                fontSize = 32.sp,
                fontFamily = FontFamily(Font(R.font.pretendard_semibold)),
                textAlign = TextAlign.Start,
                lineHeight = 40.sp
            )

        }

        Spacer(modifier = Modifier.weight(1f)) // 왼쪽 여백 추가

        //CheckBox
        var checkedService by rememberSaveable { mutableStateOf(false) }
        var checkedState2 by rememberSaveable { mutableStateOf(false) }
        var checkedState3 by rememberSaveable { mutableStateOf(false) }
        var checkedState4 by rememberSaveable { mutableStateOf(false) }

        var checkedAll by rememberSaveable {
            mutableStateOf(checkedService && checkedState2 && checkedState3 && checkedState4)
        }


        //btn
        var btnBackgroundColor: Color //동의하고 시작하기 버튼 배경색
        var isEnabled: Boolean //동의하고 시작하기 버튼 활성여부

        if (checkedAll or checkedService) {
            btnBackgroundColor = MainOrange
            isEnabled = true

        } else {
            btnBackgroundColor = unselectedOrange
            isEnabled = false
        }


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 5.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            CheckboxWithCheckmark(
                padding = Padding(bottom = 36.dp),
                checkedState = checkedAll,
                onCheckedChange = {
                    checkedAll = it
                    checkedService = it
                    checkedState2 = it
                    checkedState3 = it
                    checkedState4 = it
                },
                checkedColor = MainOrange,
                uncheckedColor = unselectedOrange,
                checkedCheckmarkColor = Color.White,
                uncheckedCheckmarkColor = Color.White,
                title = {
                    Text(
                        text = "전체 동의",
                        color = KakaoBlack,
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.pretendard_medium))
                    )
                }
            )

            Checkmark(
                padding = Padding(bottom = 19.dp),
                checkedState = checkedService,
                onCheckedChange = {
                    checkedService = it
                    checkedAll = it && checkedState2 && checkedState3 && checkedState4
                                  },
                text = "서비스 이용 약관 (필수)"
            )
            Checkmark(
                padding = Padding(bottom = 19.dp),
                checkedState = checkedState2,
                onCheckedChange = {
                    checkedState2 = it
                    checkedAll = checkedService && it && checkedState3 && checkedState4
                                  },
                text = "서비스 이용 약관 (필수)"
            )
            Checkmark(
                padding = Padding(bottom = 19.dp),
                checkedState = checkedState3,
                onCheckedChange = {
                    checkedState3 = it
                    checkedAll = checkedService && checkedState2 && it && checkedState4
                                  },
                text = "서비스 이용 약관 (필수)"
            )
            Checkmark(
                padding = Padding(bottom = 52.dp),
                checkedState = checkedState4,
                onCheckedChange = {
                    checkedState4 = it
                    checkedAll = checkedService && checkedState2 && checkedState3 && it
                                  },
                text = "서비스 이용 약관 (필수)"
            )

        }

        CustomButton(
            enabled = isEnabled,
            shape = RoundedCornerShape(8.dp),
            background = btnBackgroundColor,
            size = Size(height = 54.dp),
            content = {
                Text(
                    text = "동의하고 시작하기",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.pretendard_bold))
                )
            },
            onClick = { }
        )
    }
}


@Preview
@Composable
private fun SignUpTermPreview() {
    AiKUTheme {
        SignUpTermScreen()
    }
}