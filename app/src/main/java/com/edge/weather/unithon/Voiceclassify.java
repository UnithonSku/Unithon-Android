package com.edge.weather.unithon;

<<<<<<< HEAD
/**
 * Created by c2619 on 2018-01-28.
 */

=======
>>>>>>> c051777a6d11a48a3f0ec7dbe5a8e7c63047fc01
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
<<<<<<< HEAD
            voices[i] = voices[i].replaceAll(" ","");
            items.add(voices[i]);
=======
           voices[i] = voices[i].replaceAll(" ","");
           items.add(voices[i]);
>>>>>>> c051777a6d11a48a3f0ec7dbe5a8e7c63047fc01
        }

    }
    public String classify(){
        String result="";
<<<<<<< HEAD
        if(items.contains("해빗업")|items.contains("해비덥")|items.contains("해빛업")|items.contains("해비덮")|items.contains("해비덕")|items.contains("헤비덕"))
        {
=======
        if(items.contains("할일다했어")){
>>>>>>> c051777a6d11a48a3f0ec7dbe5a8e7c63047fc01
            result ="happy";
        }

        else {
            result ="unhappy";
        }
        return result;
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> c051777a6d11a48a3f0ec7dbe5a8e7c63047fc01
