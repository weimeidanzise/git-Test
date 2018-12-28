package com.itcast.service.impl;

import com.itcast.dao.CityDao;
import com.itcast.domain.City;
import com.itcast.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityDao cityDao;
    @Override
    public List<City> findAll() throws Exception {
       return cityDao.findAll();
    }
}
