package com.example.businesscard.lifecycle

import android.annotation.SuppressLint
import android.location.Location
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.Observer
import com.example.businesscard.R
import com.google.android.material.snackbar.Snackbar
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import kotlinx.android.synthetic.main.activity_lifecycle.*

class LifecycleActivity : AppCompatActivity() {

    private val TAG = LifecycleActivity::class.java.name
//    private lateinit var locationManager: MyLocationManager
//    private val mRegistry = LifecycleRegistry(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle)
//        locationManager = MyLocationManager(this, lifecycle, getListenerMyLocation())
        checkPermissionLocation()
    }

  /*  override fun getLifecycle(): LifecycleRegistry{
        return this.mRegistry
    }*/

  /*  @NonNull
    private fun getListenerMyLocation(): MyLocationManager.MyLocationListener {
        return (object : MyLocationManager.MyLocationListener {

            @SuppressLint
            override fun onLocationChange(location: Location?) {
                Log.d(TAG, "onLocationChange: ${location.toString()}")
                val result = String.format("%f / %f", location?.latitude, location?.longitude)
                textView.text = result
            }
        })
    }*/

    private fun checkPermissionLocation() {
        Dexter.withContext(this)
            .withPermissions(
                android.Manifest.permission.ACCESS_FINE_LOCATION,
                android.Manifest.permission.ACCESS_COARSE_LOCATION
            )
            .withListener(object : MultiplePermissionsListener {
                override fun onPermissionsChecked(p0: MultiplePermissionsReport?) {
                    if (!hasDeniedPermission(p0)) {
                        val locationManager = MyLocationManager(this@LifecycleActivity)
                        locationManager.observe(this@LifecycleActivity, object : Observer<Location>{
                            override fun onChanged(t: Location?) {
                                if (t != null){
                                    @SuppressLint("DefaultLocale")
                                    val result = String.format("%f / %f", t.latitude, t.longitude)
                                    textView.text = result
                                }
                            }
                        })
                    } else {
                        Toast.makeText(this@LifecycleActivity, p0.toString(), Toast.LENGTH_LONG)
                            .show()
                    }
                }

                override fun onPermissionRationaleShouldBeShown(
                    p0: MutableList<PermissionRequest>?,
                    p1: PermissionToken?
                ) {
                    p1?.continuePermissionRequest()
                }

                private fun hasDeniedPermission(report: MultiplePermissionsReport?): Boolean {
                    val denyPermission =
                        report?.deniedPermissionResponses
                    return denyPermission != null && denyPermission.isNotEmpty()
                }
            }).check()
    }

}