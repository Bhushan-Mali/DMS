package com.example.demo.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.model.AuditTrailLog;
import com.example.repository.auditTrailLogRepository;

@Component
public class AuditTrailUtil {

	private static final Logger logger = LoggerFactory.getLogger(AuditTrailUtil.class);
	
	@Autowired
	auditTrailLogRepository auditTrailLogRepository;
	
	public void updateAuditLog(String userId, String username, String comment, String action, String request, String response, String ipAddress) {
		
		AuditTrailLog auditTrailLog = new AuditTrailLog();
		
		auditTrailLog.setUserId(userId);
		auditTrailLog.setUserName(username);
		auditTrailLog.setComments(comment);
		auditTrailLog.setAction(action);
		auditTrailLog.setRequest(request);
		auditTrailLog.setResponse(response);
		auditTrailLog.setIpAddress(ipAddress);
		
		auditTrailLogRepository.save(auditTrailLog);
		
		logger.info("---AuditTrailLog updated---");
	}
}
