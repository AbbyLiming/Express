package com.expressba.expressuser.user.search;

/**
 * Created by songchao on 16/5/1.
 */
public interface SearchExpressPresenter {
    void startGetExpressInfo(String expressID);
    void startGetExpressImage(String id,int whichImage);
}