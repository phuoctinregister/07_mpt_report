package mpt_report;

public class EnvClass {
  private String dbUrl;
  private String dbUsername;
  private String dbPassword;
  private String envName;
  
  private String dbPegaUrl;
  private String dbPegaUsername;
  private String dbPegaPassword;
  
  
  
  public String getDbPegaUsername() {
		return dbPegaUsername;
	}

	public void setDbPegaUsername(String dbPegaUsername) {
		this.dbPegaUsername = dbPegaUsername;
	}

	public String getDbPegaPassword() {
		return dbPegaPassword;
	}

	public void setDbPegaPassword(String dbPegaPassword) {
		this.dbPegaPassword = dbPegaPassword;
	}

	public String getDbPegaUrl() {
		return dbPegaUrl;
	}

	public void setDbPegaUrl(String dbPegaUrl) {
		this.dbPegaUrl = dbPegaUrl;
	}

	public void setDbUrl(String dbUrl)
  {
    this.dbUrl = dbUrl;
  }
  
  public String getDbUrl()
  {
    return this.dbUrl;
  }
  
  public void setDbUsername(String dbUsername)
  {
    this.dbUsername = dbUsername;
  }
  
  public String getDbUsername()
  {
    return this.dbUsername;
  }
  
  public void setDbPassword(String dbPassword)
  {
    this.dbPassword = dbPassword;
  }
  
  public String getDbPassword()
  {
    return this.dbPassword;
  }
  
  public void setEnvName(String envName)
  {
    this.envName = envName;
  }
  
  public String getEnvName()
  {
    return this.envName;
  }
}
