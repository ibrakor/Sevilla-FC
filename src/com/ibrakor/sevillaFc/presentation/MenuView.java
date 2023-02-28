package com.ibrakor.sevillaFc.presentation;

public class MenuView {

    public void createNewRefereeForm(){
        NewRefereeForm newRefereeForm = new NewRefereeForm();
        newRefereeForm.createNewReferee();
    }
    public void createNewTeamForm(){
        NewTeamForm newTeamForm = new NewTeamForm();
        newTeamForm.createNewTeam();
    }

    public void init(){
        createNewRefereeForm();
        createNewTeamForm();
    }
}
