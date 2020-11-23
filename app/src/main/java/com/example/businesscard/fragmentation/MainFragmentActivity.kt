package com.example.businesscard.fragmentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.businesscard.R

class MainFragmentActivity : AppCompatActivity(), CallBack {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_fragment)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.contentContainer, FirstFragment())
                .commit()
        }
    }

    override fun someEvent(fragment: Fragment) {
        replaceFragment(fragment)
    }

    private fun replaceFragment(fragment: Fragment){
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.contentContainer, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}