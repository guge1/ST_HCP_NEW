package system.publicClass;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nMarket.vo.Users;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Transaction;

import org.hibernate.Query;
import org.hibernate.Session;
import org.login.dao.IUsersDAO; 
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import system.dao.IPublicDAO;
import system.dao.ISqlDAO;

/**
 * 初始化spring
 * @author Administrator
 *
 */
@SuppressWarnings("unchecked")
public class PublicInit   {
	
	public PublicInit( FilterConfig filterConfig) {
		this.filterConfig=filterConfig;
	}
	
	
	private WebApplicationContext wac = null;
	private FilterConfig filterConfig;
	 
	 
	/**
	 * 
	 * @param name 需要获得的Bean在Web.XML中配置的param-name
	 * @return
	 * @throws Exception
	 */
	public Object getBeanByFilterConfigParameterName(String name) throws Exception {
		String targetBean = this.filterConfig.getInitParameter(name);

		if ("".equals(targetBean)) {
			targetBean = null;
		}

		ApplicationContext ctx =   getContext(this.filterConfig);

		String beanName = null;	

		if ((targetBean != null) && (ctx.containsBean(targetBean))) {
			beanName = targetBean;
		} else {
			Class targetClass;
			if (targetBean != null) {
				throw new ServletException("targetBean '" + targetBean
						+ "' not found in context");
			}
			String targetClassString = this.filterConfig
					.getInitParameter("targetClass");

			if ((targetClassString == null) || ("".equals(targetClassString))) {
				throw new ServletException(
						"targetClass or targetBean must be specified");
			}

			try {
				targetClass = Class.forName(targetClassString);
			} catch (ClassNotFoundException ex) {
				throw new ServletException("Class of type " + targetClassString
						+ " not found in classloader");
			}

			Map beans = ctx.getBeansOfType(targetClass, true, false);

			if (beans.size() == 0) {
				throw new ServletException(
						"Bean context must contain at least one bean of type "
								+ targetClassString);
			}

			beanName = (String) beans.keySet().iterator().next();
		}

		Object object = ctx.getBean(beanName);
		
		return object;

		// if (!(object instanceof Filter)) {
		// throw new ServletException("Bean '" + beanName
		// + "' does not implement javax.servlet.Filter");
		// }

	}

	private synchronized WebApplicationContext getWebApplicationContext(ServletContext sc) {
		if(wac==null){
			wac = WebApplicationContextUtils
					.getWebApplicationContext(sc);
			if (wac == null) {
				throw new IllegalStateException(
						"No WebApplicationContext found: no ContextLoaderListener registered?");
			}
		}
		return wac;
	}
	protected ApplicationContext getContext(FilterConfig filterConfig) {
		return (ApplicationContext) getWebApplicationContext(filterConfig
				.getServletContext());
	}
	
	
 
}
