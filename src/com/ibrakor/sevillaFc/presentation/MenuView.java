package com.ibrakor.sevillaFc.presentation;

public class MenuView {

    public void init(){
        //createNewRefereeForm();
        //createNewTeamForm();
        //createNewPlayerForm();
        createNewMatchForm();
    }

    public void createNewRefereeForm(){
        NewRefereeForm newRefereeForm = new NewRefereeForm();
        newRefereeForm.createNewReferee();
    }
    public void createNewTeamForm(){
        NewTeamForm newTeamForm = new NewTeamForm();
        newTeamForm.createNewTeam();
    }

    public void createNewPlayerForm(){
        NewPlayerForm newPlayerForm = new  NewPlayerForm();
        newPlayerForm.createNewPlayer();
    }

    private void createNewMatchForm(){
    NewMatchForm newMatchForm = new NewMatchForm();
    newMatchForm.createNewMatch();
    }
}
