package com.ibrakor.sevillaFc.domain;

import com.ibrakor.sevillaFc.domain.models.Match;

import java.util.List;

public interface MatchRepository {

    public void save(Match match);
    public Match getById(Integer matchId);
    public List<Match> getAll();
}
