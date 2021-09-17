package com.energybox.backendcodingchallenge.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energybox.backendcodingchallenge.domain.Sensor;
import com.energybox.backendcodingchallenge.domain.repository.SensorCreateRepository;
import com.energybox.backendcodingchallenge.request.SensorRequest;

@Service
public class SensorService {

   @Autowired
 SensorCreateRepository sensorCreateRepository;
    
   //Create Sensor Record in DB
    public Sensor sensorCreate(SensorRequest request) {
    	Sensor sensorCreate =null;
        try {
        	sensorCreate = sensorCreateRepository.save(addToEntity(request));
        }catch(Exception e) {
          //Error Log

        }
    	return sensorCreate;
    }
    
    public Sensor addToEntity(SensorRequest request) {
    	Sensor sensorEntity = new Sensor();
    	sensorEntity.setGatewayId(request.getGatewayId());
    	sensorEntity.setSensorName(request.getSensorName());
    	sensorEntity.setSensorType(request.getSensorType());
        return sensorEntity;
    }
    
  //Fetch All Sensors
    public List<Sensor> queryAllSensors() {
    	List<Sensor> sensorList =null;
        try {
        	sensorList = (List<Sensor>) sensorCreateRepository.findAll();
        }catch(Exception e) {
          //Error Log

        }
    	return sensorList;
    }
    
    
    
    //FetechSensor by ID
      public Sensor querySensorById(Long sensorId) {
      	Optional<Sensor> sensorSelect =null;
          try {
        	  sensorSelect = sensorCreateRepository.findById(sensorId);
          }catch(Exception e) {
            //Error Log

          }
      	return sensorSelect.get();
      }
      
      
    //FetechSensor by Type
      public List<Sensor> querySensorByType(String sesnorType) {
      	List<Sensor> sensorTypeList =null;
          try {
        	  sensorTypeList = sensorCreateRepository.findBySesnorType(sesnorType);
          }catch(Exception e) {
            //Error Log

          }
      	return sensorTypeList;
      }
      
      
      //FetechSensor by Type
      public Sensor associateSensorToGateway(Sensor sensor) {
          try {
        	  sensor = sensorCreateRepository.save(sensor);
          }catch(Exception e) {
            //Error Log

          }
      	return sensor;
      }
      
      
     
      
      
     
}
