package actions.Login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import database.ConnectionPool;

public class AddQuestionAction extends ActionSupport implements SessionAware{
	
	Map<String,Object> session=null;
	String question;
	String answer;
	String reanswer;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		Connection connection = ConnectionPool.fetchConnection();
		Statement stmt;
		String query;
		ResultSet rs;
		String status = null;
		String user_id= (String) ActionContext.getContext().getSession().get("username");
		try {
			
			stmt = connection.createStatement();
			query = "select user_id " +
					"from user_extraDetails_300 " +
					"where user_id='"+ user_id +"'";
			System.out.println(query);
			rs = stmt.executeQuery(query);
			if(rs.next()){
				query = "update user_extraDetails_300 " +
						"set answer= '" + answer +"'" +
						"where user_id='" + user_id + "'";
				System.out.println(query);
				int i= stmt.executeUpdate(query);
				System.out.println("Line updated : "+i);
			}
			else{
				query = "insert into user_extraDetails_300 values " +
				"( '" + user_id + "','"+ question + "','" + answer + "'" +
				")";
				System.out.println(query);
				int i= stmt.executeUpdate(query);
				System.out.println("Line inserted : "+i);
			}
							
			
			
			query = "update User_Details_300 " +
					"set first= 'y'" +
					"where user_id='" + user_id + "'";
			System.out.println(query);
			int i= stmt.executeUpdate(query);
			System.out.println("Line updated : "+i);
			
			
			status= (String) ActionContext.getContext().getSession().get("status");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		
		return status;
	}
	
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		if(answer.length() == 0){
			addFieldError("answer", "enter answer" );
		}
		if(reanswer.length() == 0){
			addFieldError("reanswer", "Retype answer" );
		}
		if(! answer.equals(reanswer)){
			addFieldError("answer", "both answer doesnot match" );
		}
	}
	public String getQuestion() {
		return question;
	}



	public void setQuestion(String question) {
		this.question = question;
	}



	public String getAnswer() {
		return answer;
	}



	public void setAnswer(String answer) {
		this.answer = answer;
	}



	public String getReanswer() {
		return reanswer;
	}



	public void setReanswer(String reanswer) {
		this.reanswer = reanswer;
	}



	public void setSession(Map arg0) {
		// TODO Auto-generated method stub
		session=arg0;
	}

}
