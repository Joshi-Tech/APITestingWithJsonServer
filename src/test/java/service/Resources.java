package service;

import java.io.IOException;
import java.util.ResourceBundle;

public class Resources {
    public static ResourceBundle bundle;

    public static ResourceBundle getResourceBundle(){
        try{
            bundle = ResourceBundle.getBundle("resource");
        }catch (Exception i){
            i.getMessage();
        }
        return bundle;
    }
}
