package com.ibrakor.sevillaFc.presentation;

import com.ibrakor.sevillaFc.data.TeamDataRepository;
import com.ibrakor.sevillaFc.data.local.TeamFileLocalDataSource;
import com.ibrakor.sevillaFc.domain.models.Team;
import com.ibrakor.sevillaFc.domain.usecase.AddTeamUseCase;

public class NewTeamForm {

    private void saveTeam(Team team){
        AddTeamUseCase addTeamUseCase = new AddTeamUseCase(new TeamDataRepository(TeamFileLocalDataSource.getInstance()));
        addTeamUseCase.execute(team);
    }

    private Team buildTeam(){
        Team team = new Team();
        team.setId(1);
        team.setCategory("Primera Division");
        team.setName("Sevilla");

        return team;
    }

    public void createNewTeam(){
        Team team = buildTeam();
        saveTeam(team);
    }
}
