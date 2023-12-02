plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.androidLibrary)
    id("module.publication")
}

kotlin {
    applyDefaultHierarchyTemplate()
    explicitApi()

    androidTarget {
        publishLibraryVariants("release")
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    androidNativeArm32()
    androidNativeArm64()
    androidNativeX86()
    androidNativeX64()
    jvm {
        jvmToolchain(11)
    }
    js(IR) {
        browser()
        nodejs()
        binaries.executable()
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    tvosX64()
    tvosArm64()
    tvosSimulatorArm64()
    watchosX64()
    watchosArm32()
    watchosArm64()
    watchosDeviceArm64()
    watchosSimulatorArm64()
    linuxX64()
    linuxArm64()
    macosX64()
    macosArm64()
    mingwX64()
    @OptIn(org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl::class)
    wasmJs()
    @OptIn(org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl::class)
    wasmWasi()

    sourceSets {
        /* Main source sets */
        val commonMain by getting {
            dependencies {
                // The library is lightweight, we don't use any other dependencies :D
            }
        }

        /* Test source sets */
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}

android {
    namespace = "com.mohamedrejeb.ksoup.entities"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
}