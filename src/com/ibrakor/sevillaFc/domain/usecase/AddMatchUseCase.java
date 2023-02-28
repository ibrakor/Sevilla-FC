package com.ibrakor.sevillaFc.domain.usecase;

import com.ibrakor.sevillaFc.domain.MatchRepository;
import com.ibrakor.sevillaFc.domain.models.Match;

public class AddMatchUseCase {

    private MatchRepository matchRepository;

    public AddMatchUseCase (MatchRepository matchRepository){
        this.matchRepository = matchRepository;
    }

    public void execute(Match match){
        this.matchRepository.save(match);
    }
}
