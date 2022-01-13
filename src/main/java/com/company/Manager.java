package com.company;

import java.util.LinkedList;
import java.util.List;

public class Manager {
    LinkedList<Info> infoList = new LinkedList<>();

    public Info createInfo(String text){
        Info info = new Info();
        info.setName(text);
        infoList.add(info);
        return info;
    }

    public Info getCurrent(){
        return infoList.getLast();
    }
}
