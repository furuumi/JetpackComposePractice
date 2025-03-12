package com.megmilk.jetpackcomposepractice

import android.app.Application
import com.megmilk.jetpackcomposepractice.data.repository.UserInfoRepository

class App : Application() {
    val userInfoRepository: UserInfoRepository by lazy { UserInfoRepository() }
}