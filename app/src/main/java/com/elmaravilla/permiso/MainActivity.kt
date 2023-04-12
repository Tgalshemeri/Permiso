package com.elmaravilla.permiso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val arrayOfPerms = arrayOf(android.Manifest.permission.CAMERA , android.Manifest.permission.READ_CONTACTS
        , android.Manifest.permission.ACCESS_FINE_LOCATION)

        Permiso(this).permissions(arrayOfPerms).request { allGranted, granted, denied ->
            if (allGranted){
                Toast.makeText(this , "All Permissions are granted." , Toast.LENGTH_LONG).show()
            }

        }
    }
}