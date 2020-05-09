package com.finance.ctrlm;

public class HashMapp<K,V>{
    private Entry<K,V>[] hash;
    private int capacity;
    private int size =0;
    private double num = 0.75;

    public HashMapp(){//capacity
        this(16);
    }
    public HashMapp(int capacity){
        this.capacity = capacity;
        this.hash = new Entry[this.capacity];
    }
    public void Put(K key, V value){
        if(size == (capacity*num)){//full
            Entry<K,V>[] temp = hash;
            capacity *= 2;
            size = 0;
            hash = new Entry[capacity];
            for(Entry<K,V> i: temp){//older data
                while(i != null){
                    Put(i.key, i.value);
                    i = i.next;
                }
            }
        }
        Entry<K,V> newEntry = new Entry<>(key,value,null);//new data
        int hashNum = getHash(key) % getHashSize();
        Entry<K,V> existing  = hash[hashNum];

        if(existing == null){ //not existing
            hash[hashNum] = newEntry;
            size ++;
        }
        else{ //if exists
            while(existing.next != null){
                if(existing.key.equals(key)){
                    existing.value = value;
                    return;
                }
                existing =existing.next;
            }
            if(existing.key.equals(key)){
                existing.value = value;
            }
            else{
                existing.next = newEntry;
                size ++;
            }
        }
    }
    public V Get(K key){//return value
        Entry<K,V> newHash = hash[getHash(key) % getHashSize()];
        while(newHash != null){
            if(key.equals(newHash.key)){
                return newHash.value;
            }
            newHash = newHash.next;
        }
        return null;
    }
    public int size(){
        return size;
    }
    private int getHashSize(){
        return hash.length;
    }
    private int getHash(K key){
        return key == null ? 0 : Math.abs(key.hashCode());
    }
    @Override //method to override actual toString
    public String toString(){
        String dictionary = "";//big string
        for(Entry i : hash){
            while(i != null){
                dictionary += i;
                if(i.next != null){
                    dictionary += (", ");
                }
                i = i.next;
            }
        }
        return "{" + dictionary + "}";
    }

    static class Entry<K,V>{//<K,V> type of the class
        final K key;
        V value;
        Entry<K,V> next;

        public Entry(K key, V value, Entry<K,V> next){
            this.key = key;
            this.value = value;
            this.next = next;//node of a linked list
        }
        public K getKey(){
            return key;
        }
        public V getValue(){
            return value;
        }
        public Entry<K,V> getNext(){
            return next;
        }

        @Override
        public boolean equals(Object obj){
            if(obj == this){
                return true;
            }
            if(obj instanceof Entry){
                Entry entry = (Entry) obj;
                return key.equals(entry.getValue());
            }
            return false;
        }

        @Override
        public int hashCode(){
            int hash = 13;
            hash = 17 * hash + ((key == null) ? 0 : key.hashCode());
            hash = 17 * hash + ((key == null) ? 0 : value.hashCode());
            return hash;
        }

        @Override
        public String toString(){
            return key + " : " + value + ", ";
        }
    }
}