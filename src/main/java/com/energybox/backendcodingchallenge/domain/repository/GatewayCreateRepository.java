package com.energybox.backendcodingchallenge.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.energybox.backendcodingchallenge.domain.Gateway;

@Repository
public interface GatewayCreateRepository extends CrudRepository<Gateway, Long> {}

