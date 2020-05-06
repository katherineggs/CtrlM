package com.finance.ctrlm;

import java.util.ArrayList;
import java.util.List;

public class HashMapp {
    class Container{
        Object key;
        Object value;
        public void ins(Object key, Object value){
            this.key = key;
            this.value = value;
        }
    }
    Container c;
    List<Container> recList;

    public HashMapp(){
        this.recList = new ArrayList<Container>();
    }
    public void put(Object key, Object value){
        this.c = new Container();
        c.ins(key,value);
        for(int i = 0; i < recList.size(); i++){
            Container c1 = recList.get(i);
            if(c1.key.equals(key)){
                recList.remove(i);
                break;
            }
        }
        recList.add(c);
    }
    public Object get(Object key){
        for(int i = 0; i < this.recList.size(); i++){
            Container con = recList.get(i);
            if(key.toString() == con.key.toString()){
                return con.value;
            }
        }
        return null;
    }
}
