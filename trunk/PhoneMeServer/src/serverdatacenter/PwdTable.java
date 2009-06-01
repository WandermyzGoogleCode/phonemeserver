package serverdatacenter;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class PwdTable {
	private Connection connection;
	
	public PwdTable(Connection connection) throws SQLException{
		this.connection = connection;
		
		//�жϱ��Ƿ���ڣ��������򽨱�
		Statement statement = (Statement)connection.createStatement();
		String sql = "DESCRIBE Pwd";
		try{
			statement.execute(sql);
		}
		catch (Exception e) {
			sql = "CREATE TABLE Pwd(uid BIGINT NOT NULL, pwd TINYBLOB NOT NULL, PRIMARY KEY(uid));";
			statement.execute(sql);
		}
	}

}
