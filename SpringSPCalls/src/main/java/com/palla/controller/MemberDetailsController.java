package com.palla.controller;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.bind.DatatypeConverter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.palla.model.MemberDetails;
import com.palla.model.ResponseHandler;

@RestController
@Component
public class MemberDetailsController {
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@GetMapping("/emp-dtls")
	@ResponseBody
	//http://localhost:8080/emp-dtls?locationid=7963728&synctime=2020-09-01&siteid=2
	public ResponseEntity<Object> getEmp(@RequestParam(name = "locationid") String locid,
			@RequestParam(name = "synctime") String date,
			@RequestParam(name = "siteid") String siteid) {
		List<MemberDetails> employees = entityManager.createNamedStoredProcedureQuery("get_member_details")
				.setParameter("P_PRIMARY_LOCATION_ID", Integer.parseInt(locid))
				.setParameter("P_USER_TYPE", new Integer(2))
				.setParameter("P_LAST_SYNC_DATE", new java.sql.Timestamp(DatatypeConverter.parseDateTime(date).getTimeInMillis()))
				.setParameter("p_SITE_ID", new Integer(siteid))
				.getResultList();
		for (MemberDetails member : employees) {
			System.out.println(member.toString());
			
		}
		MemberDetails mem = new MemberDetails();
		
		//mem.setFirstName("Test");
		return new ResponseEntity<>(employees, HttpStatus.OK);
		//return ResponseEntity.ok(employees);
		//return ResponseHandler.generateResponse(HttpStatus.OK,false,"Write some message", employees);
	}
}
