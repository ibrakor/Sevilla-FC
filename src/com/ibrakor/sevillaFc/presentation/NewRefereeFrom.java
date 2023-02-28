package com.ibrakor.sevillaFc.presentation;

import com.ibrakor.sevillaFc.data.RefereeDataRepository;
import com.ibrakor.sevillaFc.data.local.RefereeFileLocalDataSource;
import com.ibrakor.sevillaFc.domain.models.Referee;
import com.ibrakor.sevillaFc.domain.usecase.AddRefereeUseCase;

public class NewRefereeFrom {

    private void saveReferee(Referee referee){
        AddRefereeUseCase addRefereeUseCase = new AddRefereeUseCase(new RefereeDataRepository(RefereeFileLocalDataSource.getInstance()));
        addRefereeUseCase.execute(referee);
    }

    private Referee buildReferee(){
        Referee referee = new Referee();
        referee.setId(20);
        referee.setCategory("Primera Divison");
        referee.setName("Cristobal");
        referee.setSurname("Soria");
        referee.setFechaNacimiento("20/01/1970");

        return referee;
    }

    public void createNewReferee(){
        Referee referee = buildReferee();
        saveReferee(referee);
    }
}
