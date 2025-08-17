plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.jetbrains.compose)
}

android {
    namespace = "com.yowkey.phasecheck"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.yowkey.phasecheck"
        minSdk = 35
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        buildFeatures{
            buildConfig = true
        }
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            buildConfigField("String", "API_ENV", "\"RELEASE\"")
            signingConfig = signingConfigs.getByName("debug")

        }
        getByName("debug") {
            buildConfigField("String", "API_ENV", "\"DEBUG\"")

            applicationIdSuffix = ".debug"
            isDebuggable = true
        }

    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlin {
        jvmToolchain(17)
    }
    buildFeatures {
        compose = true
    }



}

dependencies {
    debugImplementation(libs.library)
    releaseImplementation(libs.library.no.op)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(libs.koin.android)

    // Jetpack Compose dependencies
    implementation(platform(libs.androidx.compose.bom)) // Import the Compose BOM
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3) // For Material Design 3 components

    // Optional - For integration with Activities
    implementation(libs.androidx.activity.compose)
    // Optional - For integration with ViewModels
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    // Optional - For integration with Navigation
    implementation(libs.androidx.navigation.compose)

    // Retrofit for network requests
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.retrofit.serialization)

    implementation(project(":ui"))
    implementation(project(":common"))
    implementation(project(":data"))
    implementation(project(":network"))

    implementation("androidx.core:core-splashscreen:1.0.1")


}