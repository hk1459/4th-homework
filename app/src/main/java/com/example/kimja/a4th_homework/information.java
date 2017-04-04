package com.example.kimja.a4th_homework;

import java.io.Serializable;

/**
 * Created by kimja on 2017-04-04.
 */

public class information implements Serializable {
    private static final long serialVersionUID = 1L;

    String tablename;
    String entrytime;
    int spanum;
    int pizzanum;
    String card;
    int totalprice;
    public  void info(){
        entrytime = "";
        spanum = 0;
        pizzanum = 0;
        card = "";
        totalprice = 0;
    }

    public void info(String table,String time,int spa,int pizza,String card2,int price){
        tablename = table;
        entrytime = time;
        spanum = spa;
        pizzanum = pizza;
        card = card2;
        totalprice = price;
    }
    public String getTablename(){ return tablename;}
    public String getEntrytime(){ return entrytime;}
    public int getspanum(){ return spanum;}
    public int getpizzanum(){ return pizzanum;}
    public String getCard(){ return card;}
    public int getTotalprice(){ return totalprice;}

}
