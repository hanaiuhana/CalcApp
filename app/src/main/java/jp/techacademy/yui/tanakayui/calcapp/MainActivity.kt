package jp.techacademy.yui.tanakayui.calcapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.text.TextUtils
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    private var firstNum = 0.0
//    private var secondNum = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_plus.setOnClickListener {
            Log.d("testtest", "足すクリック！")

            try {

                //小数点を入力すると、結果画面の小数点がえぐいことに
                //小数点以下がない計算でも出るようになってしまった
                var firstEmpty = TextUtils.isEmpty(edit_first.text)
                var secondEmpty = TextUtils.isEmpty(edit_second.text)
                var firstNum: Double? = null
                var secondNum: Double? = null
                if (!firstEmpty) {
                    firstNum = edit_first.text.toString().toDouble()
                }
                if (!secondEmpty) {
                    secondNum = edit_second.text.toString().toDouble()
                }
//                if (firstEmpty || secondEmpty) {
//                    showMessage(it)
//                } else {
                var resultNum: Double? = firstNum + secondNum
                    goToResult(resultNum)
//                }
            } catch (e: NumberFormatException) {
                showMessage(it)
            }

        }
        button_minus.setOnClickListener {
            Log.d("testtest", "引くクリック！")

        }
        button_times.setOnClickListener {
            Log.d("testtest", "掛けるクリック！")

        }
        button_divide.setOnClickListener {
            Log.d("testtest", "割るクリック！")

        }
    }

    fun goToResult(resultNum: Double?) {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("RESULT_NUM", resultNum)
        startActivity(intent)
    }
    fun showMessage(v: View) {
        Snackbar.make(v, R.string.text_enter_num, Snackbar.LENGTH_LONG)
            .show()
    }

}
