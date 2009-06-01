package serverdatacenter;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class VisibilityTable {
	private Connection connection;
	
	public VisibilityTable(Connection connection) throws SQLException {
		this.connection = connection;
		
		//�жϱ��Ƿ���ڣ��������򽨱�
		Statement statement = (Statement)this.connection.createStatement();
		String sql = "DESCRIBE Visibility";
		try{
			statement.execute(sql);
		}
		catch (Exception e) {
			sql = "CREATE TABLE Visibility(uid BIGINT NOT NULL, id BIGINT NOT NULL, v INT NOT NULL, INDEX(uid, id));";
			statement.execute(sql);
		}
	}

}
