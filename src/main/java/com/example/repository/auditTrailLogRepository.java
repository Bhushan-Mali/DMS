package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.AuditTrailLog;

@Repository
public interface auditTrailLogRepository extends JpaRepository<AuditTrailLog, Integer>{

}
