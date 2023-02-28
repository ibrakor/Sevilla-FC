package com.ibrakor.sevillaFc.data;

import com.ibrakor.sevillaFc.data.local.PlayerFileLocalDataSource;
import com.ibrakor.sevillaFc.domain.PlayerRepository;
import com.ibrakor.sevillaFc.domain.models.Player;

import java.util.List;

public class PlayerDataRepository implements PlayerRepository {

    private PlayerFileLocalDataSource localDataSource;

    public PlayerDataRepository (PlayerFileLocalDataSource playerFileLocalDataSource){
        this.localDataSource = playerFileLocalDataSource;
    }

    @Override
    public void save(Player player) {
        this.localDataSource.save(player);
    }

    @Override
    public Player getById(Integer playerId) {
        return this.localDataSource.findById(playerId);
    }

    @Override
    public List<Player> getAll() {
        return this.localDataSource.findAll();
    }
}
