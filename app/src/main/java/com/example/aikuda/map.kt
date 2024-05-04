package com.example.aikuda

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContent
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.CameraPosition
import com.naver.maps.map.CameraUpdate
import com.naver.maps.map.compose.CameraPositionState
import com.naver.maps.map.compose.ExperimentalNaverMapApi
import com.naver.maps.map.compose.LocationTrackingMode
import com.naver.maps.map.compose.MapProperties
import com.naver.maps.map.compose.MapUiSettings
import com.naver.maps.map.compose.Marker
import com.naver.maps.map.compose.MarkerState
import com.naver.maps.map.compose.NaverMap
import com.naver.maps.map.compose.rememberCameraPositionState
import com.naver.maps.map.compose.rememberFusedLocationSource
import kotlinx.coroutines.launch

/**
 * 약속시간 30분 전 공개되는 맵 화면
 * "약속이름", "약속장소", "약속참여인원", "잔여 kilometer수"
 */


/**
 * 네이버 맵 띄우는 함수
 * @param val recipeFontFamily : 폰트. -> 폰트 따로 저장하는 클래스를 만들 필요
 * @param var mapProperties : 맵의 최소, 최대 줌 비율 및 추적기능
 * @param var mapUiSettings : 확대-축소, 추적기능 버튼 활성화 여부
 */
@OptIn(ExperimentalNaverMapApi::class)
@Composable
fun OpenMap() {
    val recipeFontFamily = FontFamily(
        Font(R.font.recipekorea, FontWeight.Medium)
    )
    var mapProperties by remember {
        mutableStateOf(
            MapProperties(
                maxZoom = 10.0,
                minZoom = 5.0,
                locationTrackingMode = LocationTrackingMode.Follow
            )
        )
    }
    var mapUiSettings by remember {
        mutableStateOf(
            MapUiSettings(isLocationButtonEnabled = true)
        )
    }

    NaverMap(
        locationSource = rememberFusedLocationSource(isCompassEnabled = true),
        properties = mapProperties,
        uiSettings = mapUiSettings
    ){
        Marker(
            state = MarkerState(position = LatLng(37.532600, 127.024612)),
            captionText = "Marker in Seoul"
        )
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "롯데시네마 위례\n05:59",
            textAlign = TextAlign.Center,
            fontFamily = recipeFontFamily,
            modifier = Modifier
                .size(186.dp, 53.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(Color.White)
                .wrapContentHeight(align = Alignment.CenterVertically),
            style = TextStyle(
                lineHeight = 1.5.em,
                lineHeightStyle = LineHeightStyle(
                    alignment = LineHeightStyle.Alignment.Center,
                    trim = LineHeightStyle.Trim.None
                )
            )
        )
    }
}


/*val seoul = LatLng(37.532600, 127.024612)
val cameraPositionState: CameraPositionState = rememberCameraPositionState {
    // 카메라 초기 위치를 설정합니다.
    position = CameraPosition(seoul, 11.0)
}
Box(Modifier.fillMaxSize()) {
    NaverMap(cameraPositionState = cameraPositionState)
    Button(onClick = {
        // 카메라를 새로운 줌 레벨로 이동합니다.
        cameraPositionState.move(CameraUpdate.zoomIn())
    }) {
        Text(text = "Zoom In")
    }
}*/



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MapScreen() {
    val recipeFontFamily = FontFamily(
        Font(R.font.recipekorea, FontWeight.Medium)
    )
    val seoul = LatLng(37.532600, 127.024612)
    val config = LocalConfiguration.current
    val position = CameraPosition(seoul, 11.0)
    var showBottomSheet by rememberSaveable {
        mutableStateOf(false)
    }
    val sheetState = rememberModalBottomSheetState()
    var count = 0
    Column {
        /*ModalBottomSheet(
            onDismissRequest = {
                showBottomSheet = false
            },
            sheetState = sheetState,

            ) {

            Text("멤버")
            Row {
                Text("와기멍게")
            }
            Row {
                Text("와기멍게")
            }
            Row {
                Text("와기멍게")
            }

        }*/
        ConstraintLayout(
            modifier = Modifier.fillMaxWidth()
        ) {
            val (exitBtn, text, nextBtn, map) = createRefs()
            IconButton(
                onClick = {},
                modifier = Modifier
                    .size(28.dp, 28.dp)
                    .constrainAs(exitBtn) {
                        top.linkTo(parent.top, margin = 14.dp)
                        end.linkTo(parent.end, margin = 19.dp)
                    }

            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_exit_btn),
                    contentDescription = null
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .height(40.dp)
                    .constrainAs(text) {
                        centerHorizontallyTo(parent)
                        top.linkTo(exitBtn.bottom, margin = 17.dp)
                    }
            ) {
                Text(
                    text = "공머생 집합",
                    fontFamily = recipeFontFamily,
                    textAlign = TextAlign.Center,
                    fontSize = 17.sp
                )
            }
            IconButton(
                onClick = {},
                modifier = Modifier
                    .size(26.dp)
                    .constrainAs(nextBtn) {
                        end.linkTo(parent.end, margin = 20.dp)
                        top.linkTo(exitBtn.bottom, margin = 22.dp)
                    }

            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_next_btn),
                    contentDescription = null,
                )
            }
        }
        Box(
            modifier = Modifier
        ) {
            OpenMap()
        }
    }


}

