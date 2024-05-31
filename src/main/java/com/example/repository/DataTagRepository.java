package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.DataTag;

@Repository
public interface DataTagRepository extends JpaRepository<DataTag, Integer>{

}
