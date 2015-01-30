package user;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * RmUser entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see user.RmUser
 * @author MyEclipse Persistence Tools
 */

public class RmUserDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(RmUserDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String LOGINNAME = "loginname";
	public static final String SEX = "sex";
	public static final String CODE = "code";
	public static final String PASSWORD = "password";
	public static final String ORGID = "orgid";
	public static final String POSTID = "postid";
	public static final String POSTID_CN = "postidCn";
	public static final String OPERATOR_STATE = "operatorState";
	public static final String PHONE = "phone";
	public static final String PHONESUB = "phonesub";
	public static final String SHORT_PHONE = "shortPhone";
	public static final String MOBILE = "mobile";
	public static final String EMAIL = "email";
	public static final String RECONDSTATE = "recondstate";

	protected void initDao() {
		// do nothing
	}

	public void save(RmUser transientInstance) {
		log.debug("saving RmUser instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(RmUser persistentInstance) {
		log.debug("deleting RmUser instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public RmUser findById(java.math.BigDecimal id) {
		log.debug("getting RmUser instance with id: " + id);
		try {
			RmUser instance = (RmUser) getHibernateTemplate().get(
					"user.RmUser", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(RmUser instance) {
		log.debug("finding RmUser instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding RmUser instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from RmUser as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByLoginname(Object loginname) {
		return findByProperty(LOGINNAME, loginname);
	}

	public List findBySex(Object sex) {
		return findByProperty(SEX, sex);
	}

	public List findByCode(Object code) {
		return findByProperty(CODE, code);
	}

	public List findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List findByOrgid(Object orgid) {
		return findByProperty(ORGID, orgid);
	}

	public List findByPostid(Object postid) {
		return findByProperty(POSTID, postid);
	}

	public List findByPostidCn(Object postidCn) {
		return findByProperty(POSTID_CN, postidCn);
	}

	public List findByOperatorState(Object operatorState) {
		return findByProperty(OPERATOR_STATE, operatorState);
	}

	public List findByPhone(Object phone) {
		return findByProperty(PHONE, phone);
	}

	public List findByPhonesub(Object phonesub) {
		return findByProperty(PHONESUB, phonesub);
	}

	public List findByShortPhone(Object shortPhone) {
		return findByProperty(SHORT_PHONE, shortPhone);
	}

	public List findByMobile(Object mobile) {
		return findByProperty(MOBILE, mobile);
	}

	public List findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List findByRecondstate(Object recondstate) {
		return findByProperty(RECONDSTATE, recondstate);
	}

	public List findAll() {
		log.debug("finding all RmUser instances");
		try {
			String queryString = "from RmUser";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public RmUser merge(RmUser detachedInstance) {
		log.debug("merging RmUser instance");
		try {
			RmUser result = (RmUser) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(RmUser instance) {
		log.debug("attaching dirty RmUser instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RmUser instance) {
		log.debug("attaching clean RmUser instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static RmUserDAO getFromApplicationContext(ApplicationContext ctx) {
		return (RmUserDAO) ctx.getBean("RmUserDAO");
	}
}