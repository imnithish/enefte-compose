object Dependencies {
    val kotlin by lazy { "androidx.core:core-ktx:${Versions.kotlin}" }
    val compose by lazy { "androidx.core:core-ktx:${Versions.compose}" }
    val material by lazy { "androidx.compose.material:material:${Versions.compose}" }
    val composePreview by lazy { "androidx.compose.ui:ui-tooling-preview:${Versions.compose}" }
    val androidXLifecycle by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.androidx_lifecycle}" }
    val activityCompose by lazy { "androidx.activity:activity-compose:${Versions.activity_compose}" }
    val jUnit by lazy { "junit:junit:4.13.2" }
    val jUnitTest by lazy { "androidx.test.ext:junit:1.1.3" }
    val espressoAndroidTest by lazy { "androidx.test.espresso:espresso-core:3.4.0" }
    val composeJUnitAndroidTest by lazy { "androidx.compose.ui:ui-test-junit4:1.1.1" }
    val composeTooling by lazy { "androidx.compose.ui:ui-tooling:1.1.1" }

    object Networking {
        val okHttpBOM by lazy { "com.squareup.okhttp3:okhttp-bom:${Versions.okhttp_bom}" }
        val okHttp by lazy { "com.squareup.okhttp3:okhttp" }
        val okHttpLoggingInterceptor by lazy { "com.squareup.okhttp3:logging-interceptor" }
        val retrofit by lazy { "com.squareup.retrofit2:retrofit:${Versions.retrofit}" }
    }

    object Accompanist {
        val navigationAnimation by lazy { "com.google.accompanist:accompanist-navigation-animation:${Versions.accompanist}" }
    }
}