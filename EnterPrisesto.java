package com.supermap.realestate.trading.enterprise.sto.model;

///*****************************************
//* AutoGenerate by CodeTools 2017/3/29 
//* ----------------------------------------
//* Public Entity T_EnterPrise 
//* ----------------------------------------
//* Copyright (C) SuperMap Software Co.,Ltd.  
//*****************************************/

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import com.supermap.realestate.registration.util.ConstHelper;
import com.supermap.realestate.trading.enterprise.sto.model.genrt.GenerateEnterPrise;

@Entity(name = "realestate.EnterPriseNews.sto.EnterPrise")
@Table(name = "T_EnterPrise", schema = "SMENTERPRISE_STO")
public class EnterPrisesto extends GenerateEnterPrise {

	@Override
	@Id
	@Column(name = "EnterPrise_ID", length = 50)
	public String getId() {
		return super.getId();
	}

	@Override
	@Column(name = "EnterPrise_PID")
	public String getEnterPrise_PID() {
		return super.getEnterPrise_PID();
	}

	@Override
	@Column(name = "EnterPrise_PCode")
	public String getEnterPrise_PCode() {
		return super.getEnterPrise_PCode();
	}

	@Override
	@Column(name = "EnterPrise_Type")
	public Integer getEnterPrise_Type() {
		return super.getEnterPrise_Type();
	}

	@Override
	@Column(name = "EnterPrise_Nature")
	public Integer getEnterPrise_Nature() {
		return super.getEnterPrise_Nature();
	}

	@Override
	@Column(name = "EnterPrise_Name")
	public String getEnterPrise_Name() {
		return super.getEnterPrise_Name();
	}

	@Override
	@Column(name = "EnterPrise_En")
	public String getEnterPrise_En() {
		return super.getEnterPrise_En();
	}

	@Override
	@Column(name = "EnterPrise_Short")
	public String getEnterPrise_Short() {
		return super.getEnterPrise_Short();
	}

	@Override
	@Column(name = "EnterPrise_Code")
	public String getEnterPrise_Code() {
		return super.getEnterPrise_Code();
	}

	@Override
	@Column(name = "Credit_Code")
	public String getCredit_Code() {
		return super.getCredit_Code();
	}

	@Override
	@Column(name = "Organize_Code")
	public String getOrganize_Code() {
		return super.getOrganize_Code();
	}

	@Override
	@Column(name = "Province_Code")
	public Integer getProvince_Code() {
		return super.getProvince_Code();
	}

	@Override
	@Column(name = "City_Code")
	public Integer getCity_Code() {
		return super.getCity_Code();
	}

	@Override
	@Column(name = "Division_Code")
	public Integer getDivision_Code() {
		return super.getDivision_Code();
	}
	
	private String division_Code_Name;
	@Transient
	public String getDivision_Code_Name() {
		if (division_Code_Name == null) {
			if (this.getDivision_Code() != null) {
				division_Code_Name = ConstHelper.getNameByValue("DIVISION_CODE", this.getDivision_Code().toString());
			}
		}
		return division_Code_Name;
	}

	@Override
	@Column(name = "Register_Address")
	public String getRegister_Address() {
		return super.getRegister_Address();
	}

	@Override
	@Column(name = "Link_Address")
	public String getLink_Address() {
		return super.getLink_Address();
	}

	@Override
	@Column(name = "Zip_Code")
	public String getZip_Code() {
		return super.getZip_Code();
	}

	@Override
	@Column(name = "Link_Name")
	public String getLink_Name() {
		return super.getLink_Name();
	}

	@Override
	@Column(name = "Link_Phone")
	public String getLink_Phone() {
		return super.getLink_Phone();
	}
	
	@Override
	@Column(name = "Work_Phone")
	public String getWork_Phone() {
		return super.getWork_Phone();
	}

	@Override
	@Column(name = "Link_Fax")
	public String getLink_Fax() {
		return super.getLink_Fax();
	}

	@Override
	@Column(name = "Link_Mail")
	public String getLink_Mail() {
		return super.getLink_Mail();
	}

	@Override
	@Column(name = "WebSite")
	public String getWebSite() {
		return super.getWebSite();
	}

	@Override
	@Column(name = "Subjection")
	public Integer getSubjection() {
		return super.getSubjection();
	}

	@Override
	@Column(name = "Business_Static")
	public Integer getBusiness_Static() {
		return super.getBusiness_Static();
	}

	@Override
	@Column(name = "License_Code")
	public String getLicense_Code() {
		return super.getLicense_Code();
	}

	@Override
	@Column(name = "License_StartDate")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	public Date getLicense_StartDate() {
		return super.getLicense_StartDate();
	}

	@Override
	@Column(name = "License_EndDate")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	public Date getLicense_EndDate() {
		return super.getLicense_EndDate();
	}

	@Override
	@Column(name = "NetAsset")
	public Double getNetAsset() {
		return super.getNetAsset();
	}

	@Override
	@Column(name = "TotalAsset")
	public Double getTotalAsset() {
		return super.getTotalAsset();
	}

	@Override
	@Column(name = "Register_Capital")
	public Double getRegister_Capital() {
		return super.getRegister_Capital();
	}

	@Override
	@Column(name = "RegisterCapital_Unit")
	public Integer getRegisterCapital_Unit() {
		return super.getRegisterCapital_Unit();
	}

