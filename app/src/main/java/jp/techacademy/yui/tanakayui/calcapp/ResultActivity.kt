package jp.techacademy.yui.tanakayui.calcapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        //整数の時だけ、小数点以下切り捨て

        var result = intent.getDoubleExtra("RESULT_NUM", 0.0)
//        var test = String.format("%,.2f",result);
//        text_result.text = result.toString()

        //int型にする
        var seisuu = result.toInt()
        //小数から整数を引く
        if (seisuu - result == 0.0) {
            //差が０なら整数なので、整数表示させる
            var test = String.format("%,.0f", result);
            text_result.text = test
        } else {
            text_result.text = result.toString()
        }

        button_back_main.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            //質問中
            finish()
        }

    }
    //質問中
    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)

    }
}
