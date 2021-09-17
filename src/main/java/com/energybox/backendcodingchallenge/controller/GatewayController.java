package com.energybox.backendcodingchallenge.controller;

import com.energybox.backendcodingchallenge.domain.Gateway;
import com.energybox.backendcodingchallenge.domain.Sensor;
import com.energybox.backendcodingchallenge.service.GatewayService;
import com.energybox.backendcodingchallenge.service.SensorService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.energybox.backendcodingchallenge.request.GatewayRequest;
import com.energybox.backendcodingchallenge.request.SensorRequest;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;

@RestController
public class GatewayController {

	@Autowired
    private GatewayService gatewayService;
    
    @Autowired
    private  SensorService sensorService;


    @ApiOperation( value = "create a gateway", response = Gateway.class )
    @RequestMapping( value = "/v1/api/gateway", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Gateway> createGateway(
            @RequestBody GatewayRequest request
    ) throws IOException, InterruptedException, Exception {
    Gateway gateway = null;
    try {
			gateway = gatewayService.gatewayCreate(request);
		} catch(Exception e) {
		 	
		   throw new Exception("Exception occurred when create Gateway", e);
		    
		}
        return new ResponseEntity<Gateway>(gateway,  HttpStatus.OK );
    }
    
     @ApiOperation( value = "GET Gateway", response = Gateway.class )
    @RequestMapping( value = "/v1/api/gateway", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Gateway> fetchGateway(
            @RequestBody GatewayRequest request
    ) throws IOException, InterruptedException, Exception {
    Gateway gateway = null;
    try {
			gateway = gatewayService.queryGatewayById(request.getGatewayId());
		} catch(Exception e) {
		 	
		   throw new Exception("Exception occurred when Getting Gateway", e);
		    
		}
        return new ResponseEntity<Gateway>(gateway,  HttpStatus.OK );
    }
    
    
    @ApiOperation( value = "create a Sensor", response = Sensor.class )
    @RequestMapping( value = "/v1/api/sensor", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Sensor> createSensor(
            @RequestBody SensorRequest request
    ) throws IOException, InterruptedException, Exception {
    try{
		Sensor sensor = sensorService.sensorCreate(request);
        return new ResponseEntity<Sensor>( sensor,  HttpStatus.OK );
       } catch (Exception e) {
        	throw new Exception("Exception occurred when create Sensor", e);
       }
    }
    
    
    @ApiOperation( value = "Get All Sensor", response = Sensor.class )
    @RequestMapping( value = "/v1/api/sensor", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<List<Sensor>> fetchAllsensor(
            @RequestBody SensorRequest request
    ) throws IOException, InterruptedException, Exception {
    try{
		List<Sensor> sensorList = sensorService.queryAllSensors();
        return new ResponseEntity<List<Sensor>>( sensorList,  HttpStatus.OK );
       } catch (Exception e) {
        	throw new Exception("Exception occurred when List All Sensor", e);
       }
    }
    
    
    @ApiOperation( value = "Get All Sensor by Type", response = Sensor.class )
    @RequestMapping( value = "/v1/api/sensor/{type}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<List<Sensor>> fetchAllSensorByType(
            @PathVariable String type
    ) throws IOException, InterruptedException, Exception {
    try{
		List<Sensor> sensorList = sensorService.querySensorByType(type);
        return new ResponseEntity<List<Sensor>>( sensorList,  HttpStatus.OK );
       } catch (Exception e) {
        	throw new Exception("Exception occurred when List All Sensor", e);
       }
    }
    
    
    @ApiOperation( value = "Get All Sensor", response = Sensor.class )
    @RequestMapping( value = "/v1/api/{gatewayId}/sensor", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<List<Sensor>> fetchAllSensorForGteway(
            @PathVariable Long gatewayId
    ) throws IOException, InterruptedException, Exception {
    try{
		List<Sensor> sensorList = gatewayService.querySensorByGatewayId(gatewayId);
        return new ResponseEntity<List<Sensor>>( sensorList,  HttpStatus.OK );
       } catch (Exception e) {
        	throw new Exception("Exception occurred when List All Sensor", e);
       }
    }
    
    
     @ApiOperation( value = "Associate Sensor to Gateway", response = Sensor.class )
    @RequestMapping( value = "/v1/api/{gatewayId}/sensor/{sensorId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Sensor> associateSensorToGateway(
            @PathVariable Long gatewayId, @PathVariable Long sensorId 
    ) throws IOException, InterruptedException, Exception {
    try{
    	Sensor sensor = sensorService.querySensorById(sensorId);
    	sensor.setGatewayId(gatewayId);
		sensorService.associateSensorToGateway(sensor);
        return new ResponseEntity<Sensor>( sensor,  HttpStatus.OK );
       } catch (Exception e) {
        	throw new Exception("Associate Sensor to Gateway", e);
       }
    }
}
