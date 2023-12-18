package com.example.fragmentdetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(),Firstfragment.FirstListener,SecondFrag.SecondListener {
    private lateinit var firstFrag: Firstfragment
    private lateinit var secondFrag: SecondFrag

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        firstFrag = Firstfragment()
        secondFrag = SecondFrag()

        supportFragmentManager.beginTransaction()
            .replace(R.id.container_a,firstFrag)
            .replace(R.id.container_b,secondFrag)
            .commit()
    }

    override fun onInputASent(input: CharSequence?) {
        //As firstFrag will send data to SecondFrag
        //firstFrag will call public method of second fragment
        if (input != null) {
            secondFrag.updateSecondEditText(input)
        }
    }

    override fun onInputBSent(input: CharSequence?) {
        if (input != null) {
            firstFrag.updateFirstEditText(input)
        }
    }
}