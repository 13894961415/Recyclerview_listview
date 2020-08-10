package com.example.recyclerview_listview.list;

public class ListModel {


    private String nametype;
    private String time;
    private  int    img;



    public ListModel(String nametype,String time,int img){
        this.nametype = nametype;
        this.time = time;
        this.img = img;
    }

    public String getNametype() {
        return nametype;
    }

    public void setNametype(String nametype) {
        this.nametype = nametype;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
