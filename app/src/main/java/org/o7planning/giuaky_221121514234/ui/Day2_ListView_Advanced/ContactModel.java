package org.o7planning.giuaky_221121514234.ui.Day2_ListView_Advanced;

import java.io.Serializable;

public class ContactModel implements Serializable {
    private String name;
    private String phone;
    private int image;
    public ContactModel(String name, String phone, int image){
        this.name = name;
        this.phone = phone;
        this.image = image;
    }
    public String getName(){
        return name;
    }
    public String getPhone(){
        return phone;
    }
    public int getImage(){
        return image;
    }
}
