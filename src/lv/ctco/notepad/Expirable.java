package lv.ctco.notepad;

/**
 * Created by yelena.pchelinceva on 12/7/2018.
 */
public interface Expirable {
    boolean isExpired();
    default  void dissmiss(){
        System.out.println("dissmiss");
    };
}
