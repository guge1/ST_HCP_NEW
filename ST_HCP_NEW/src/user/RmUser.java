package user;

import java.math.BigDecimal;
import java.util.Date;

/**
 * RmUser entity. @author MyEclipse Persistence Tools
 */
public class RmUser extends AbstractRmUser implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public RmUser() {
	}

	/** minimal constructor */
	public RmUser(BigDecimal userid) {
		super(userid);
	}

	/** full constructor */
	public RmUser(BigDecimal userid, String name, String loginname, String sex,
			String code, String password, BigDecimal type, String orgid,
			String postid, String postidCn, String operatorState, String phone,
			String phonesub, String shortPhone, String mobile, String email,
			String recondstate, Date createdate, BigDecimal orderindex) {
		super(userid, name, loginname, sex, code, password, type, orgid,
				postid, postidCn, operatorState, phone, phonesub, shortPhone,
				mobile, email, recondstate, createdate, orderindex);
	}

}
