package org.example.sprapi.repository;

import org.example.sprapi.domain.Tbboard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TbboardRepository extends JpaRepository<Tbboard,String>{
    //Tbfollow findByFromTbuserIdAndToTbuserId(String from TbuserId, String to TbuserId);
}

