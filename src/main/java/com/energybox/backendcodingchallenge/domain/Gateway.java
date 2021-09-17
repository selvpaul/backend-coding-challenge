package com.energybox.backendcodingchallenge.domain;

import java.util.List;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Gateway {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private int gatewayId;
	
	private String gatewayName;
	
	@OneToMany
	private List<Sensor> sensor;

	public List<Sensor> getSensor() {
		return sensor;
	}

	public void setSensor(List<Sensor> sensor) {
		this.sensor = sensor;
	}

	public String getGatewayName() {
		return gatewayName;
	}

	public void setGatewayName(String gatewayName) {
		this.gatewayName = gatewayName;
	}

	public int getGatewayId() {
		return gatewayId;
	}

	public void setGatewayId(int gatewayId) {
		this.gatewayId = gatewayId;
	}
}
