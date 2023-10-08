package com.techlads.benchmark

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiObject2
import androidx.test.uiautomator.Until
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ViaplayTesting {

    private lateinit var device: UiDevice

    @Test
    fun checkIfViaplayIsInstalled() {
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        device.pressHome()

        val gmail: UiObject2 = device.findObject(By.text("ExoAdapter"))
// Perform a click and wait until the app is opened.
        val opened: Boolean = gmail.clickAndWait(Until.newWindow(), 3000)
        assert(opened)
    }
}