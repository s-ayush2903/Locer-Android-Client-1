package deps.implementations

import deps.versions.KtServices.coroutinesVersion
import deps.versions.KtServices.kotlinVersion
import deps.versions.TestingFramework
import deps.versions.TestingFramework.espressoIdlingRes
import deps.versions.TestingFramework.fragmentVersion
import deps.versions.TestingFramework.junit4Version
import deps.versions.TestingFramework.junitJupiterVersion
import deps.versions.TestingFramework.mockkVersion

object TestingFramework {

    // core testing deps
    const val jupiterApi = "org.junit.jupiter:junit-jupiter-api:$junitJupiterVersion"
    const val jupiterParams = "org.junit.jupiter:junit-jupiter-params:$junitJupiterVersion"
    const val jupiterEngine = "org.junit.jupiter:junit-jupiter-engine:$junitJupiterVersion"
    const val mockk = "io.mockk:mockk:$mockkVersion"
    const val junit4 = "junit:junit:$junit4Version"

    // instrumentation tests deps
    //Kotlin Dep for testing
    const val ktTest = "org.jetbrains.kotlin:kotlin-test-junit:$kotlinVersion"
    const val coRoutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutinesVersion"

    //Espresso Deps
    const val espressoCore = "androidx.test.espresso:espresso-core:${TestingFramework.espressoCore}"
    const val espressoContrib = "androidx.test.espresso:espresso-contrib:${TestingFramework.espressoCore}"
    const val idlingRes = "androidx.test.espresso:espresso-idling-resource:$espressoIdlingRes"

    //Normal Test Deps
    const val testRunner = "androidx.test:runner:${TestingFramework.testRunner}"
    const val testRules = "androidx.test:rules:${TestingFramework.testRunner}"
    const val testCoreKtx = "androidx.test:core-ktx:${TestingFramework.testCore}"

    //Mockk
    const val mockkAndroid = "io.mockk:mockk-android:$mockkVersion"

    //UI Testing
    const val fragmentTesting = "androidx.fragment:fragment-testing:$fragmentVersion"
    const val androidxTestExt = "androidx.test.ext:junit-ktx:${TestingFramework.androidxTestExt}"

    //custom test runner
    const val instrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"  //i'll use a custom test runner here later

    // standard test Runner
    const val standardRunner = "androidx.test.runner.AndroidJUnitRunner"
 }
