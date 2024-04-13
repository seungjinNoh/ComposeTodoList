// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    val hilt_version = "2.44"

    dependencies {
        classpath("com.google.dagger:hilt-android-gradle-plugin:$hilt_version")
    }
}

plugins {
    id("com.android.application") version "8.2.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
}

