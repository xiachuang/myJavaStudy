package cn.hdj.ssm.service;

import cn.hdj.ssm.domain.Traveller;

import java.util.List;

public interface ITravellerService {
    public List<Traveller> findTravellerByOrdersId();
}
