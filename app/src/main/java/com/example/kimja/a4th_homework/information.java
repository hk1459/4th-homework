package com.example.kimja.a4th_homework;

import java.io.Serializable;

/**
 * Created by kimja on 2017-04-04.
 */

public class information implements Serializable {
    private static final long serialVersionUID = 1L;

    String tablename = "" ;
    String entrytime = "";
    String spanum = "";
    String  pizzanum = "";
    String card = "";
    int totalprice = 0;
    public  void info(){
        this.entrytime = "";
        this.spanum = "";
        this.pizzanum = "";
        this.card = "";
        this.totalprice = 0;
    }

    public void info(String table,String time,String spa,String pizza,String card2,int price){
        this.tablename = table;
        this.entrytime = time;
        this.spanum = spa;
        this.pizzanum = pizza;
        this.card = card2;
        this.totalprice = price;
    }
    public String getTablename(){ return tablename;}
    public String getEntrytime(){ return entrytime;}
    public String getspanum(){ return spanum;}
    public String getpizzanum(){ return pizzanum;}
    public String getCard(){ return card;}
    public int getTotalprice(){ return totalprice;}

}
