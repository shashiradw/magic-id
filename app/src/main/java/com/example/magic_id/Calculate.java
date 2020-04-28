package com.example.magic_id;
import android.util.Log;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;



public class Calculate {

    Model model=new Model();


    public Model calculateBday(String id) {


        String checkYear=id.substring(0,2);
       // Log.d("Year :",checkYear);

        if(checkYear.compareTo("20")==0 ||  checkYear.compareTo("19")==0  ){
            //New Id
            forNew(id);
        }
        else{
            //old Id
            forOldId(id);
        }

      return model;

    }

    public void forNew(String id){
        String dob=id.substring(0,7);
        int days=Integer.parseInt(dob.substring(4,7));
        int year=Integer.parseInt(dob.substring(0,4));
        model.setYear(""+year);
        if(days>500){
            //female
            model.setGender("female");
            calDay(days-500,year);

        }
        else{
            //male
            model.setGender("male");
            calDay(days,year);

        }

    }

    public void forOldId(String id){
        String dob=id.substring(0,5);
        int days=Integer.parseInt(dob.substring(2,5));
        int year=Integer.parseInt(dob.substring(0,2));
        model.setYear("19"+year);

        if(days>500){
            //female
            model.setGender("female");
            calDay(days-500,Integer.parseInt("19"+year));

        }
        else{
            //male
            model.setGender("male");
            calDay(days,Integer.parseInt("19"+year));

        }
    }


    public void calDay(int days,int year){

        Map<String,Integer> monthDays=new LinkedHashMap<String, Integer>(){{
            put("january",31);
            put("feb",29);
            put("march",31);
            put("April",30);
            put("May",31);
            put("June",30);
            put("July",31);
            put("August",31);
            put("September",30);
            put("October",31);
            put("November",30);
            put("December",31);
        }};
        int totdays=0;
//        if(year%400==0){
//            //leap year
//            Log.d("Hello", "calDay:1 ");
//            monthDays.replace("feb",28,29);
//        }


        for(Map.Entry<String,Integer> entry: monthDays.entrySet()){
            totdays+=entry.getValue();

            if(totdays>=days){
                model.setMonth(entry.getKey());
                model.setDay(""+(days-(totdays-entry.getValue())));
                return;
            }

        }


    }



}
