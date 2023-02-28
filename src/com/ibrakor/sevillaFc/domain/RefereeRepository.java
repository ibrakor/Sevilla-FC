package com.ibrakor.sevillaFc.domain;

import com.ibrakor.sevillaFc.domain.models.Referee;

import java.util.List;

public interface RefereeRepository {

    public void save(Referee referee);
    public void delete(Referee referee);
    public Referee getById(Integer refereeId);
    public List<Referee> getAll();
}
