package com.example.myapplication.Model;

import com.example.myapplication.R;
import java.util.ArrayList;

public class MainProvider {
    private ArrayList<Integer>  menu_img = new ArrayList<Integer>();
    private String proudect_name;
    private String shop_name;

    public MainProvider() {
    }

    public MainProvider(ArrayList<Integer> menu_img, String proudect_name, String shop_name) {
        this.menu_img = menu_img;
        this.proudect_name = proudect_name;
        this.shop_name = shop_name;
    }

    public ArrayList<Integer> getMenu_img() {
        return menu_img;
    }

    public void setMenu_img(ArrayList<Integer> menu_img) {
        this.menu_img = menu_img;
    }

    public String getProudect_name() {
        return proudect_name;
    }

    public void setProudect_name(String proudect_name) {
        this.proudect_name = proudect_name;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    @Override
    public String toString() {
        return "MainProvider{" +
                ", menu_img='" + menu_img + '\'' +
                ", proudect_name='" + proudect_name + '\'' +
                ", shop_name='" + shop_name + '\'' +
                '}';
    }
}