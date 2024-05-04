package com.example.aikuda

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.ButtonColors
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun MakeGroup(){
    val recipeFontFamily = FontFamily(
        Font(R.font.recipekorea, FontWeight.Medium)
    )
    ConstraintLayout(
        modifier = Modifier.fillMaxWidth()
    ) {
        val (beforeBtn, grpName, textGrpName,
            grpNameDescription, grpIntroduce,
            textGrpIntroduce, grpIntroduceDescription,
            createGrp) = createRefs()
        IconButton(
            onClick = {},
            modifier = Modifier
                .size(26.dp, 26.dp)
                .constrainAs(beforeBtn) {
                    top.linkTo(parent.top, 34.dp)
                    start.linkTo(parent.start, 20.dp)
                }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_before_btn),
                contentDescription = null
            )
        }
        Row(
            modifier = Modifier
                .height(40.dp)
                .constrainAs(grpName) {
                    top.linkTo(parent.top, 116.dp)
                    start.linkTo(parent.start, 30.dp)
                }
        ) {
            Text(
                text = "그룹 이름",
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                fontFamily = recipeFontFamily
            )
        }
        Row(
            modifier = Modifier
                .constrainAs(textGrpName) {
                    top.linkTo(parent.top, 190.dp)
                    start.linkTo(parent.start, 30.dp)
                }
        ) {
            TextField(
                value = "그룹 이름을 입력하세요",
                onValueChange = {},
            )

        }
        Row(
            modifier = Modifier
                .height(14.dp)
                .constrainAs(grpNameDescription) {
                    top.linkTo(parent.top, 225.dp)
                    start.linkTo(parent.start, 30.dp)
                }
        ) {
            Text(
                text = "최대 15자 입력이 가능합니다",
                textAlign = TextAlign.Center,
                fontSize = 12.sp
            )
        }
        Row(
            modifier = Modifier
                .height(40.dp)
                .constrainAs(grpIntroduce) {
                    top.linkTo(parent.top, 301.dp)
                    start.linkTo(parent.start, 30.dp)
                }
        ) {
            Text(
                text = "그룹 소개",
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                fontFamily = recipeFontFamily
            )
        }
        Row(
            modifier = Modifier
                .constrainAs(textGrpIntroduce) {
                    top.linkTo(parent.top, 375.dp)
                    start.linkTo(parent.start, 30.dp)
                }
        ) {
            TextField(
                value = "그룹 소개를 입력하세요",
                onValueChange = {},
            )

        }
        Row(
            modifier = Modifier
                .height(14.dp)
                .constrainAs(grpIntroduceDescription) {
                    top.linkTo(parent.top, 410.dp)
                    start.linkTo(parent.start, 30.dp)
                }
        ) {
            Text(
                text = "최대 20자 입력이 가능합니다",
                textAlign = TextAlign.Center,
                fontSize = 12.sp
            )
        }
        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFF8811)
            ),
            modifier = Modifier
                .size(320.dp, 54.dp)
                .constrainAs(createGrp){
                    bottom.linkTo(parent.bottom, 22.dp)
                    centerHorizontallyTo(parent)
                }
        ) {
            Text(
                text = "생성하기",
                fontSize = 18.sp
            )
        }
    }
}