package deps.implementations

import deps.versions.KtServices

object KtServices {
    //Kotlin Deps
    const val ktStandardLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${KtServices.kotlinVersion}"
    const val ktReflect = "org.jetbrains.kotlin:kotlin-reflect:${KtServices.kotlinVersion}"
    const val ktx = "androidx.core:core-ktx:${KtServices.ktx}"

    //For Network Calls using Kt
    const val ktCoRoutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${KtServices.coroutinesVersion}"
    const val ktCoRoutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${KtServices.coroutinesVersion}"
    const val ktCoRoutinesPlayServices = "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:${KtServices.coroutinesPlayServices}"
}
