package com.tslever.stepcounter

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity(), SensorEventListener {

    private lateinit var sensorManager: SensorManager
    private var stepCounterSensor: Sensor? = null
    private var initialStepCount: Float = -1f
    private lateinit var stepCountTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        stepCountTextView = findViewById(R.id.stepCountTextView)

        // Get the sensor manager
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        // Try to get the step counter sensor
        stepCounterSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)

        if (stepCounterSensor == null) {
            // Device does not have a step counter sensor
            stepCountTextView.text = "Step Counter not available."
        } else {
            stepCountTextView.text = "Steps: 0"
        }
    }

    override fun onResume() {
        super.onResume()
        // Register the sensor listener if available
        stepCounterSensor?.also {
            sensorManager.registerListener(this, it, SensorManager.SENSOR_DELAY_NORMAL)
        }
    }

    override fun onPause() {
        super.onPause()
        // Unregister the sensor listener to save battery
        sensorManager.unregisterListener(this)
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event?.sensor?.type == Sensor.TYPE_STEP_COUNTER) {
            val totalSteps = event.values[0]

            // The first reading you get is the total steps since the last reboot.
            // Store this initial value to calculate steps taken since app start.
            if (initialStepCount < 0) {
                initialStepCount = totalSteps
            }

            val stepsSinceStart = totalSteps - initialStepCount
            stepCountTextView.text = "Steps: ${stepsSinceStart.toInt()}"
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        // Not used in this example
    }
}