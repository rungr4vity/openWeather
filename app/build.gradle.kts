plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
    id ("com.google.dagger.hilt.android")

}

android {
    namespace = "il.pacolo.com.appweather"
    compileSdk = 34

    defaultConfig {
        applicationId = "il.pacolo.com.appweather"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    flavorDimensions += "tier"
    productFlavors {
        create("free") {
            dimension = "tier"
            applicationIdSuffix = ".free"
        }
        create("paid") {
            dimension = "tier"
            applicationIdSuffix = ".paid"
        }
    }



    buildTypes {

        debug {
            isDebuggable = true
        }

        release {
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
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }



}



dependencies {

    implementation("androidx.compose.runtime:runtime-livedata:1.7.2")
    implementation("androidx.test.ext:junit-ktx:1.2.1")
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    testImplementation("androidx.compose.ui:ui-test-junit4-android:1.6.8")

    val retrofit_version = "2.9.0"
    val hilt_version = "2.52"



    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.4")
    implementation("androidx.activity:activity-compose:1.9.0")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")

    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")


    // Dagger - Hilt
    //implementation ("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")
    implementation("com.google.dagger:hilt-android:$hilt_version")
    kapt("com.google.dagger:hilt-android-compiler:$hilt_version")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")

    // Test
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    testImplementation("org.robolectric:robolectric:4.10.3")    // or latest 4.x
    testImplementation("androidx.test:core:1.5.0")
    // Optional: for Kotlin-friendly assertions
    testImplementation("org.jetbrains.kotlin:kotlin-test:1.9.10")

    // Retrofit
    implementation ("com.squareup.retrofit2:retrofit:$retrofit_version")
    // Gson for JSON parsing
    implementation ("com.squareup.retrofit2:converter-gson:$retrofit_version")
    // Optional: Logging Interceptor for monitoring network requests (if needed)
    implementation ("com.squareup.okhttp3:logging-interceptor:4.9.3")


    val nav_version = "2.7.7"
    implementation("androidx.navigation:navigation-compose:$nav_version")

    implementation ("androidx.compose.material:material:1.6.6")
    implementation("androidx.credentials:credentials:1.3.0-alpha03")

    implementation("androidx.hilt:hilt-navigation-fragment:1.0.0")

    implementation ("com.google.android.gms:play-services-location:21.0.1")


    // Test rules and runner
    androidTestImplementation ("androidx.test:rules:1.5.0")
    androidTestImplementation ("androidx.test:runner:1.5.0")

    // Compose UI Test Manifest.
    debugImplementation ("androidx.compose.ui:ui-test-manifest:1.5.0")

    implementation("io.coil-kt:coil-compose:2.7.0")

    implementation ("androidx.datastore:datastore-preferences:1.0.0")

    // Mockito
    testImplementation ("org.mockito:mockito-core:4.11.0")
    androidTestImplementation ("org.mockito:mockito-android:4.11.0")


    // Hilt testing
    androidTestImplementation ("com.google.dagger:hilt-android-testing:2.48")
    kaptAndroidTest ("com.google.dagger:hilt-compiler:2.48")


    // Room components
    val roomVersion = "2.5.2"
    implementation("androidx.room:room-runtime:$roomVersion")
    kapt("androidx.room:room-compiler:$roomVersion")
    implementation("androidx.room:room-ktx:$roomVersion") // Kotlin Extensions


    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1") // Make sure to use the latest coroutines version


    // test
    implementation(kotlin("test"))
}

kapt {
    correctErrorTypes = true
}