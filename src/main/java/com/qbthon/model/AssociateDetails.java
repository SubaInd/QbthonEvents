package com.qbthon.model;

import java.util.Date;
import java.util.List;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperFieldModel.DynamoDBAttributeType;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTyped;

@DynamoDBTable(tableName="associate_details")
public class AssociateDetails {
	
	private String associateId;
	
	private String associateName;
	
	private String buName;
	
	private String accountName;
	
	private String grade;
	
	private List<String> skillList;
	
	private String role;
	
	private Date createdDate;

	
	public AssociateDetails() {
		super();
	}

	public AssociateDetails(String associateId, String associateName, String buName, String accountName, String grade,
			List<String> skillList, String role, Date createdDate) {
		super();
		this.associateId = associateId;
		this.associateName = associateName;
		this.buName = buName;
		this.accountName = accountName;
		this.grade = grade;
		this.skillList = skillList;
		this.role = role;
		this.createdDate = createdDate;
	}
	@DynamoDBHashKey(attributeName = "associate_id")
	public String getAssociateId() {
		return associateId;
	}

	public void setAssociateId(String associateId) {
		this.associateId = associateId;
	}

	@DynamoDBAttribute
	public String getAssociateName() {
		return associateName;
	}

	public void setAssociateName(String associateName) {
		this.associateName = associateName;
	}

	@DynamoDBAttribute
	public String getBuName() {
		return buName;
	}

	public void setBuName(String buName) {
		this.buName = buName;
	}

	@DynamoDBAttribute
	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	@DynamoDBAttribute
	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@DynamoDBAttribute
	@DynamoDBTyped(DynamoDBAttributeType.L)
	public List<String> getSkillList() {
		return skillList;
	}

	public void setSkillList(List<String> skillList) {
		this.skillList = skillList;
	}

	@DynamoDBAttribute
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@DynamoDBAttribute
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	
}
