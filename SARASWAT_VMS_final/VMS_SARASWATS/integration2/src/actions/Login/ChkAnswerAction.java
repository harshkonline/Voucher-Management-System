package actions.Login;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import beans.ForgetPasswordBean;

public class ChkAnswerAction extends ActionSupport implements ModelDriven{
	
	ForgetPasswordBean obj=new ForgetPasswordBean();
	
	public ForgetPasswordService getForgetPasswordService(){
		return new ForgetPasswordService();
	}
	
	public ForgetPasswordBean getObj() {
		return obj;
	}

	public void setObj(ForgetPasswordBean obj) {
		this.obj = obj;
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		boolean flag=false;
		flag= getForgetPasswordService().chkAnswer(obj);
		if(flag){
			return SUCCESS;	
		}else{
			addFieldError("answer", "answer is incorrect try again");
			return INPUT;	
		}
		
	}
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		if(obj.getAnswer().length()==0){
			addFieldError("answer", "Enter Answer");
		}
	}

	public Object getModel() {
		// TODO Auto-generated method stub
		return obj;
	}
}