	@Override
	@Column(name = "General_Manager")
	public String getGeneral_Manager() {
		return super.getGeneral_Manager();
	}

	@Override
	@Column(name = "Legal_Person")
	public String getLegal_Person() {
		return super.getLegal_Person();
	}

	@Override
	@Column(name = "LegalPerson_Phone")
	public String getLegalPerson_Phone() {
		return super.getLegalPerson_Phone();
	}

	@Override
	@Column(name = "LegalPerson_CertName")
	public String getLegalPerson_CertName() {
		return super.getLegalPerson_CertName();
	}

	@Override
	@Column(name = "LegalPerson_Code")
	public String getLegalPerson_Code() {
		return super.getLegalPerson_Code();
	}

	@Override
	@Column(name = "RegisterCityCode")
	public Integer getRegisterCityCode() {
		return super.getRegisterCityCode();
	}

	@Override
	@Column(name = "EnterPrise_CreateDate")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	public Date getEnterPrise_CreateDate() {
		return super.getEnterPrise_CreateDate();
	}

	@Override
	@Column(name = "Credit_Value")
	public Double getCredit_Value() {
		return super.getCredit_Value();
	}

	@Override
	@Column(name = "Aptitude_Grade")
	public Integer getAptitude_Grade() {
		return super.getAptitude_Grade();
	}

	@Override
	@Column(name = "Aptitude_Num")
	public String getAptitude_Num() {
		return super.getAptitude_Num();
	}

	@Override
	@Column(name = "Aptitude_StartDate")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	public Date getAptitude_StartDate() {
		return super.getAptitude_StartDate();
	}

	@Override
	@Column(name = "Aptitude_EndDate")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	public Date getAptitude_EndDate() {
		return super.getAptitude_EndDate();
	}

	@Override
	@Column(name = "Aptitude_Code")
	public String getAptitude_Code() {
		return super.getAptitude_Code();
	}

	@Override
	@Column(name = "Title_Num")
	public Integer getTitle_Num() {
		return super.getTitle_Num();
	}

	@Override
	@Column(name = "SeniorTitle_Num")
	public Integer getSeniorTitle_Num() {
		return super.getSeniorTitle_Num();
	}

	@Override
	@Column(name = "MiddleTitle_Num")
	public Integer getMiddleTitle_Num() {
		return super.getMiddleTitle_Num();
	}

	@Override
	@Column(name = "PrimaryTitle_Num")
	public Integer getPrimaryTitle_Num() {
		return super.getPrimaryTitle_Num();
	}

	@Override
	@Column(name = "Register_Num")
	public Integer getRegister_Num() {
		return super.getRegister_Num();
	}

	@Override
	@Column(name = "EnterPrise_State")
	public Integer getEnterPrise_State() {
		return super.getEnterPrise_State();
	}

	@Override
	@Column(name = "WorkRealty_Date")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	public Date getWorkRealty_Date() {
		return super.getWorkRealty_Date();
	}

	@Override
	@Column(name = "WorkRealty_Dept")
	public String getWorkRealty_Dept() {
		return super.getWorkRealty_Dept();
	}

	@Override
	@Column(name = "Valid_State")
	public Integer getValid_State() {
		return super.getValid_State();
	}

	@Override
	@Column(name = "Approve_Type")
	public Integer getApprove_Type() {
		return super.getApprove_Type();
	}

	@Override
	@Column(name = "Create_Date")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	public Date getCreate_Date() {
		return super.getCreate_Date();
	}

	@Override
	@Column(name = "Modify_Date")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	public Date getModify_Date() {
		return super.getModify_Date();
	}

	@Override
	@Column(name = "Business_Scope")
	public String getBusiness_Scope() {
		return super.getBusiness_Scope();
	}

	@Override
	@Column(name = "EnterPrise_Remark")
	public String getEnterPrise_Remark() {
		return super.getEnterPrise_Remark();
	}

	@Override
	@Column(name = "EnterPrise_VerCode")
	public String getEnterPrise_VerCode() {
		return super.getEnterPrise_VerCode();
	}

	@Override
	@Column(name = "EnterPrise_VerInfo")
	public String getEnterPrise_VerInfo() {
		return super.getEnterPrise_VerInfo();
	}
	
	@Override
	@Column(name = "Open_Bank")
	public String getOpen_Bank() {
		return super.getOpen_Bank();
	}
	
	@Override
	@Column(name = "Bank_Account")
	public String getBank_Account() {
		return super.getBank_Account();
	}
	
	@Override
	@Column(name = "EnterPrise_UpCode")
	public String getEnterPrise_UpCode() {
		return super.getEnterPrise_UpCode();
	}
	@Override
	@Column(name = "Yenterprise_ID")
	public String getYenterprise_ID() {
		return super.getYenterprise_ID();
	}

	@Override
	@Column(name = "Yenterprise_PID")
	public String getYenterprise_PID() {
		return super.getYenterprise_PID();
	}

	@Override
	@Column(name = "Yxtbm")
	public String getYxtbm() {
		return super.getYxtbm();
	}

	@Override
	@Column(name = "Yxtcq")
	public String getYxtcq() {
		return super.getYxtcq();
	}

	@Override
	@Column(name = "isfzjg")
	public String getisfzjg() {
		return super.getisfzjg();
	}
}
