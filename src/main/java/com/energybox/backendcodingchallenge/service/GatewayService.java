package com.energybox.backendcodingchallenge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.energybox.backendcodingchallenge.domain.Gateway;
import com.energybox.backendcodingchallenge.domain.Sensor;
import com.energybox.backendcodingchallenge.domain.repository.GatewayCreateRepository;
import com.energybox.backendcodingchallenge.request.GatewayRequest;

@Service
public class GatewayService {

   @Autowired
 GatewayCreateRepository gatewayCreateRepository;
    
   //Create Gateway Record in DB
    public Gateway gatewayCreate(GatewayRequest request) {
    	Gateway gatewayCreate =null;
        try {
        	gatewayCreate = gatewayCreateRepository.save(addToEntity(request));
        }catch(Exception e) {
          //Error Log

        }
    	return gatewayCreate;
    }
    
    public Gateway addToEntity(GatewayRequest request) {
    	Gateway gatewayEntity = new Gateway();
    	gatewayEntity.setGatewayName(request.getGatewayName());
        return gatewayEntity;
    }
    
    
  //Fetech Gateway Object by ID
    public Gateway queryGatewayById(Long gatewayId) {
    	Optional<Gateway> gatewaySelect =null;
        try {
        	gatewaySelect = gatewayCreateRepository.findById(gatewayId);
        }catch(Exception e) {
          //Error Log

        }
    	return gatewaySelect.get();
    }
    
  //Fetch All Gateway
    public List<Gateway> queryAllGateway() {
    	List<Gateway> gatewaySelect =null;
        try {
        	gatewaySelect = (List<Gateway>) gatewayCreateRepository.findAll();
        }catch(Exception e) {
          //Error Log

        }
    	return gatewaySelect;
    }
    
    
    //FetechAllSensor for Gateway
    public List<Sensor> querySensorByGatewayId(Long gatewayId) {
    	Optional<Gateway> gateway =null;
        try {
        	gateway = gatewayCreateRepository.findById(gatewayId);
        }catch(Exception e) {
          //Error Log

        }
    	return gateway.get().getSensor();
    }
    
   

}
