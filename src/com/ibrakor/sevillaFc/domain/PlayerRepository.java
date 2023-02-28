package com.ibrakor.sevillaFc.domain;

import com.ibrakor.sevillaFc.domain.models.Player;

import java.util.List;

public interface PlayerRepository {

    public void save(Player player);
    public Player getById(Integer playerId);
    public List<Player> getAll();
}
