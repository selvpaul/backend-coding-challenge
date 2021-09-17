package com.energybox.backendcodingchallenge.domain.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.energybox.backendcodingchallenge.domain.Sensor;

@Repository
public interface SensorCreateRepository extends CrudRepository<Sensor, Long> {List<Sensor> findBySesnorType(String sensorType);}



