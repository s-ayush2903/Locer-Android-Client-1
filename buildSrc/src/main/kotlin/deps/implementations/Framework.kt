package deps.implementations

import deps.versions.Framework

/* Put kapts too here */
// All android deps go in here (other than testing ones)
object Framework {

    // Jetpack Deps
    const val navFragment = "androidx.navigation:navigation-fragment-ktx:${Framework.navComponents}"
    const val navRuntime = "androidx.navigation:navigation-runtime:${Framework.navComponents}"
    const val navUi = "androidx.navigation:navigation-ui-ktx:${Framework.navComponents}"
    const val navDynamic = "androidx.navigation:navigation-dynamic-features-fragment:${Framework.navComponents}"

    // Core deps
    const val appCompat = "androidx.appcompat:appcompat:${Framework.appCompat}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Framework.constraintLayout}"
    const val materialDesign = "com.google.android.material:material:${Framework.materialDesign}"
    const val swipeRefreshLayout = "androidx.swiperefreshlayout:swiperefreshlayout:${Framework.swipeRefreshLayout}"
    const val coordLayout = "androidx.coordinatorlayout:coordinatorlayout:${Framework.coordLayout}"
    const val drawerLayout = "androidx.drawerlayout:drawerlayout:${Framework.drawerLayout}"
    const val sharedPreferences = "androidx.preference:preference-ktx:${Framework.sharedPreferences}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Framework.retrofit}"
    const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Framework.retrofit}"

    //Lifecycle handling
//    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime:${Framework.lifecycleVersion}"
//    const val lifecycleCoRoutines = "androidx.lifecycle:lifecycle-livedata-ktx:${Framework.lifecycleVersion}"


    // Firebase Deps
    const val firebaseServices = "com.google.gms:google-services:${Framework.firebaseServices}"
    const val firebaseBom = "com.google.firebase:firebase-bom:${Framework.firebaseBom}"
    const val firebaseAnalytics = "com.google.firebase:firebase-analytics-ktx"
    const val firebaseAuth = "com.firebaseui:firebase-ui-auth:${Framework.firebaseAuth}"


    // External Libs (like introScreen)
    const val introScreen = "com.github.AppIntro:AppIntro:${Framework.introScreen}"
}

/* Activate the commented out deps when they are need to be in use and use their most stable version not the latest one */
