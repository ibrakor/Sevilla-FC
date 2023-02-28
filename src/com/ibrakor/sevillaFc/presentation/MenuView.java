package com.ibrakor.sevillaFc.presentation;

public class MenuView {

    public void createNewReferee(){
        NewRefereeFrom newRefereeFrom = new NewRefereeFrom();
        newRefereeFrom.createNewReferee();
    }

    public void init(){
        createNewReferee();
    }
}
