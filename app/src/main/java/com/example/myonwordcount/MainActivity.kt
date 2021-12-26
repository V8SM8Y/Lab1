package com.example.myonwordcount

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView2)
        val editText = findViewById<EditText>(R.id.editText)

        editText.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(p0: Editable?) {
                var text : String = editText.text.toString()
                val dict = HashMap<String, Int>()
                for (word in text.split( ",")){
                    var value = 1

                    if(dict[word]!= null)
                        value +=dict[word]?:0
                    dict[word]= value
                }
                    textView.text = dict.toString()
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

//                text = text.replace("\n", " ")
//                val textArray : List<String> = text.split(" ")
//                textView.setText("Words: "+ textArray.size)


            }
        })
    }
}