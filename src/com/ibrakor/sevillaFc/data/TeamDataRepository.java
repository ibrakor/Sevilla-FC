package com.ibrakor.sevillaFc.data;

import com.ibrakor.sevillaFc.data.local.TeamFileLocalDataSource;
import com.ibrakor.sevillaFc.domain.TeamRepository;
import com.ibrakor.sevillaFc.domain.models.Team;

import java.util.List;

public class TeamDataRepository implements TeamRepository {

    private TeamFileLocalDataSource localDataSource;

    public TeamDataRepository(TeamFileLocalDataSource teamFileLocalDataSource){
        this.localDataSource = teamFileLocalDataSource;
    }

    @Override
    public void save(Team team) {
        this.localDataSource.save(team);
    }

    @Override
    public Team getById(Integer teamId) {
        return this.localDataSource.findById(teamId);
    }

    @Override
    public List<Team> getAll() {
        return this.localDataSource.findAll();
    }
}
