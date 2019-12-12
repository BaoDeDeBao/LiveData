package com.example.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //Declare module-level variable
    private lateinit var counterViewModel: CounterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("MVVC", "onCreate")

        //Initialize the ViewModel
        counterViewModel = ViewModelProviders.of(this).get(CounterViewModel::class.java)

        //Add an observer
        counterViewModel.count.observe(
            this,
            Observer {
                if(it.equals(10)) goodLuck()

            }
        )
        textViewCounter.text = counterViewModel.count.value.toString()

        buttonPlus.setOnClickListener {
            counterViewModel.increment()
            textViewCounter.text = counterViewModel.count.value.toString()
        }

        buttonMinus.setOnClickListener {
            counterViewModel.decrement()
            textViewCounter.text = counterViewModel.count.value.toString()
        }
    }

    override fun onDestroy() {
        Log.d("MVVC", "onDestroy")
        super.onDestroy()
    }

    private fun goodLuck() {
        Toast.makeText(this,"You luck is the best!!!", Toast.LENGTH_SHORT).show()
    }
}
