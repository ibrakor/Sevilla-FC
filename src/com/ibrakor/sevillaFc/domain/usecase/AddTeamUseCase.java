package com.ibrakor.sevillaFc.domain.usecase;

import com.ibrakor.sevillaFc.domain.TeamRepository;
import com.ibrakor.sevillaFc.domain.models.Team;

public class AddTeamUseCase {

    private TeamRepository teamRepository;

    public AddTeamUseCase(TeamRepository teamRepository){
        this.teamRepository = teamRepository;
    }

    public void execute(Team team){
        this.teamRepository.save(team);
    }
}
