package com.ibrakor.sevillaFc.presentation;

import com.ibrakor.sevillaFc.data.MatchDataRepository;
import com.ibrakor.sevillaFc.data.RefereeDataRepository;
import com.ibrakor.sevillaFc.data.local.MatchFileLocalDataSource;
import com.ibrakor.sevillaFc.data.local.RefereeFileLocalDataSource;
import com.ibrakor.sevillaFc.domain.models.Match;
import com.ibrakor.sevillaFc.domain.models.Referee;
import com.ibrakor.sevillaFc.domain.usecase.AddMatchUseCase;
import com.ibrakor.sevillaFc.domain.usecase.GetRefereeUseCase;

public class NewMatchForm {
    public void createNewMatch(){
        Match match = buildMatch();
        saveMatch(match);
    }

    private Match buildMatch(){
        Match match = new Match();
        match.setId(1);
        match.setDate("01/01/2023");
        match.setReferee(findReferee(20));
        match.setResult("5-0");

        return match;
    }

    private Referee findReferee(Integer refereId){
        GetRefereeUseCase getRefereeUseCase = new GetRefereeUseCase(new RefereeDataRepository(RefereeFileLocalDataSource.getInstance()));
        return getRefereeUseCase.execute(refereId);
    }
    private void saveMatch(Match match){
        AddMatchUseCase addMatchUseCase = new AddMatchUseCase(new MatchDataRepository(MatchFileLocalDataSource.getInstance()));
        addMatchUseCase.execute(match);
    }




}
