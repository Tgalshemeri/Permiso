package com.elmaravilla.permiso

import android.content.pm.PackageManager
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class Permiso(private val activity: AppCompatActivity) {

    private var allPermissions :  Array<String> = arrayOf()

    fun permissions( permissions: Array<String>): Permiso {
        allPermissions = permissions
        return this
    }

    fun request(callback: (allGranted: Boolean, granted: List<String>, denied: List<String>) -> Unit) {
        val grantedPermissions = mutableListOf<String>()
        val deniedPermissions = mutableListOf<String>()

        allPermissions.forEach {
            if (hasPerms(it)){grantedPermissions.add(it)}
            else {deniedPermissions.add(it)}
        }

        if (deniedPermissions.isEmpty()){callback(true , grantedPermissions , deniedPermissions)}
        else {
            val permLauncher = activity.registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()){
                permission ->
                val grantedList = mutableListOf<String>()
                val deniedList = mutableListOf<String>()
                allPermissions.forEach {
                    if (permission[it] == true){grantedList.add(it)}
                    else{deniedList.add(it)}
                }
                callback(deniedList.isEmpty() , grantedList , deniedList)
            }
            permLauncher.launch(deniedPermissions.toTypedArray())
        }

        }




    private fun hasPerms(perm:String):Boolean {
        return ContextCompat.checkSelfPermission(activity , perm) == PackageManager.PERMISSION_GRANTED
    }
    }
