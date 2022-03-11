package com.palla;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

@Repository
public class GetMemberData {

	@Autowired
    EntityManager entityManager;
   
    public MemberDetailsResponse addEmployeeThroughProcedure(String locid, String date, String siteid) {
   
        StoredProcedureQuery proc = entityManager.createStoredProcedureQuery(
                "EMPLOYEEPROCEDURE");
        proc.registerStoredProcedureParameter("P_PRIMARY_LOCATION_ID", String.class, ParameterMode.IN);
        proc.registerStoredProcedureParameter("P_USER_TYPE", String.class, ParameterMode.IN);
        proc.registerStoredProcedureParameter("P_LAST_SYNC_DATE", String.class, ParameterMode.IN);
        proc.registerStoredProcedureParameter("p_SITE_ID", Integer.class, ParameterMode.IN);
        proc.registerStoredProcedureParameter("io_CURSOR", Void.class, ParameterMode.OUT);
   
        proc.setParameter("P_PRIMARY_LOCATION_ID", locid);
        proc.setParameter("P_USER_TYPE", 2);
        proc.setParameter("P_LAST_SYNC_DATE", date);
        proc.setParameter("p_SITE_ID", siteid);
        proc.execute();
   
        return  MemberDetailsResponse.set
    }
}
