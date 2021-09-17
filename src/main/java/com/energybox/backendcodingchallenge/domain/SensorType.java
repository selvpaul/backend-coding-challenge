package com.energybox.backendcodingchallenge.domain;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SensorType {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private int sensorTypeId;
	
	  public int getSensorTypeId() {
		return sensorTypeId;
	}

	public void setSensorTypeId(int sensorTypeId) {
		this.sensorTypeId = sensorTypeId;
	}

	public String getSensorType() {
		return sensorType;
	}

	public void setSensorType(String sensorType) {
		this.sensorType = sensorType;
	}

	private String sensorType;
	
}
