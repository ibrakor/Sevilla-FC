package com.ibrakor.sevillaFc.data;

import com.ibrakor.sevillaFc.data.local.MatchFileLocalDataSource;
import com.ibrakor.sevillaFc.domain.MatchRepository;
import com.ibrakor.sevillaFc.domain.models.Match;

import java.util.List;

public class MatchDataRepository implements MatchRepository {

    private MatchFileLocalDataSource localDataSource;

    public MatchDataRepository (MatchFileLocalDataSource matchFileLocalDataSource){
        this.localDataSource = matchFileLocalDataSource;
    }

    @Override
    public void save(Match match) {
        this.localDataSource.save(match);
    }

    @Override
    public Match getById(Integer matchId) {
        return this.localDataSource.findById(matchId);
    }


    @Override
    public List<Match> getAll() {
        return this.localDataSource.findAll();
    }
}
