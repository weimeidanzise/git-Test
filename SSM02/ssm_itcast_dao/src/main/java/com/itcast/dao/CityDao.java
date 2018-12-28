package com.itcast.dao;

import com.itcast.domain.City;

import java.util.List;

public interface CityDao {
    List<City> findAll()throws Exception;
}
