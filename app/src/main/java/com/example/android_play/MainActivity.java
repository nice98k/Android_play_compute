package com.example.android_play;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.os.PatternMatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private TextView MyTextView;
    private Button delete_one,delete_all;
    private Button add,subtract,multiply,devide;
    private Button one,two,three,four,five,six,seven,eight,nine,zero;
    private Button point,equal;
    private String s="";
    private int equal_num=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setListener();
    }
    private void setListener(){
        OnClick onClick=new OnClick();
        MyTextView=this.findViewById(R.id.tv1);
        MyTextView.setOnClickListener(onClick);
        delete_all=(Button)this.findViewById(R.id.Del_all);
        delete_all.setOnClickListener(onClick);
        delete_one=this.findViewById(R.id.Del_one);
        delete_one.setOnClickListener(onClick);

        add=this.findViewById(R.id.add);
        add.setOnClickListener(onClick);
        subtract=this.findViewById(R.id.subtract);
        subtract.setOnClickListener(onClick);
        multiply=this.findViewById(R.id.multiply);
        multiply.setOnClickListener(onClick);
        devide=this.findViewById(R.id.devide);
        devide.setOnClickListener(onClick);
        one=this.findViewById(R.id.one);
        one.setOnClickListener(onClick);
        two=this.findViewById(R.id.two);
        two.setOnClickListener(onClick);
        three=this.findViewById(R.id.three);
        three.setOnClickListener(onClick);
        four=this.findViewById(R.id.four);
        four.setOnClickListener(onClick);
        five=this.findViewById(R.id.five);
        five.setOnClickListener(onClick);
        six=this.findViewById(R.id.six);
        six.setOnClickListener(onClick);
        seven=this.findViewById(R.id.seven);
        seven.setOnClickListener(onClick);
        eight=this.findViewById(R.id.eight);
        eight.setOnClickListener(onClick);
        nine=this.findViewById(R.id.nine);
        nine.setOnClickListener(onClick);
        zero=this.findViewById(R.id.zero);
        zero.setOnClickListener(onClick);

        point=this.findViewById(R.id.point);
        point.setOnClickListener(onClick);
        equal=this.findViewById(R.id.equal);
        equal.setOnClickListener(onClick);


    }
    public class OnClick implements View.OnClickListener{

        public void display(String str){
            MyTextView.setText(str.trim());
        }
        public String compute(String str){
            StringBuilder stringBuilder=new StringBuilder(str);
            Pattern pattern = Pattern.compile("([\\d.]+)\\s*([*/])\\s*([\\d.]+)");
            Matcher matcher=pattern.matcher(stringBuilder.toString());
            while(matcher.find()){
                Double d1=Double.parseDouble(matcher.group(1));
                Double d2=Double.parseDouble(matcher.group(3));
                Double res=0.0;
                switch (matcher.group(2)){
                    case "*":
                        res=d1*d2;
                        break;
                    case "/":
                        res=d1/d2;
                        break;
                }
                stringBuilder.replace(matcher.start(), matcher.end(), String.valueOf(res));
                matcher.reset(stringBuilder.toString());
                Log.d("edittext",stringBuilder.toString());
            }

            pattern = Pattern.compile("([\\d.]+)\\s*([+-])\\s*([\\d.]+)");
            matcher=pattern.matcher(stringBuilder.toString());
            while(matcher.find()){
                Double d1=Double.parseDouble(matcher.group(1));
                Double d2=Double.parseDouble(matcher.group(3));
                Double res=0.0;
                switch (matcher.group(2)){
                    case "+":
                        res=d1+d2;
                        break;
                    case "-":
                        res=d1-d2;
                        break;
                }
                stringBuilder.replace(matcher.start(), matcher.end(), String.valueOf(res));
                matcher.reset(stringBuilder.toString());
                Log.d("edittext",stringBuilder.toString());
            }
            return stringBuilder.toString();
        }
        private void add_display(String str){
            if(equal_num==1){
                s="";
                equal_num=0;
                display(s);
            }
            s+=str;
            display(s);
        }



        @Override
        public void onClick(View v) {

            switch (v.getId()){
                case R.id.Del_all:
                    s="";
                    display(s);
                    break;
                case R.id.Del_one:
                    if(s.length()!=0)
                    s=s.substring(0,s.length()-1);
                    display(s);
                    break;
                case R.id.add:
                    add_display("+");
                    break;
                case R.id.subtract:
                    add_display("-");
                    break;
                case R.id.multiply:
                    add_display("*");
                    break;
                case R.id.devide:
                    add_display("/");
                    break;
                case R.id.one:
                    add_display("1");
                    break;
                case R.id.two:
                    add_display("2");
                    break;
                case R.id.three:
                    add_display("3");
                    break;
                case R.id.four:
                    add_display("4");
                    break;
                case R.id.five:
                    add_display("5");
                    break;
                case R.id.six:
                    add_display("6");
                    break;
                case R.id.seven:
                    add_display("7");
                    break;
                case R.id.eight:
                    add_display("8");
                    break;
                case R.id.nine:
                    add_display("9");
                    break;
                case R.id.zero:
                    add_display("0");
                    break;
                case R.id.point:
                    add_display(".");
                    break;
                case R.id.equal:
                    String temp=compute(s);
                    Toast.makeText(MainActivity.this,"结果为:"+temp,Toast.LENGTH_SHORT).show();
                    display(temp);
                    equal_num=1;
                    break;
            }
        }
    }



}
