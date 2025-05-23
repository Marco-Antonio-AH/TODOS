plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "prueba.practica"
    compileSdk = 35

    defaultConfig {
        applicationId = "prueba.practica"
        minSdk = 23
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    // Core
    implementation ("androidx.core:core-ktx:1.12.0");
    implementation ("androidx.appcompat:appcompat:1.6.1");
    implementation ("com.google.android.material:material:1.11.0");
    implementation ("androidx.constraintlayout:constraintlayout:2.1.4");

    // Lifecycle & ViewModel
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2");
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2");

    // Retrofit + OkHttp + Moshi
    implementation ("com.squareup.retrofit2:retrofit:2.9.0");
    implementation ("com.squareup.retrofit2:converter-moshi:2.9.0");
    implementation ("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.11");

    // Room
    implementation ("androidx.room:room-runtime:2.6.1");
    kapt ("androidx.room:room-compiler:2.6.1");
    implementation ("androidx.room:room-ktx:2.6.1")

    // Coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3");
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3");

    // Hilt
    implementation ("com.google.dagger:hilt-android:2.48");
    kapt ("com.google.dagger:hilt-compiler:2.48");
    implementation("androidx.hilt:hilt-common:1.0.0")

    // Testing
    testImplementation ("junit:junit:4.13.2");
    androidTestImplementation ("androidx.test.ext:junit:1.1.5");
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1");
}
