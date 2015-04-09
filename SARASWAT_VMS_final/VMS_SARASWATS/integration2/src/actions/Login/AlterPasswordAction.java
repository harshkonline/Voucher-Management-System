package actions.Login;

import beans.ForgetPasswordBean;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AlterPasswordAction extends ActionSupport implements ModelDriven {

	ForgetPasswordBean obj = new ForgetPasswordBean();

	public ForgetPasswordService getForgetPasswordService() {
		return new ForgetPasswordService();
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		boolean flag;

		flag = getForgetPasswordService().alterPassword(obj);
		if (flag) {
			return SUCCESS;
		} else {

			return "fail";
		}
	}

	@Override
	public void validate() {
		// TODO Auto-generated method stub

		if (obj.getNewpwd().length() == 0) {
			addFieldError("newpwd", "Enter new Password");
		} else {
			String newpwd = obj.getNewpwd();
			String repwd = obj.getRepwd();
			if (!newpwd.equals(repwd)) {
				addFieldError("repwd", "Password mismatch");
			}
		}
	}

	public ForgetPasswordBean getObj() {
		return obj;
	}

	public void setObj(ForgetPasswordBean obj) {
		this.obj = obj;
	}

	public Object getModel() {
		// TODO Auto-generated method stub
		return obj;
	}

}
