package action;

import java.sql.SQLException;
import java.util.Map;

import bean.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.LoginDao;

public class LoginAction extends ActionSupport {

	private String accountId;
	private String password;
	private String error;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public LoginAction() {
		super();
	}

	public String execute() {
		try {
			ActionContext actionContext = ActionContext.getContext();
			Map<String, Object> session = actionContext.getSession();
			session.put("accountId", "");
			
			LoginDao ld = new LoginDao();
			User us = ld.getUser(accountId);
			if (us == null) {
				return showMessage("msg_company_003");
			} else if (!password.equals(us.getPassword())) {
				return showMessage("msg_company_004");
			} else {
				session.put("accountId", accountId);
				return "success";
			}
		} catch (SQLException e) {
			return showExceptionMessage(e.getMessage());
		}
	}

	private String showExceptionMessage(String error) {
		this.error = error;
		return "error";
	}

	private String showMessage(String messageNo) {
		addActionMessage(getText(messageNo));
		return "error";
	}

}
