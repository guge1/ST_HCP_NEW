package user;

import java.math.BigDecimal;
import java.util.Date;

/**
 * AbstractRmUser entity provides the base persistence definition of the RmUser
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractRmUser implements java.io.Serializable {

	// Fields

	private BigDecimal userid;
	private String name;
	private String loginname;
	private String sex;
	private String code;
	private String password;
	private BigDecimal type;
	private String orgid;
	private String postid;
	private String postidCn;
	private String operatorState;
	private String phone;
	private String phonesub;
	private String shortPhone;
	private String mobile;
	private String email;
	private String recondstate;
	private Date createdate;
	private BigDecimal orderindex;

	// Constructors

	/** default constructor */
	public AbstractRmUser() {
	}

	/** minimal constructor */
	public AbstractRmUser(BigDecimal userid) {
		this.userid = userid;
	}

	/** full constructor */
	public AbstractRmUser(BigDecimal userid, String name, String loginname,
			String sex, String code, String password, BigDecimal type,
			String orgid, String postid, String postidCn, String operatorState,
			String phone, String phonesub, String shortPhone, String mobile,
			String email, String recondstate, Date createdate,
			BigDecimal orderindex) {
		this.userid = userid;
		this.name = name;
		this.loginname = loginname;
		this.sex = sex;
		this.code = code;
		this.password = password;
		this.type = type;
		this.orgid = orgid;
		this.postid = postid;
		this.postidCn = postidCn;
		this.operatorState = operatorState;
		this.phone = phone;
		this.phonesub = phonesub;
		this.shortPhone = shortPhone;
		this.mobile = mobile;
		this.email = email;
		this.recondstate = recondstate;
		this.createdate = createdate;
		this.orderindex = orderindex;
	}

	// Property accessors

	public BigDecimal getUserid() {
		return this.userid;
	}

	public void setUserid(BigDecimal userid) {
		this.userid = userid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoginname() {
		return this.loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BigDecimal getType() {
		return this.type;
	}

	public void setType(BigDecimal type) {
		this.type = type;
	}

	public String getOrgid() {
		return this.orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	public String getPostid() {
		return this.postid;
	}

	public void setPostid(String postid) {
		this.postid = postid;
	}

	public String getPostidCn() {
		return this.postidCn;
	}

	public void setPostidCn(String postidCn) {
		this.postidCn = postidCn;
	}

	public String getOperatorState() {
		return this.operatorState;
	}

	public void setOperatorState(String operatorState) {
		this.operatorState = operatorState;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhonesub() {
		return this.phonesub;
	}

	public void setPhonesub(String phonesub) {
		this.phonesub = phonesub;
	}

	public String getShortPhone() {
		return this.shortPhone;
	}

	public void setShortPhone(String shortPhone) {
		this.shortPhone = shortPhone;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRecondstate() {
		return this.recondstate;
	}

	public void setRecondstate(String recondstate) {
		this.recondstate = recondstate;
	}

	public Date getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public BigDecimal getOrderindex() {
		return this.orderindex;
	}

	public void setOrderindex(BigDecimal orderindex) {
		this.orderindex = orderindex;
	}

}