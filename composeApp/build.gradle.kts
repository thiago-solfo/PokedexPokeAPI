import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.kotlinSerialization)
}

kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }
    
    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }
    
    sourceSets {
        androidMain.dependencies {
            implementation(libs.compose.uiToolingPreview)
            implementation(libs.androidx.activity.compose)
            implementation("io.ktor:ktor-client-okhttp:3.0.0")
            implementation("app.cash.sqldelight:android-driver:2.1.0")
            implementation("com.google.accompanist:accompanist-systemuicontroller:0.36.0")
            implementation("androidx.core:core:1.16.0")
            implementation("androidx.activity:activity-compose:1.10.1")
            implementation("io.insert-koin:koin-android:4.1.1")
            implementation("io.insert-koin:koin-androidx-compose:4.1.1")

        }
        iosMain.dependencies {
            implementation("app.cash.sqldelight:native-driver:2.1.0")
            implementation("io.ktor:ktor-client-darwin:3.0.0")
        }
        commonMain.dependencies {
            implementation(libs.compose.runtime)
            implementation(libs.compose.foundation)
            implementation(libs.compose.material3)
            implementation(libs.compose.ui)
            implementation(libs.compose.components.resources)
            implementation(libs.compose.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodelCompose)
            implementation(libs.androidx.lifecycle.runtimeCompose)
            implementation("org.jetbrains.compose.material:material-icons-extended:1.7.3")
            implementation("org.jetbrains.androidx.navigation:navigation-compose:2.9.2")
            implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")
            implementation("io.coil-kt.coil3:coil-compose:3.0.4")
            implementation("io.coil-kt.coil3:coil-network-ktor3:3.0.4")
            implementation("io.insert-koin:koin-core:4.1.1")
            implementation("io.insert-koin:koin-compose:4.1.1")
            implementation("org.jetbrains.compose.material:material:1.7.3")
            implementation("org.jetbrains.compose.material:material-icons-extended:1.7.3")
            implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:1.9.0")
            implementation("dev.chrisbanes.material3:material3-window-size-class-multiplatform:0.5.0")
            implementation("app.cash.sqldelight:runtime:2.1.0")
            implementation("app.cash.sqldelight:coroutines-extensions:2.1.0")
            implementation("app.cash.sqldelight:primitive-adapters:2.1.0")
            implementation("com.russhwolf:multiplatform-settings-no-arg:1.3.0")
            implementation("com.russhwolf:multiplatform-settings-coroutines:1.3.0")
            implementation("io.github.aakira:napier:2.7.1")
            implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.6.2")
            implementation("io.github.koalaplot:koalaplot-core:0.9.0")
            implementation("org.jetbrains.kotlin:kotlin-stdlib:2.2.20")
            implementation("org.jetbrains.androidx.lifecycle:lifecycle-viewmodel-compose:2.9.1")
            implementation("org.jetbrains.androidx.navigation:navigation-compose:2.9.2")
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "com.example.pokedexpokeapi"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.example.pokedexpokeapi"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    debugImplementation(libs.compose.uiTooling)
}

