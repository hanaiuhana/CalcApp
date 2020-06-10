package jp.techacademy.yui.tanakayui.calcapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() ,View.OnClickListener{



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_plus.setOnClickListener(this)
        button_minus.setOnClickListener(this)
        button_times.setOnClickListener(this)
        button_divide.setOnClickListener(this)
    }

    fun goToResult(resultNum: Double) {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("RESULT_NUM", resultNum)
        startActivity(intent)
    }
    fun showMessage(v: View) {
        Snackbar.make(v, R.string.text_enter_num, Snackbar.LENGTH_LONG)
            .show()
    }

    override fun onClick(v: View) {
        Log.d("testtest", "計算ボタンクリック！")
        var firstEmpty = TextUtils.isEmpty(edit_first.text)
        var secondEmpty = TextUtils.isEmpty(edit_second.text)
        var firstNum = 0.0
        var secondNum = 0.0
        var resultNum = 0.0
        if (firstEmpty || secondEmpty) {
            showMessage(v)
        } else {
            if (!firstEmpty) {
                firstNum = edit_first.text.toString().toDouble()
            }
            if (!secondEmpty) {
                secondNum = edit_second.text.toString().toDouble()
            }
            //計算
            when (v.id) {
                R.id.button_plus -> {
                    resultNum = firstNum + secondNum
                }
                R.id.button_minus -> {
                    resultNum = firstNum - secondNum
                }
                R.id.button_times -> {
                    resultNum = firstNum * secondNum
                }
                R.id.button_divide -> {
                    resultNum = firstNum / secondNum
                }
            }
            goToResult(resultNum)
        }
    }


}
