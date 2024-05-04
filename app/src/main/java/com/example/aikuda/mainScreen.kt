package com.example.aikuda

import android.graphics.fonts.FontStyle
import android.view.RoundedCorner
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun mainScreen() {
    val recipeFontFamily = FontFamily(
        Font(R.font.recipekorea, FontWeight.Medium)
    )
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.padding(top = 10.dp),
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    titleContentColor = MaterialTheme.colorScheme.background,

                    ),
                title = {
                    Text(
                        text = "AiKU",
                        color = Color(0xFFFF8811),
                        fontSize = 22.sp,
                        fontFamily = recipeFontFamily
                    )
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Default.Favorite, contentDescription = null)
                    }
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = null)
                    }
                }
            )
        },
        bottomBar = { //navigation bar는 독립적인 요소를 연결해줄 때 사용
            BottomAppBar(
                containerColor = Color(0xFFFF8811),
                contentColor = Color.White,
            ) {
                BottomNavigationBar(navController)
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { },
                modifier = Modifier
                    .size(68.dp, 68.dp)
                    .offset(0.dp, 60.dp)
                    .clip(CircleShape),
                containerColor = Color.Blue,
            ) {
                Icon(Icons.Default.Home, contentDescription = null)
            }
        },
        floatingActionButtonPosition = FabPosition.Center
    ) { innerPadding -> //contents 사용할 때에는 innerPadding을 지정해야함
        ConstraintLayout(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxWidth()
        ) {
            val (requireText, character, addGroupBtn, map) = createRefs()
            Row(
                modifier = Modifier
                    .constrainAs(requireText) {
                        top.linkTo(parent.top, margin = 170.dp)
                        centerHorizontallyTo(parent)
                    }
            ) {
                Text(
                    text = "그룹을 만들어주세요!",
                    fontFamily = recipeFontFamily,
                    fontSize = 22.sp,
                    textAlign = TextAlign.Center
                )
            }
            Icon(
                painter = painterResource(id = R.drawable.ic_mainscreen_character),
                contentDescription = null,
                modifier = Modifier
                    .size(155.86.dp, 220.99.dp)
                    .constrainAs(character) {
                        top.linkTo(parent.top, margin = 225.dp)
                        centerHorizontallyTo(parent)
                    }
            )
            OutlinedButton(
                onClick = {},
                border = BorderStroke(3.dp, Color(0xFFFF8811)),
                modifier = Modifier
                    .height(48.dp)
                    .constrainAs(addGroupBtn) {
                        top.linkTo(character.bottom, margin = 19.dp)
                        centerHorizontallyTo(parent)
                    }
            ) {
                Text(
                    text = "+그룹 생성하기",
                    textAlign = TextAlign.Center,
                    color = Color(0xFFFF8811),
                    fontSize = 18.sp
                )
            }
        }


    }

}