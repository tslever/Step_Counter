package com.tslever.stepcounter

import android.content.Context
import android.content.pm.PackageManager
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.io.File
import java.io.IOException

class MainActivity : AppCompatActivity(), SensorEventListener {

    private val fileName: String = "number_of_steps.txt"
    private var numberOfSteps: Float = -1f
    private var sensor: Sensor? = null
    private lateinit var sensorManager: SensorManager
    private lateinit var textViewOfNumberOfSteps: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (checkSelfPermission(android.Manifest.permission.ACTIVITY_RECOGNITION) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(arrayOf(android.Manifest.permission.ACTIVITY_RECOGNITION), 100)
        }
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)
        textViewOfNumberOfSteps = findViewById(R.id.textViewOfNumberOfSteps)
    }

    override fun onResume() {
        super.onResume()
        sensor?.also {
            sensorManager.registerListener(this, it, SensorManager.SENSOR_DELAY_NORMAL)
        }
        numberOfSteps = loadNumberOfSteps() - 1
        textViewOfNumberOfSteps.text = "number of steps: ${numberOfSteps}"
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event?.sensor?.type == Sensor.TYPE_STEP_COUNTER) {
            numberOfSteps += 1
            saveNumberOfSteps()
            textViewOfNumberOfSteps.text = "number of steps: ${numberOfSteps.toInt()}"
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

    private fun loadNumberOfSteps(): Float {

        val file = File(filesDir, fileName)

        if (!file.exists()) {
            try {
                file.writeText("0")
            } catch (e: IOException) {
                val numberOfStepsLoaded = -2f
                return numberOfStepsLoaded
            }
        }

        return try {
            openFileInput(fileName).use { inputStream ->
                val stringRepresentingNumberOfSteps = inputStream.bufferedReader().readLine()
                stringRepresentingNumberOfSteps?.toFloatOrNull() ?: -1f
            }
        } catch (e: IOException) {
            -2f
        }
    }

    private fun saveNumberOfSteps() {
        try {
            openFileOutput(fileName, Context.MODE_PRIVATE).use { outputStream ->
                outputStream.write(numberOfSteps.toString().toByteArray())
            }
        } catch (e: IOException) {
            // On write error, do nothing
        }
    }
}