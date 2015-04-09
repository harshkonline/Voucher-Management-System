package actions.GenerateVoucher;

import beans.GenerateVoucher.GenerateInFile;

import com.opensymphony.xwork2.ActionSupport;

public class demo extends ActionSupport{
	public String execute() {
		GenerateInFile file = new GenerateInFile();
		file.generateFile(new Integer(10081).toString());
		return SUCCESS;
	}
}
