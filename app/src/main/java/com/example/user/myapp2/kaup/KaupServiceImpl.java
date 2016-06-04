package com.example.user.myapp2.kaup;

/**
 * Created by USER on 2016-06-04.
 */
public class KaupServiceImpl implements KaupService{
    //1.속성 Model : Domain
    //int   seq = 0;
    //String cst_mngt_no = "";
    //>>Bean으로 이동

    //2.기능 Method

    //3.bean생성
    //4.ServiceImpl생성
    //5.Servoce Abstract

    @Override
    public String getKaup(double weight, double height) {
        int    figure  = (int)((weight / (height * height))*10000);
        String  result = "";

        if(figure >= 24){
            result = "과체중";
        }else if(figure<24 && figure >= 20){
            result = "정상";
        }else if(figure<20 && figure >= 15){
            result = "저체중";
        }else if(figure<15 && figure >= 13){
            result = "마름";
        }else if(figure<13 && figure >= 10){
            result = "영양실조";
        }else {
            result = "소모증";
        }
        return result;
    }

}
