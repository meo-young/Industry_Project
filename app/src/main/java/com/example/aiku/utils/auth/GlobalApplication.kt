package com.example.aiku.utils.auth

import android.app.Application
import com.example.aiku.R
import com.kakao.sdk.common.KakaoSdk

class GlobalApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // 다른 초기화 코드들

        // Kakao SDK 초기화
        KakaoSdk.init(this, getString(R.string.native_app_key))
    }
}

