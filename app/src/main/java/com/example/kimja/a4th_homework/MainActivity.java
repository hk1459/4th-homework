package com.example.kimja.a4th_homework;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView t1, t2, t3, t4, t5, t6;
    Button b1, b2, b3, b4, b5, b6, b7;

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
        b5 = (Button) findViewById(R.id.b5);
        b6 = (Button) findViewById(R.id.b6);
        b7 = (Button) findViewById(R.id.b7);

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
            //테이블 정보 표시
            t1.setText("사과 테이블");
            //객체로 생성된 데이타 불러오기

        }
        else if(v.getId() == R.id.b2){
            t1.setText("포도 테이블");
        }
        else if(v.getId() == R.id.b3){
            t1.setText("키위 테이블");
        }
        else if(v.getId() == R.id.b4){
            t1.setText("자몽 테이블");
        }
        else if(v.getId() == R.id.b5){ //새주문하기
            //대화상자
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);

            View view = View.inflate(getApplicationContext(),R.layout.layout,null);
            final EditText table = (EditText)view.findViewById(R.id.editText);
            table.setText(t1.getText());
            table.setFocusable(false);
            table.setClickable(false);
            final EditText time = (EditText)view.findViewById(R.id.editText2);
            time.setText(t2.getText());
            time.setFocusable(false);
            time.setClickable(false);

            final EditText spa = (EditText)view.findViewById(R.id.editText3);
            final EditText pizza = (EditText)view.findViewById(R.id.editText4);

            dlg.setTitle("새 주문")
                    .setView(view)
                    .setIcon(R.mipmap.ic_launcher)
                    .setPositiveButton("닫기",null)
                    .setNegativeButton("확인", new DialogInterface.OnClickListener() {  // 확인버튼에 이벤트걸기
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //객체에 저장하기 + 출력하기 + 스낵바로 출력하기


                        }
                    })
                    .show();

        }
        else if(v.getId() == R.id.b6){ //정보수정

        }
        else if(v.getId() == R.id.b7){ //초기화
            if(t1.getText()=="사과 테이블") b1.setText("사과 Table(비어있음)");
            if(t1.getText()=="포도 테이블") b1.setText("포도 Table(비어있음)");
            if(t1.getText()=="키위 테이블") b1.setText("키위 Table(비어있음)");
            if(t1.getText()=="자몽 테이블") b1.setText("자몽 Table(비어있음)");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            t6.setText("");
            // + 객체 초기화 함수 작성할 것!
        }
    }
}