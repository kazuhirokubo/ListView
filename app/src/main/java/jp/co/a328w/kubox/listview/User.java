package jp.co.a328w.kubox.listview;

/**
 * Created by kubox on 2016/10/07.
 */

public class User {

    private String name;
    private int size;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setSize(int size){
        this.size = size;
    }

    public int getSize(){
        return this.size;
    }

    public User(String name, int size){
        this.setName(name);
        this.setSize(size);
    }
}
