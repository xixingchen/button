package com.example.administrator.button;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView tv;

    Button buttonCle;
    Button buttonPlu;
    Button buttonMin;
    Button buttonMul;
    Button buttonDev;
    Button buttonEqu;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;

    StringBuilder equation = new StringBuilder();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initButton();
    }

    //初始化控件资源
    public void initButton(){
        tv = (TextView)this.findViewById(R.id.tv);
        buttonCle = (Button)findViewById(R.id.ButtonCle);
        buttonDev = (Button)findViewById(R.id.ButtonDev);
        buttonEqu = (Button)findViewById(R.id.ButtonEqu);
        buttonMin = (Button)findViewById(R.id.ButtonMin);
        buttonMul = (Button)findViewById(R.id.ButtonMul);
        buttonPlu = (Button)findViewById(R.id.ButtonPlu);

        button0 = (Button)findViewById(R.id.Button0);
        button1 = (Button)findViewById(R.id.Button1);
        button2 = (Button)findViewById(R.id.Button2);
        button3 = (Button)findViewById(R.id.Button3);
        button4 = (Button)findViewById(R.id.Button4);
        button5 = (Button)findViewById(R.id.Button5);
        button6 = (Button)findViewById(R.id.Button6);
        button7 = (Button)findViewById(R.id.Button7);
        button8 = (Button)findViewById(R.id.Button8);
        button9 = (Button)findViewById(R.id.Button9);

        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        buttonCle.setOnClickListener(this);
        buttonDev.setOnClickListener(this);
        buttonEqu.setOnClickListener(this);
        buttonMul.setOnClickListener(this);
        buttonMin.setOnClickListener(this);
        buttonPlu.setOnClickListener(this);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Button0:
                equation = equation.append("0");
                tv.setText(equation);
                break;
            case R.id.Button1:
                equation = equation.append("1");
                tv.setText(equation);
                break;
            case R.id.Button2:
                equation = equation.append("2");
                tv.setText(equation);
                break;
            case R.id.Button3:
                equation = equation.append("3");
                tv.setText(equation);
                break;
            case R.id.Button4:
                equation = equation.append("4");
                tv.setText(equation);
                break;
            case R.id.Button5:
                equation = equation.append("5");
                tv.setText(equation);
                break;
            case R.id.Button6:
                equation = equation.append("6");
                tv.setText(equation);
                break;
            case R.id.Button7:
                equation = equation.append("7");
                tv.setText(equation);
                break;
            case R.id.Button8:
                equation = equation.append("8");
                tv.setText(equation);
                break;
            case R.id.Button9:
                equation = equation.append("9");
                tv.setText(equation);
                break;
            case R.id.ButtonPlu:
                equation = equation.append("+");
                tv.setText(equation);
                break;
            case R.id.ButtonMin:
                equation = equation.append("-");
                tv.setText(equation);
                break;
            case R.id.ButtonMul:
                equation = equation.append("*");
                tv.setText(equation);
                break;
            case R.id.ButtonDev:
                equation = equation.append("/");
                tv.setText(equation);
                break;
            case R.id.ButtonCle:
                equation = equation.delete(0,equation.length());
                tv.setText(equation);
                break;
            case R.id.ButtonEqu:
                if(equation.length() > 1){
                    InfixInToDuffix inf = new InfixInToDuffix();
                    String result;
                    try {
                        String a = inf.toSuffix(equation);
                        result = inf.dealEquation(a);
                        //result = a;
                        //result = equation.toString();
                    }catch (Exception ex){
                        result = "出错";
                    }
                    tv.setText(equation + "=" + result);
                    equation = equation.delete(0,equation.length());
                    if (Character.isDigit(result.charAt(0))){
                        equation = equation.append(result);
                    }
                }
                break;
            default:
                break;
        }
    }
}
