package com.ibrakor.sevillaFc.domain.usecase;

import com.ibrakor.sevillaFc.domain.PlayerRepository;
import com.ibrakor.sevillaFc.domain.models.Player;

public class AddPlayerUseCase {

    private PlayerRepository playerRepository;

    public AddPlayerUseCase(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }

    public void execute(Player player){
        playerRepository.save(player);
    }
}
