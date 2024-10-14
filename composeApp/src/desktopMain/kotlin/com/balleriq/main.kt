package com.balleriq

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.balleriq.app.App

fun main() =
    application {
        initKoin {}

        Window(
            onCloseRequest = ::exitApplication,
            title = "BallerIQ",
        ) {
            App()
        }
    }
