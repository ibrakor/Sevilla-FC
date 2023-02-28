package com.ibrakor.sevillaFc.domain.usecase;

import com.ibrakor.sevillaFc.domain.RefereeRepository;
import com.ibrakor.sevillaFc.domain.models.Referee;

public class AddRefereeUseCase {

    private RefereeRepository refereeRepository;

    public AddRefereeUseCase(RefereeRepository refereeRepository){
        this.refereeRepository = refereeRepository;
    }

    public void execute(Referee referee){
        this.refereeRepository.save(referee);
    }
}
