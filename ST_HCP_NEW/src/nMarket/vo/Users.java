package nMarket.vo;


@SuppressWarnings("serial")
public class Users implements java.io.Serializable {

	// Fields

	private Integer id;
	private String username;
	private String password;
	private String usertype;

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** full constructor */
	public Users(String username, String password,String usertype) {
		this.username = username;
		this.password = password;
		this.usertype = usertype;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

}