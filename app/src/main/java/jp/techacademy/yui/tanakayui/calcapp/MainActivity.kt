package jp.techacademy.yui.tanakayui.calcapp

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigDecimal

class MainActivity : AppCompatActivity() ,View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_plus.setOnClickListener(this)
        button_minus.setOnClickListener(this)
        button_times.setOnClickListener(this)
        button_divide.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        Log.d("testtest", "計算ボタンクリック！")

        var firstEmpty = TextUtils.isEmpty(edit_first.text)
        var secondEmpty = TextUtils.isEmpty(edit_second.text)
        var firstNum = BigDecimal(0.0)
        var secondNum = BigDecimal(0.0)
        var resultNum = BigDecimal(0.0)

        if (firstEmpty || secondEmpty) {
            showMessage(v)
        } else {
            if (!firstEmpty) {
                resultNum = firstNum.plus(secondNum)
                firstNum = edit_first.text.toString().toBigDecimal()
            }
            if (!secondEmpty) {
                secondNum = edit_second.text.toString().toBigDecimal()
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
            formatChange(resultNum)
        }
    }

    private fun showMessage(v: View) {
        Snackbar.make(v, R.string.text_enter_num, Snackbar.LENGTH_LONG).show()
    }

    //計算結果が整数時、小数点以下を表示させない
    private fun formatChange(resultNum: BigDecimal) {
        //int型にする
        var resultDouble = resultNum.toDouble()
        var resultInt= resultDouble.toInt()
        var resultString = if (resultInt - resultDouble == 0.0) {
            //小数から整数を引く→差が0なら整数なので、フォーマットを整数にする
            String.format("%,.0f", resultNum)
        } else {
            resultNum.toString()
        }
        goToResult(resultString)
    }

    private fun goToResult(resultNum: String) {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("RESULT_NUM", resultNum)
        startActivity(intent)
    }
}
