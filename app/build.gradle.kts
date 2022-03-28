plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        applicationId = "com.imnstudios.enefte"
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(Dependencies.Accompanist.navigationAnimation)
    implementation(Dependencies.Accompanist.systemUIController)
    implementation(Dependencies.Accompanist.pager)
    implementation(Dependencies.Accompanist.pagerIndicator)
    implementation(platform(Dependencies.Networking.okHttpBOM))
    implementation(Dependencies.Networking.okHttp)
    implementation(Dependencies.Networking.okHttpLoggingInterceptor)
    implementation(Dependencies.Networking.retrofit)
    implementation(Dependencies.kotlin)
    implementation(Dependencies.compose)
    implementation(Dependencies.composeFoundation)
    implementation(Dependencies.material)
    implementation(Dependencies.composePreview)
    implementation(Dependencies.androidXLifecycle)
    implementation(Dependencies.activityCompose)
    testImplementation(Dependencies.jUnit)
    testImplementation(Dependencies.jUnitTest)
    androidTestImplementation(Dependencies.espressoAndroidTest)
    androidTestImplementation(Dependencies.composeJUnitAndroidTest)
    debugImplementation(Dependencies.composeTooling)
}