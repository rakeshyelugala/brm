package com.org.brm.data;

import com.google.gson.annotations.SerializedName;

public class MSO_OP_CUST_GET_CUSTOMER_INFO_outputFlist {
	
	@SerializedName("MSO_FLD_ORG_STRUCTURE")
	private MSO_FLD_ORG_STRUCTURE mso_fld_org_structure;
	
	@SerializedName("SERVICE_INFO")
	private SERVICE_INFO service_info;
	
	@SerializedName("MSO_FLD_CONTACT_PREF")
	private Integer mso_fld_contact_pref;
	
	@SerializedName("MSO_FLD_CREDIT_PROFILE")
	private MSO_FLD_CREDIT_PROFILE[] mso_fld_credit_profile;
	
	@SerializedName("GROUP_INFO")
	private GROUP_INFO group_info;
	
	@SerializedName("ACCOUNT_NO")
	private String account_no;
	
	@SerializedName("LOGIN")
	private String login;
	
	@SerializedName("MSO_FLD_DATA_ACCESS")
	private String mso_fld_data_access;
	
	@SerializedName("CREATED_T")
	private String created_t;
	
	@SerializedName("POID")
	private String poid;
	
	@SerializedName("PROFILE_OBJ")
	private String profile_obj;
	
	@SerializedName("LASTSTAT_CMNT")
	private String laststat_cmnt;
	
	@SerializedName("MOD_T")
	private String mod_t;
	
	@SerializedName("MSO_FLD_LEGACY_ACCOUNT_NO")
	private String mso_fld_legacy_account_no;
	
	@SerializedName("MSO_FLD_RMN")
	private String mso_fld_rmn;

	@SerializedName("PARENT_FLAGS")
	private Integer parent_flags;
	
	@SerializedName("NAMEINFO")
	private NAMEINFOElement[] nameinfo;
	
	@SerializedName("PASSWD")
	private String passwd;
	
	@SerializedName("BUSINESS_TYPE")
	private Integer business_type;
	
	@SerializedName("STATUS")
	private Integer status;
	
	@SerializedName("BILLINFO")
	private BILLINFO billinfo;


 	public void setMso_fld_org_structure(MSO_FLD_ORG_STRUCTURE mso_fld_org_structure) {
		this.mso_fld_org_structure = mso_fld_org_structure;
	}

	public MSO_FLD_ORG_STRUCTURE getMso_fld_org_structure() {
		return mso_fld_org_structure;
	}

 	public void setService_info(SERVICE_INFO service_info) {
		this.service_info = service_info;
	}

	public SERVICE_INFO getService_info() {
		return service_info;
	}

 	public void setMso_fld_contact_pref(Integer mso_fld_contact_pref) {
		this.mso_fld_contact_pref = mso_fld_contact_pref;
	}

	public Integer getMso_fld_contact_pref() {
		return mso_fld_contact_pref;
	}

 	public MSO_FLD_CREDIT_PROFILE[] getMso_fld_credit_profile() {
		return mso_fld_credit_profile;
	}

	public void setMso_fld_credit_profile(MSO_FLD_CREDIT_PROFILE[] mso_fld_credit_profile) {
		this.mso_fld_credit_profile = mso_fld_credit_profile;
	}

 	public void setGroup_info(GROUP_INFO group_info) {
		this.group_info = group_info;
	}

	public GROUP_INFO getGroup_info() {
		return group_info;
	}

 	public void setAccount_no(String account_no) {
		this.account_no = account_no;
	}

	public String getAccount_no() {
		return account_no;
	}

 	public void setLogin(String login) {
		this.login = login;
	}

	public String getLogin() {
		return login;
	}

 	public void setMso_fld_data_access(String mso_fld_data_access) {
		this.mso_fld_data_access = mso_fld_data_access;
	}

	public String getMso_fld_data_access() {
		return mso_fld_data_access;
	}

 	public void setCreated_t(String created_t) {
		this.created_t = created_t;
	}

	public String getCreated_t() {
		return created_t;
	}

 	public void setPoid(String poid) {
		this.poid = poid;
	}

	public String getPoid() {
		return poid;
	}

 	public void setProfile_obj(String profile_obj) {
		this.profile_obj = profile_obj;
	}

	public String getProfile_obj() {
		return profile_obj;
	}

 	public void setLaststat_cmnt(String laststat_cmnt) {
		this.laststat_cmnt = laststat_cmnt;
	}

	public String getLaststat_cmnt() {
		return laststat_cmnt;
	}

 	public void setMod_t(String mod_t) {
		this.mod_t = mod_t;
	}

	public String getMod_t() {
		return mod_t;
	}

 	public void setMso_fld_legacy_account_no(String mso_fld_legacy_account_no) {
		this.mso_fld_legacy_account_no = mso_fld_legacy_account_no;
	}

	public String getMso_fld_legacy_account_no() {
		return mso_fld_legacy_account_no;
	}

 	public void setMso_fld_rmn(String mso_fld_rmn) {
		this.mso_fld_rmn = mso_fld_rmn;
	}

	public String getMso_fld_rmn() {
		return mso_fld_rmn;
	}

 	public void setParent_flags(Integer parent_flags) {
		this.parent_flags = parent_flags;
	}

	public Integer getParent_flags() {
		return parent_flags;
	}

 	public void setNameinfo(NAMEINFOElement[] nameinfo) {
		this.nameinfo = nameinfo;
	}

	public NAMEINFOElement[] getNameinfo() {
		return nameinfo;
	}

 	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getPasswd() {
		return passwd;
	}

 	public void setBusiness_type(Integer business_type) {
		this.business_type = business_type;
	}

	public Integer getBusiness_type() {
		return business_type;
	}

 	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getStatus() {
		return status;
	}

	public BILLINFO getBillinfo() {
		return billinfo;
	}

	public void setBillinfo(BILLINFO billinfo) {
		this.billinfo = billinfo;
	}
}
