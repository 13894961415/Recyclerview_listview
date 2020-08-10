package com.example.recyclerview_listview.listgrid;

public class ListGridModel {
    private int type;
    private String nametype;
    private int img;

    public ListGridModel(int type, String nametype, int img){
        this.type = type;
        this.nametype = nametype;
        this.img = img;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getNametype() {
        return nametype;
    }

    public void setNametype(String nametype) {
        this.nametype = nametype;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
