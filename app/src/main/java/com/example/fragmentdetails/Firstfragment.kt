package com.example.fragmentdetails

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment


class Firstfragment : Fragment() {
     private lateinit var  editText :EditText
     private lateinit var button:AppCompatButton
     private var listener: FirstListener? = null

    interface FirstListener {
        fun onInputASent(input: CharSequence?)
    }

    fun updateFirstEditText(newtext: CharSequence){
        editText.text = newtext as Editable?
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.first_fragment,container,false)
        editText = v.findViewById(R.id.ed_frag_one)
        button = v.findViewById<AppCompatButton?>(R.id.frag_one_button)

        button.setOnClickListener {
            val input = editText.text
            listener?.onInputASent(input)
        }

        return v
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is  FirstListener){
            listener = context
        }else{
            throw RuntimeException(context.toString()+"must implement FirstListener")
        }
    }
}