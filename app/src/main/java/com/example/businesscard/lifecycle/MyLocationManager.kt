package com.example.businesscard.lifecycle

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.os.Looper
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.OnLifecycleEvent

class MyLocationManager(context: Context) :
    LiveData<Location>(), LocationListener{

    private var enabled = false
//    private var lifecycle: Lifecycle = lifecycle
//    private val listener: MyLocationListener = listener
    private var locationManager: LocationManager =
        context.getSystemService(Context.LOCATION_SERVICE) as LocationManager

    interface MyLocationListener {
        fun onLocationChange(location: Location?)
    }

    init {
//        lifecycle.addObserver(this)
    }

    /*fun locationEnabled() {
        if (!enabled) {
            enabled = true
            start()
        }
    }*/

   /* @SuppressLint("MissingPermission")
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun start() {
        if (enabled) {
            locationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER, 1000, 10f, this,
                Looper.getMainLooper()
            )
            locationManager.requestLocationUpdates(
                LocationManager.NETWORK_PROVIDER, 1000, 10f, this,
                Looper.getMainLooper()
            )
        }
    }*/

    @SuppressLint("MissingPermission")
    override fun onActive() {
        super.onActive()
        locationManager.requestLocationUpdates(
            LocationManager.GPS_PROVIDER, 1000, 10f, this,
            Looper.getMainLooper())
        locationManager.requestLocationUpdates(
            LocationManager.NETWORK_PROVIDER, 1000, 10f, this,
            Looper.getMainLooper())
    }

   /* @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun stop() {
        Log.d("TAG", "stop: on_stop")
        locationManager.removeUpdates(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun cleanup() {
        Log.d("TAG", "cleanup: on_destroy")
        lifecycle.removeObserver(this)
    }*/

    @SuppressLint("MissingPermission")
    override fun onInactive() {
        super.onInactive()
        locationManager.removeUpdates(this)
    }

    override fun onLocationChanged(location: Location?) {
//        listener.onLocationChange(location)
        value = location
    }

    override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {

    }

    override fun onProviderEnabled(provider: String?) {

    }

    override fun onProviderDisabled(provider: String?) {

    }
}