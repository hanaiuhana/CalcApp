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

        var numtest = result.toInt()
        if (result.equals(numtest)) {
            String.format("%d",numtest);
        } else {
            String.format("%s",result);
        }

        text_result.text = result.toString()

        button_back_main.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
//public static String format(double d)
//{
//    if(d == (int) d)
//        return String.format("%d",(int)d);
//    else
//        return String.format("%s",d);
//}
