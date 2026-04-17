import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
}

kotlin {
    jvm("desktop")

    sourceSets {
        val desktopMain by getting

        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(libs.coroutines.core)
            implementation(libs.ktor.client.core)
        }

        desktopMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation(libs.coroutines.swing)
            implementation(libs.ktor.client.cio)
        }
    }
}

compose.desktop {
    application {
        mainClass = "com.audiobasics.desk.MainKt"

        jvmArgs += listOf("-Dskiko.renderApi=SOFTWARE")

        nativeDistributions {
            targetFormats(TargetFormat.Msi, TargetFormat.Deb)
            packageName = "AudiobasicsDesk"
            packageVersion = "1.0.0"
            description = "Audiobasics Desktop Companion"
            vendor = "Raktim"
            javaHome = System.getenv("JAVA_HOME") ?: ""

            windows {
                menuGroup = "Audiobasics"
                shortcut = true
                dirChooser = true
                upgradeUuid = "a8f3b2c1-4d7e-4a9f-b6c2-1e3d5f7a9b0c"
            }
        }
    }
}
