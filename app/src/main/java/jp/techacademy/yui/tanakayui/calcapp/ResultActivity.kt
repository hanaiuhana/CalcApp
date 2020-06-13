package jp.techacademy.yui.tanakayui.calcapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        var result: String = intent.getStringExtra("RESULT_NUM")
        text_result.text = result
        button_back_main.setOnClickListener {
            finish()
        }
    }
}

