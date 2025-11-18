package com.example.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
@HiltAndroidApp
class HiltApplication : Application() {
    // 앱 초기화 로직이 필요하면 여기서 작성
}
