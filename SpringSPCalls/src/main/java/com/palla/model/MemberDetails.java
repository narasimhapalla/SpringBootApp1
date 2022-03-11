package com.palla.model;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;


import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString
@NamedStoredProcedureQuery(name = "get_member_details", procedureName = "PKG_MEMBER.P_FIND_MEMBER", resultClasses = {
		MemberDetails.class }, parameters = {
				@StoredProcedureParameter(name = "P_PRIMARY_LOCATION_ID", mode = ParameterMode.IN, type = Integer.class),
				@StoredProcedureParameter(name = "P_USER_TYPE", mode = ParameterMode.IN, type = Integer.class),
				@StoredProcedureParameter(name = "P_LAST_SYNC_DATE", mode = ParameterMode.IN, type = Timestamp.class),
				@StoredProcedureParameter(name = "p_SITE_ID", mode = ParameterMode.IN, type = Integer.class),
				@StoredProcedureParameter(name = "io_CURSOR", mode = ParameterMode.REF_CURSOR, type = Void.class)})
public class MemberDetails {
	@Id
	@Column(name = "MemberID")
	private Long memberID;
	@Column(name = "FirstName")
    private String firstName;
    @Column(name = "LastName")
    private String lastName;
	@Override
	public String toString() {
		return "MemberDetails [MemberID=" + memberID + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
    
}
