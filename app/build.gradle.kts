import coreplugins.BuildPlugins.absoluteRawKotlin
import deps.App
import deps.implementations.Framework.appCompat
import deps.implementations.Framework.constraintLayout
import deps.implementations.Framework.coordLayout
import deps.implementations.Framework.drawerLayout
import deps.implementations.Framework.firebaseAnalytics
import deps.implementations.Framework.firebaseBom
import deps.implementations.Framework.gsonConverter
import deps.implementations.Framework.introScreen
import deps.implementations.Framework.navFragment
import deps.implementations.Framework.navRuntime
import deps.implementations.Framework.navUi
import deps.implementations.Framework.retrofit
import deps.implementations.Framework.sharedPreferences
import deps.implementations.KtServices.ktx
import deps.implementations.TestingFramework.androidxTestExt
import deps.implementations.TestingFramework.espressoCore
import deps.implementations.TestingFramework.junit4
import deps.implementations.TestingFramework.standardRunner
import org.gradle.api.JavaVersion.VERSION_1_8

/** Static Imports don't work with plugins */

plugins {
    id(coreplugins.BuildPlugins.androidApplication)
    id(coreplugins.BuildPlugins.kotlinAndroid)
    id(coreplugins.BuildPlugins.kotlinAndroidExtensions)
    id(coreplugins.BuildPlugins.kotlinKapt)
    id(coreplugins.BuildPlugins.firebasePlugin)
}

android {
    compileSdkVersion(AndroidConfigs.compileSdk)
    buildToolsVersion(deps.versions.GradleVersions.buildToolsVersion)

    testOptions {
        unitTests(delegateClosureOf<com.android.build.gradle.internal.dsl.TestOptions.UnitTestOptions> {
            isReturnDefaultValues = true
        })
    }

    compileOptions {
        sourceCompatibility = VERSION_1_8
        targetCompatibility = VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = VERSION_1_8.toString()
    }


    //not needed as of now
    /*signingConfigs {
        register("release") {
            storeFile = file("keystores/foodDelivApp.keystore")
            storePassword = "toooor"
            keyAlias = "key"
            keyPassword = "toooor"
        }
    }*/

    defaultConfig {
        applicationId = (App.id)
        minSdkVersion(AndroidConfigs.minSdk)
        targetSdkVersion(AndroidConfigs.targetSdk)
        versionCode = (App.versionCode)
        versionName = (App.versionName)

        testInstrumentationRunner = standardRunner
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
//            signingConfig = signingConfigs.getByName("release")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        dataBinding = true
    }

}



dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    // put rest deps here
    implementation(absoluteRawKotlin)
    implementation(ktx)
    implementation(appCompat)
    implementation(constraintLayout)
    implementation(introScreen)
    implementation(sharedPreferences)
    implementation(navFragment)
    implementation(navUi)
    implementation(coordLayout)
    implementation(drawerLayout)
    implementation(navRuntime)
    implementation(retrofit)
    implementation(gsonConverter)

    implementation(platform(firebaseBom))
    implementation(firebaseAnalytics)

    // Add the dependencies for any other desired Firebase products
    // https://firebase.google.com/docs/android/setup#available-libraries

    // put test deps here
    testImplementation(junit4)
    androidTestImplementation(espressoCore)
    androidTestImplementation(androidxTestExt)
}
