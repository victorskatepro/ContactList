package com.saico.contactlist.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.saico.contactlist.R
import com.saico.contactlist.databinding.ActivityMain2Binding


class MainActivity2 : AppCompatActivity() {

    private lateinit var mainActivity2: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }
}