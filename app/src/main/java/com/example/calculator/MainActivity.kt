package com.example.calculator

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_0.setOnClickListener{ setExpressionAndResult("0") }
        btn_1.setOnClickListener{ setExpressionAndResult("1") }
        btn_2.setOnClickListener{ setExpressionAndResult("2") }
        btn_3.setOnClickListener{ setExpressionAndResult("3") }
        btn_4.setOnClickListener{ setExpressionAndResult("4") }
        btn_5.setOnClickListener{ setExpressionAndResult("5") }
        btn_6.setOnClickListener{ setExpressionAndResult("6") }
        btn_7.setOnClickListener{ setExpressionAndResult("7") }
        btn_8.setOnClickListener{ setExpressionAndResult("8") }
        btn_9.setOnClickListener{ setExpressionAndResult("9") }

        l_bracket_btn.setOnClickListener{ setExpressionAndResult("(") }
        r_bracket_btn.setOnClickListener{ setExpressionAndResult(")") }
        divide_btn.setOnClickListener{ setExpressionAndResult("/") }
        mult_btn.setOnClickListener{ setExpressionAndResult("*") }
        add_btn.setOnClickListener{ setExpressionAndResult("+") }
        subtract_btn.setOnClickListener{ setExpressionAndResult("-") }
        point_btn.setOnClickListener{ setExpressionAndResult(".") }

        AC_btn.setOnClickListener{
            math_expression.text = ""
        }

        del_btn.setOnClickListener{
            if (math_expression.text.length > 0){
                math_expression.text = math_expression.text.substring(0, math_expression.text.length - 1)
            }
        }

        equal_btn.setOnClickListener{
            try{
                val temp_exp: String = math_expression.text.toString()
                val eb = ExpressionBuilder(math_expression.text.toString()).build()
                val res = eb.evaluate()
                math_expression.text = res.toString()
                history.text = temp_exp

            } catch(e:Exception) {
                Log.d("Ошибка:","${e.message}")
            }
        }
    }

    fun setExpressionAndResult(str: String){
        math_expression.append(str)
    }

}