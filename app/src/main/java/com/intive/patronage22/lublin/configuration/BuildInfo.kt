package com.intive.patronage22.lublin.configuration

import com.intive.patronage22.lublin.BuildConfig

class BuildInfo {
    val versionName: String = BuildConfig.VERSION_NAME
    val versionCode: Int = BuildConfig.VERSION_CODE
    val buildSHA: String = BuildConfig.SHA
}