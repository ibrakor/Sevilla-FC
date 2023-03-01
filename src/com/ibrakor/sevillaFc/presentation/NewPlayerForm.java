package com.ibrakor.sevillaFc.presentation;

import com.ibrakor.sevillaFc.data.PlayerDataRepository;
import com.ibrakor.sevillaFc.data.local.PlayerFileLocalDataSource;
import com.ibrakor.sevillaFc.domain.models.Player;
import com.ibrakor.sevillaFc.domain.usecase.AddPlayerUseCase;

public class NewPlayerForm {

    public void createNewPlayer(){
        Player player = buildPlayer();
        savePlayer(player);
    }

    private Player buildPlayer(){
        Player player = new Player();

        player.setPosition("Portero");
        player.setId(1);
        player.setName("Bono");
        player.setSurname("Nose");
        player.setFechaNacimiento("01/01/1990");

        return player;
    }
    private void savePlayer(Player player){
        AddPlayerUseCase addPlayerUseCase = new AddPlayerUseCase(new PlayerDataRepository(PlayerFileLocalDataSource.getInstance()));
        addPlayerUseCase.execute(player);
    }




}
