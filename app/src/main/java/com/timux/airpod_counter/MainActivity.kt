package com.timux.airpod_counter

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"

    //val sharedPreference: SharedPreference = SharedPreference(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sharedPref = this.getPreferences(Context.MODE_PRIVATE) ?: return

        //tv_count.setText(sharedPreference.getValueInt(COUNT, 0).toString())

        val count = sharedPref.getInt(getString(R.string.saved_counter_key), 0)

        val tv_count : TextView = findViewById(R.id.tv_count)
        val ib_plus : ImageButton = findViewById(R.id.ib_plus)
        val ib_minus : ImageButton = findViewById(R.id.ib_minus)

        tv_count.setText(count.toString())

        ib_plus.setOnClickListener {
            tv_count.setText((tv_count.text.toString().toInt() + 1).toString())
            with(sharedPref.edit()) {
                putInt(getString(R.string.saved_counter_key), tv_count.text.toString().toInt())
                commit()
            }
        }
        ib_minus.setOnClickListener {
            tv_count.setText((tv_count.text.toString().toInt() - 1).toString())
            with(sharedPref.edit()) {
                putInt(getString(R.string.saved_counter_key), tv_count.text.toString().toInt())
                commit()
            }
        }
    }
}
