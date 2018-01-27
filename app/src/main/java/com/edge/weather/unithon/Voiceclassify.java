package com.edge.weather.unithon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sj on 2018-01-27.
 */

public class Voiceclassify {
    List<String> items = new ArrayList<>();
    public Voiceclassify(String voice){
        //voice = voice.replaceAll(" ","");
        String [] voices=voice.split("/");

        for(int i =0;i<voices.length;i++){
           voices[i] = voices[i].replaceAll(" ","");
           items.add(voices[i]);
        }

    }
    public String classify(){
        String result="";
        if(items.contains("할일다했어")){
            result ="happy";
        }

        else {
            result ="unhappy";
        }
        return result;
    }
}
