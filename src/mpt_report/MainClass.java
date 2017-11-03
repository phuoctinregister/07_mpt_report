package mpt_report;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MainClass {
	private EnvClass envClass;
	private String permission;

	public MainClass(EnvClass envClass)
  {
    this.envClass = envClass;
  }
	
	
	
	private Connection getConnection() 	    throws Exception
	  {
	    Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
	    Connection conn = DriverManager.getConnection(this.envClass.getDbUrl(), this.envClass.getDbUsername(), this.envClass.getDbPassword());
	    conn.setAutoCommit(false);
	    
	    return conn;
	  }
	
	
	public String login(String userID, String password) 	    throws Exception
	  {
	    String result = null;
	    Connection conn = getConnection();
			CallableStatement callableStmt = conn.prepareCall("{?=call cfappsup.mpt_pfu.VERIFY_ACCOUNT(?,?) } ");
			callableStmt.registerOutParameter(1,12);
			callableStmt.setString(2, userID);
			callableStmt.setString(3, password);
			callableStmt.executeQuery();
			
			result=callableStmt.getString(1);
			callableStmt.close();
			conn.close();
			
			this.permission = result;
      
			
			return result;
	  }

	public String F1CAS_TOTAL_USER() throws Exception
	{
		String result = null;
		Connection conn = getConnection();
		CallableStatement callableStmt = conn.prepareCall("{?=call mpt_pfu.F1CAS_TOTAL_USER() } "); 
		callableStmt.registerOutParameter(1,12);
		callableStmt.executeQuery();
		
		result=callableStmt.getString(1);
		callableStmt.close();
		conn.close();
		
		return result;
	}
	
	public String F1CAS_ACTIVE_USER() throws Exception
	{
		String result = null;
		Connection conn = getConnection();
		CallableStatement callableStmt = conn.prepareCall("{?=call mpt_pfu.F1CAS_ACTIVE_USER() } "); 
		callableStmt.registerOutParameter(1,12);
		callableStmt.executeQuery();
		
		result=callableStmt.getString(1);
		callableStmt.close();
		conn.close();
		
		return result;
	}
	
	public String F1CAS_INACTIVE_USER() throws Exception
	{
		String result = null;
		Connection conn = getConnection();
		CallableStatement callableStmt = conn.prepareCall("{?=call mpt_pfu.F1CAS_INACTIVE_USER() } "); 
		callableStmt.registerOutParameter(1,12);
		callableStmt.executeQuery();
		
		result=callableStmt.getString(1);
		callableStmt.close();
		conn.close();
		
		return result;
	}
	
	public String OMNI_TOTAL_USER() throws Exception
	{
		String result = null;
		Connection conn = getConnection();
		CallableStatement callableStmt = conn.prepareCall("{?=call mpt_pfu.OMNI_TOTAL_USER() } "); 
		callableStmt.registerOutParameter(1,12);
		callableStmt.executeQuery();
		
		result=callableStmt.getString(1);
		callableStmt.close();
		conn.close();
		
		return result;
	}
	
	public String OMNI_ACTIVE_USER() throws Exception
	{
		String result = null;
		Connection conn = getConnection();
		CallableStatement callableStmt = conn.prepareCall("{?=call mpt_pfu.OMNI_ACTIVE_USER() } "); 
		callableStmt.registerOutParameter(1,12);
		callableStmt.executeQuery();
		
		result=callableStmt.getString(1);
		callableStmt.close();
		conn.close();
		
		return result;
	}
	
	public String OMNI_INACTIVE_USER() throws Exception
	{
		String result = null;
		Connection conn = getConnection();
		CallableStatement callableStmt = conn.prepareCall("{?=call mpt_pfu.OMNI_INACTIVE_USER() } "); 
		callableStmt.registerOutParameter(1,12);
		callableStmt.executeQuery();
		
		result=callableStmt.getString(1);
		callableStmt.close();
		conn.close();
		
		return result;
	}
	
	public String CPS_TOTAL_USER() throws Exception
	{
		String result = null;
		Connection conn = getConnection();
		CallableStatement callableStmt = conn.prepareCall("{?=call mpt_pfu.CPS_TOTAL_USER(1) } "); 
		callableStmt.registerOutParameter(1,12);
		callableStmt.executeQuery();
		
		result=callableStmt.getString(1);
		callableStmt.close();
		conn.close();
		
		return result;
	}
	
	public String CPS_ACTIVE_USER() throws Exception
	{
		String result = null;
		Connection conn = getConnection();
		CallableStatement callableStmt = conn.prepareCall("{?=call mpt_pfu.CPS_ACTIVE_USER() } "); 
		callableStmt.registerOutParameter(1,12);
		callableStmt.executeQuery();
		
		result=callableStmt.getString(1);
		callableStmt.close();
		conn.close();
		
		return result;
	}
	
	public String CPS_INACTIVE_USER() throws Exception
	{
		String result = null;
		Connection conn = getConnection();
		CallableStatement callableStmt = conn.prepareCall("{?=call mpt_pfu.CPS_INACTIVE_USER() } "); 
		callableStmt.registerOutParameter(1,12);
		callableStmt.executeQuery();
		
		result=callableStmt.getString(1);
		callableStmt.close();
		conn.close();
		
		return result;
	}
	
	public String F1SSO_NEW_ACTIVATED_USR_BYTIME(String txtStartDate, String txtEndDate) throws Exception
	{
		String result = null;
		Connection conn = getConnection();
		CallableStatement callableStmt = conn.prepareCall("{?=call mpt_pfu.F1SSO_NEW_ACTIVATED_USR_BYTIME(?,?) } "); 
		callableStmt.registerOutParameter(1,12);
		callableStmt.setString(2,txtStartDate);
		callableStmt.setString(3,txtEndDate);
		callableStmt.executeQuery();
		
		result=callableStmt.getString(1);
		callableStmt.close();
		conn.close();
		
		return result;
	}
	
	
	
	
	public List<String> GET_DATA_IN_TABLE() throws Exception
	{
		ResultSet rs;
		Connection conn = getConnection();
		List<String> dataList = new ArrayList<String>();
		
		String sql  = "select * from CFAPPSUP.MPT_PFU_USERS";
		Statement s = conn.createStatement();
		s.execute(sql);		
		rs = s.getResultSet();
		while (rs.next())
		{
			//Add records into data list
			dataList.add(rs.getString("USERNAME"));
			dataList.add(rs.getString("PASSWORD"));
			dataList.add(rs.getString("PERMISSION"));
		}
		rs.close();
		s.close();
		
		return dataList;
	}
	
	
	
	
	
	
	
	public String F1CAS_NEW_ACTIVATED_USR_BYTIME(String txtStartDate, String txtEndDate) throws Exception
	{
		String result = null;
		Connection conn = getConnection();
		CallableStatement callableStmt = conn.prepareCall("{?=call mpt_pfu.F1CAS_NEW_ACTIVATED_USR_BYTIME(?,?) } "); 
		callableStmt.registerOutParameter(1,12);
		callableStmt.setString(2,txtStartDate);
		callableStmt.setString(3,txtEndDate);
		callableStmt.executeQuery();
		
		result=callableStmt.getString(1);
		callableStmt.close();
		conn.close();
		
		return result;
	}
	
	
	public String F1CAS_DEACTIVATED_USR_BYTIME(String txtStartDate, String txtEndDate) throws Exception
	{
		String result = null;
		Connection conn = getConnection();
		CallableStatement callableStmt = conn.prepareCall("{?=call mpt_pfu.F1CAS_DEACTIVATED_USR_BYTIME(?,?) } "); 
		callableStmt.registerOutParameter(1,12);
		callableStmt.setString(2,txtStartDate);
		callableStmt.setString(3,txtEndDate);
		callableStmt.executeQuery();
		
		result=callableStmt.getString(1);
		callableStmt.close();
		conn.close();
		
		return result;
	}
	
	
	public String OMNNI_NEW_ACTIVATED_USR_BYTIME(String txtStartDate, String txtEndDate) throws Exception
	{
		String result = null;
		Connection conn = getConnection();
		CallableStatement callableStmt = conn.prepareCall("{?=call mpt_pfu.OMNNI_NEW_ACTIVATED_USR_BYTIME(?,?) } "); 
		callableStmt.registerOutParameter(1,12);
		callableStmt.setString(2,txtStartDate);
		callableStmt.setString(3,txtEndDate);
		callableStmt.executeQuery();
		
		result=callableStmt.getString(1);
		callableStmt.close();
		conn.close();
		
		return result;
	}
	
	
	
	public String OMNNI_DEACTIVATED_USR_BYTIME(String txtStartDate, String txtEndDate) throws Exception
	{
		String result = null;
		Connection conn = getConnection();
		CallableStatement callableStmt = conn.prepareCall("{?=call mpt_pfu.OMNNI_DEACTIVATED_USR_BYTIME(?,?) } "); 
		callableStmt.registerOutParameter(1,12);
		callableStmt.setString(2,txtStartDate);
		callableStmt.setString(3,txtEndDate);
		callableStmt.executeQuery();
		
		result=callableStmt.getString(1);
		callableStmt.close();
		conn.close();
		
		return result;
	}
	
	
	public String CPS_NEW_ACTIVATED_USR_BYTIME(String txtStartDate, String txtEndDate) throws Exception
	{
		String result = null;
		Connection conn = getConnection();
		CallableStatement callableStmt = conn.prepareCall("{?=call mpt_pfu.CPS_NEW_ACTIVATED_USR_BYTIME(?,?) } "); 
		callableStmt.registerOutParameter(1,12);
		callableStmt.setString(2,txtStartDate);
		callableStmt.setString(3,txtEndDate);
		callableStmt.executeQuery();
		
		result=callableStmt.getString(1);
		callableStmt.close();
		conn.close();
		
		return result;
	}
	
	
	public String CPS_DEACTIVATED_USR_BYTIME(String txtStartDate, String txtEndDate) throws Exception
	{
		String result = null;
		Connection conn = getConnection();
		CallableStatement callableStmt = conn.prepareCall("{?=call mpt_pfu.CPS_DEACTIVATED_USR_BYTIME(?,?) } "); 
		callableStmt.registerOutParameter(1,12);
		callableStmt.setString(2,txtStartDate);
		callableStmt.setString(3,txtEndDate);
		callableStmt.executeQuery();
		
		result=callableStmt.getString(1);
		callableStmt.close();
		conn.close();
		
		return result;
	}
	
	
	public String F1SSO_DEACTIVATED_USR_BYTIME(String txtStartDate, String txtEndDate) throws Exception
	{
		String result = null;
		Connection conn = getConnection();
		CallableStatement callableStmt = conn.prepareCall("{?=call mpt_pfu.F1SSO_DEACTIVATED_USR_BYTIME(?,?) } "); 
		callableStmt.registerOutParameter(1,12);
		callableStmt.setString(2,txtStartDate);
		callableStmt.setString(3,txtEndDate);
		callableStmt.executeQuery();
		
		result=callableStmt.getString(1);
		callableStmt.close();
		conn.close();
		
		return result;
	}
	

	public String PEGA_NEW_ACTIVATED_USR_BYTIME (String txtStartDate, String txtEndDate) throws Exception
	{
		String result = null;
		Connection connPega = getPegaConnection();
		CallableStatement callableStmt = connPega.prepareCall("{?=call cpm.mpt_pfu.PEGA_NEW_ACTIVATED_USR_BYTIME(?,?) } "); 
		callableStmt.registerOutParameter(1,12);
		callableStmt.setString(2,txtStartDate);
		callableStmt.setString(3,txtEndDate);
		callableStmt.executeQuery();
		
		result=callableStmt.getString(1);
		callableStmt.close();
		connPega.close();
		
		return result;
	}
	
	public String CHANGE_PASSWORD(String p_username, String p_newPassword) throws Exception
	{
		String result = null;
		Connection conn = getConnection();
		CallableStatement callableStmt = conn.prepareCall("{?=call cfappsup.mpt_pfu.CHANGE_PASSWORD(?,?) } "); 
		callableStmt.registerOutParameter(1,12);
		callableStmt.setString(2,p_username);
		callableStmt.setString(3,p_newPassword);
		callableStmt.executeQuery();
		
		result=callableStmt.getString(1);
		callableStmt.close();
		conn.close();
		
		return result;
	}
	
	public String PEGA_DEACTIVATED_USR_BYTIME (String txtStartDate, String txtEndDate) throws Exception
	{
		String result = null;
		Connection connPega = getPegaConnection();
		CallableStatement callableStmt = connPega.prepareCall("{?=call cpm.mpt_pfu.PEGA_DEACTIVATED_USR_BYTIME(?,?) } "); 
		callableStmt.registerOutParameter(1,12);
		callableStmt.setString(2,txtStartDate);
		callableStmt.setString(3,txtEndDate);
		callableStmt.executeQuery();
		
		result=callableStmt.getString(1);
		callableStmt.close();
		connPega.close();
		
		return result;
	}

	private Connection getPegaConnection() 	  throws Exception
  {
    Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
    Connection connPega = DriverManager.getConnection(this.envClass.getDbPegaUrl(), this.envClass.getDbPegaUsername(), this.envClass.getDbPegaPassword());
    connPega.setAutoCommit(false);
    
    return connPega;
  }
	
	public String PEGA_TOTAL_USER () throws Exception
	{
		String result = null;
		Connection connPega = getPegaConnection();
		CallableStatement callableStmt = connPega.prepareCall("{?=call cpm.mpt_pfu.PEGA_TOTAL_USER() } "); 
		callableStmt.registerOutParameter(1,12);
		callableStmt.executeQuery();
		
		result=callableStmt.getString(1);
		callableStmt.close();
		connPega.close();
		
		return result;
	}
	
	
	
	
	
	
	public String PEGA_ACTIVE_USER () throws Exception
	{
		String result = null;
		Connection connPega = getPegaConnection();
		CallableStatement callableStmt = connPega.prepareCall("{?=call cpm.mpt_pfu.PEGA_ACTIVE_USER() } "); 
		callableStmt.registerOutParameter(1,12);
		callableStmt.executeQuery();
		
		result=callableStmt.getString(1);
		callableStmt.close();
		connPega.close();
		
		return result;
	}
	
	public String PEGA_INACTIVE_USER () throws Exception
	{
		String result = null;
		Connection connPega = getPegaConnection();
		CallableStatement callableStmt = connPega.prepareCall("{?=call cpm.mpt_pfu.PEGA_INACTIVE_USER() } "); 
		callableStmt.registerOutParameter(1,12);
		callableStmt.executeQuery();
		
		result=callableStmt.getString(1);
		callableStmt.close();
		connPega.close();
		
		return result;
	}
	
	public boolean hasPermission(String permission)
  {
    return this.permission.indexOf(permission) >= 0;
  }
}
