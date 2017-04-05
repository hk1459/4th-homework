package com.example.kimja.a4th_homework;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView t1, t2, t3, t4, t5, t6;
    Button b1, b2, b3, b4, b5, b6, b7;
    RadioButton radioButton1, radioButton2;
    information apple = new information();
    information grape = new information();
    information kiwi = new information();
    information grapefruit = new information();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    void init() {
        t1 = (TextView) findViewById(R.id.t1);
        t2 = (TextView) findViewById(R.id.t2);
        t3 = (TextView) findViewById(R.id.t3);
        t4 = (TextView) findViewById(R.id.t4);
        t5 = (TextView) findViewById(R.id.t5);
        t6 = (TextView) findViewById(R.id.t6);
        b1 = (Button) findViewById(R.id.b1); //사과
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);
        b4 = (Button) findViewById(R.id.b4);
        b5 = (Button) findViewById(R.id.b5); //새주문
        b6 = (Button) findViewById(R.id.b6); //
        b7 = (Button) findViewById(R.id.b7); //초기화



        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);

    }


    public void onClick(View v){
        if(v.getId()== R.id.b1){ //사과table
            if(b1.getText().toString() == "사과 Table(비어있음)") {
                Toast.makeText(getApplicationContext(),"비어있는 테이블입니다.",Toast.LENGTH_SHORT).show();
            }
            //테이블 정보 표시
            t1.setText("사과 테이블");
            //객체로 생성된 데이타 불러오기
            load(apple);
        }
        else if(v.getId() == R.id.b2){
            if(b1.getText().toString() == "포도 Table(비어있음)") {
                Toast.makeText(getApplicationContext(),"비어있는 테이블입니다.",Toast.LENGTH_SHORT).show();
            }
            t1.setText("포도 테이블");

            load(grape);
        }
        else if(v.getId() == R.id.b3){
            if(b1.getText().toString() == "키위 Table(비어있음)") {
                Toast.makeText(getApplicationContext(),"비어있는 테이블입니다.",Toast.LENGTH_SHORT).show();
            }
            t1.setText("키위 테이블");

            load(kiwi);
        }
        else if(v.getId() == R.id.b4){
            if(b1.getText().toString() == "자몽 Table(비어있음)") {
                Toast.makeText(getApplicationContext(),"비어있는 테이블입니다.",Toast.LENGTH_SHORT).show();
            }
            t1.setText("자몽 테이블");

            load(grapefruit);
        }
        else if(v.getId() == R.id.b5){ //새주문하기
            //이미 주문이 있는데 새주문을 또 누른 경우 또는 테이블을 선택하지 않고 새주문을 누른 경우
            if (t1.getText().toString().getBytes().length <= 0 ){
                Toast.makeText(getApplicationContext(),"테이블을 선택하세요.",Toast.LENGTH_SHORT).show();
                return;
            }
            if (t3.getText().toString() != "" ){
                Toast.makeText(getApplicationContext(),"이미 예약되었습니다.",Toast.LENGTH_SHORT).show();
                return;
            }
            popup("새 주문",v);


        }
        else if(v.getId() == R.id.b6){ //정보수정
            //비어있는데 정보수정을 누른 경우
            if(t2.getText().toString().getBytes().length <= 0 ){
                Toast.makeText(getApplicationContext(),"수정할 정보가 없습니다.",Toast.LENGTH_SHORT).show();
                return;
            }

            //
            popup("정보수정",v);


       }
        else if(v.getId() == R.id.b7){ //초기화
            if(t1.getText()=="사과 테이블"){
                b1.setText("사과 Table(비어있음)");
                apple.info();
            }
            if(t1.getText()=="포도 테이블") {
                b1.setText("포도 Table(비어있음)");
                grape.info();
            }
            if(t1.getText()=="키위 테이블") {
                b1.setText("키위 Table(비어있음)");
                kiwi.info();
            }
            if(t1.getText()=="자몽 테이블") {
                b1.setText("자몽 Table(비어있음)");
                grapefruit.info();
            }
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            t6.setText("0원");

        }
    }
    public void load(information a){
        t2.setText(a.getEntrytime());
        t3.setText(a.getspanum());
        t4.setText(a.getpizzanum());
        t5.setText(a.getCard());
        t6.setText(Integer.toString(a.getTotalprice())+"원");
    }

    public void popup(String title, final View v){
        //대화상자
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);

        final View view = View.inflate(getApplicationContext(),R.layout.layout,null);
        final EditText table = (EditText)view.findViewById(R.id.editText1);
        table.setText(t1.getText());
        table.setFocusable(false);
        table.setClickable(false);
        final EditText time = (EditText)view.findViewById(R.id.editText2);
        if(t1.getText().toString()=="사과 테이블") time.setText("20170412 13:00");
        else if(t1.getText().toString()=="포도 테이블") time.setText("20170412 15:00");
        else if(t1.getText().toString()=="키위 테이블") time.setText("20170412 17:00");
        else if(t1.getText().toString()=="자몽 테이블") time.setText("20170412 19:00");

        time.setFocusable(false);
        time.setClickable(false);
        final EditText spa = (EditText)view.findViewById(R.id.editText3);
        final EditText pizza = (EditText)view.findViewById(R.id.editText4);
        radioButton1 = (RadioButton)view.findViewById(R.id.radioButton1);
        radioButton2 = (RadioButton)view.findViewById(R.id.radioButton2);

        //대화상자를 함수화해서 새주문과 정보수정으로 쓰기 위함
        spa.setText(t3.getText());
        pizza.setText(t4.getText());
        if(t5.getText().toString() == "기본멤버쉽"){
            radioButton1.setChecked(true);
        }
        if(t5.getText().toString() == "VIP멤버쉽"){
            radioButton2.setChecked(true);
        }
        dlg.setTitle(title)
                .setView(view)
                .setPositiveButton("닫기",null)
                .setNegativeButton("확인", new DialogInterface.OnClickListener() {  // 확인버튼에 이벤트걸기
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //스파게티 피자 미입력 예외처리
                        if(spa.getText().toString().getBytes().length <= 0){
                            spa.setText("0");
                        }
                        if(pizza.getText().toString().getBytes().length <= 0){
                            pizza.setText("0");
                        }

                        int totalprice = Integer.parseInt(spa.getText().toString())*10000 + Integer.parseInt(pizza.getText().toString())*12000;
                        String card;

                        if(radioButton1.isChecked()){
                            card = "기본멤버쉽";
                            totalprice = totalprice * 9 / 10;
                        } else {
                            card = "VIP멤버쉽";
                            totalprice = totalprice * 7 / 10;
                        }

                        //각각 테이블당 객체화해서 저장 후 출력
                        if(t1.getText().toString() == "사과 테이블"){
                            apple.info(table.getText().toString(),time.getText().toString(),spa.getText().toString(),pizza.getText().toString(),card,totalprice);
                            load(apple);
                        }
                        else if (t1.getText().toString() == "포도 테이블"){
                            grape.info(table.getText().toString(),time.getText().toString(),spa.getText().toString(),pizza.getText().toString(),card,totalprice);
                            load(grape);
                        }
                        else if (t1.getText().toString() == "키위 테이블"){
                            kiwi.info(table.getText().toString(),time.getText().toString(),spa.getText().toString(),pizza.getText().toString(),card,totalprice);
                            load(kiwi);
                        }
                        else if (t1.getText().toString() == "자몽 테이블"){
                            grapefruit.info(table.getText().toString(),time.getText().toString(),spa.getText().toString(),pizza.getText().toString(),card,totalprice);
                            load(grapefruit);
                        }
                        //스낵바로 띄우기
                        Snackbar.make(v, "정보가 입력되었습니다.", 1000).setAction("확인", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        }).show();
                    }
                })
                .show();
    }



}