package com.example.aiku.screen.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aiku.R
import com.example.aiku.component.CheckBoxWithTitle
import com.example.aiku.component.CustomButton
import com.example.aiku.data.Size
import com.example.aiku.component.TextTitle
import com.example.aiku.data.Padding
import com.example.aiku.ui.theme.AiKUTheme
import com.example.aiku.ui.theme.KakaoBlack
import com.example.aiku.ui.theme.KakaoYellow
import com.example.aiku.ui.theme.MainBlue
import com.example.aiku.ui.theme.MainOrange
import com.example.aiku.utils.auth.kakaoLogin
import com.example.aiku.utils.auth.kakaoTalkLogin

@Composable
fun LoginScreen() {
    val context = LocalContext.current
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = scrollState)
            .background(MainOrange)
            .padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        Image(
            modifier = Modifier

                .padding(bottom = 10.dp)
                .size(163.92.dp, 152.12.dp),
            painter = painterResource(id = R.drawable.ic_logo_character),
            contentDescription = "로고 캐릭터"
        )

        TextTitle(
            padding = Padding(bottom = 10.dp),
            text = R.string.app_slogan.toString(),
            color = MainBlue,
            fontSize = 16
        )

        TextTitle(
            padding = Padding(bottom = 44.dp),
            text = R.string.app_name.toString(),
            color = MainBlue,
            fontSize = 60
        )

        Box(
            modifier = Modifier.padding(bottom = 13.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            CustomButton(
                shape = RoundedCornerShape(8.dp),
                background = KakaoYellow,
                size = Size(height = 54.dp),
                content = {
                    Text(
                        text = "카카오 로그인",
                        color = KakaoBlack,
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.pretendard_bold))
                    )
                },
                onClick = { kakaoTalkLogin(context) }
            )

            Image(
                modifier = Modifier.padding(start = 27.dp),
                painter = painterResource(id = R.drawable.ic_kakao_message_circle),
                contentDescription = "카카오톡 아이콘")
        }

        //로그인 유지
        var loginPersistence by rememberSaveable { mutableStateOf(false) }

        Row(
            modifier = Modifier.padding(horizontal = 5.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CheckBoxWithTitle(
                checkedState = loginPersistence,
                onCheckedChange = { loginPersistence = it },
                checkedColor = Color.Black,
                uncheckedColor = Color.Black,
                checkmarkColor = Color.White,
                title = {
                    Text(
                    text = "로그인 유지",
                    color = KakaoBlack,
                    fontSize = 13.sp,
                    fontFamily = FontFamily(Font(R.font.pretendard_medium))
                )
                }
            )
            Spacer(modifier = Modifier.weight(1f)) //
            Text(
                modifier = Modifier.clickable { kakaoLogin(context) },
                text = "다른 아이디로 로그인",
                textAlign = TextAlign.End,
                color = KakaoBlack,
                fontSize = 13.sp,
                fontFamily = FontFamily(Font(R.font.pretendard_medium))
            )

        }


    }

}

@Preview
@Composable
private fun LoginPreview() {
    AiKUTheme {
        LoginScreen()
    }
}




