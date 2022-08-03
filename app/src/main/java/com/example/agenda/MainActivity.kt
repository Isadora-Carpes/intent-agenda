package com.example.agenda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract
import android.provider.CalendarContract.Events.*
import android.widget.Button
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val startMillis: Long = Calendar.getInstance().run {
            set(2022, 7, 3, 21, 0)
            timeInMillis
        }
        val endMillis: Long = Calendar.getInstance().run {
            set(2022, 7, 3, 22, 0)
            timeInMillis
        }

        val btnSetEvent = findViewById<Button>(R.id.set_event)
        btnSetEvent.setOnClickListener {
            val intent = Intent(Intent.ACTION_INSERT)
                .setData(CalendarContract.Events.CONTENT_URI)
                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, startMillis)
                .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endMillis)
                .putExtra(CalendarContract.Events.TITLE, "Aula: Recursos Nativos do Android")
                .putExtra(CalendarContract.Events.DESCRIPTION, "Desenvolvimento Mobile")
                .putExtra(CalendarContract.Events.EVENT_LOCATION, "Youtube")
                .putExtra(CalendarContract.Events.AVAILABILITY,
                    CalendarContract.Events.AVAILABILITY_BUSY)
                .putExtra(CalendarContract.Reminders.MINUTES, 5)
                .putExtra(CalendarContract.Reminders.METHOD,
                    CalendarContract.Reminders.METHOD_ALERT)
            startActivity(intent)
        }
    }
}