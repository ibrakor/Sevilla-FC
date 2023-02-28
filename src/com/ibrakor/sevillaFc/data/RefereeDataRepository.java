package com.ibrakor.sevillaFc.data;

import com.ibrakor.sevillaFc.data.local.RefereeFileLocalDataSource;
import com.ibrakor.sevillaFc.domain.RefereeRepository;
import com.ibrakor.sevillaFc.domain.models.Referee;

import java.util.List;

public class RefereeDataRepository implements RefereeRepository {

    private RefereeFileLocalDataSource localDataSource;

    public RefereeDataRepository(RefereeFileLocalDataSource refereeFileLocalDataSource){
        this.localDataSource = refereeFileLocalDataSource;
    }

    @Override
    public void save(Referee referee) {
        this.localDataSource.save(referee);
    }

    @Override
    public void delete(Referee referee) {

    }

    @Override
    public Referee getById(Integer refereeId) {
        return this.localDataSource.findById(refereeId);
    }

    @Override
    public List<Referee> getAll() {
        return this.localDataSource.findAll();
    }
}
