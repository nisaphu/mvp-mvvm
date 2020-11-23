package com.example.businesscard.fragmentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.businesscard.R
import kotlinx.android.synthetic.main.fragment_second.*


class SecondFragment : Fragment(), View.OnClickListener {

    private lateinit var mCallBack: CallBack

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            mCallBack = context as CallBack
        } catch (e: ClassCastException) {
            throw ClassCastException(context.toString() + "must implement Callback")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)
        initView(view)
        return view
    }

    private fun initView(view: View){
        val btnNextPage = view.findViewById<Button>(R.id.btnNextPage)
        btnNextPage.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val fragment: Fragment
        when (v!!.id) {
            R.id.btnNextPage -> {
                fragment = ThirdFragment()
                mCallBack.someEvent(fragment)
            }
        }
    }

}