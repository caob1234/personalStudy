package com.smart.containers;

import net.mindview.util.Print;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

import static net.mindview.util.Print.print;


//What will the weather be?
public class SpringDetector {
    //Uses a Groundhog or class derived from Grounding
    public static <T extends Groundhog>
    void detectSpring(Class<T> type)throws Exception{
        Constructor<T> ghog=type.getConstructor(int.class);
        Map<Groundhog,Prediction> map=new HashMap<Groundhog, Prediction>();
        for (int i = 0; i <10 ; i++) {
            map.put(ghog.newInstance(i),new Prediction());
        }
        Print.print("map="+map);
        Groundhog gh=ghog.newInstance(3);
        Print.print("Looking up prediction for "+gh);
        if (map.containsKey(gh)){
            Print.print(map.get(gh));
        }else {
            Print.print("Key not found:"+gh);
        }
    }
    public static void main(String[] args)throws Exception{
        detectSpring(Groundhog.class);
    }
}
