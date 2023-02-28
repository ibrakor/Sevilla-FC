package com.ibrakor.sevillaFc.domain;

import com.ibrakor.sevillaFc.domain.models.Team;

import java.util.List;

public interface TeamRepository {

    public void save(Team team);
    public Team getById(Integer teamId);
    public List<Team> getAll();
}
