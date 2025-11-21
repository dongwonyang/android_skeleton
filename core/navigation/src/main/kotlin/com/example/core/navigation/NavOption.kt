package com.example.core.navigation

import androidx.navigation.navOptions

val resetStackNavOptions  = navOptions {
    popUpTo(0) { inclusive = true }   // 스택 전체 제거
    launchSingleTop = true            // 동일 화면 중복 생성 방지
}