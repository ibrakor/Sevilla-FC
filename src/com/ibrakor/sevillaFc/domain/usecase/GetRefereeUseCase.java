package com.ibrakor.sevillaFc.domain.usecase;

import com.ibrakor.sevillaFc.domain.RefereeRepository;
import com.ibrakor.sevillaFc.domain.models.Referee;

public class GetRefereeUseCase {

    private RefereeRepository refereeRepository;

    public GetRefereeUseCase(RefereeRepository refereeRepository){
        this.refereeRepository = refereeRepository;
    }

    public Referee execute(Integer refereId){

        return refereeRepository.getById(refereId);
    }
}
