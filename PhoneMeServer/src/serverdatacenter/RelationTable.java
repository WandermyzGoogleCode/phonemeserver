package serverdatacenter;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public abstract class RelationTable {
	private Connection connection;
	
	//子类说明自己的表名
	abstract public String getTableName();
	
	public RelationTable(Connection connection) throws SQLException{
		this.connection = connection;
		
		//如果表不存在，建立表
		Statement statement = (Statement)connection.createStatement();
		String sql = "DESCRIBE "+getTableName();
		try{
			statement.execute(sql);
		}
		catch (Exception e) {
			sql = "CREATE TABLE "+getTableName()+"(id1 BIGINT NOT NULL, id2 BIGINT NOT NULL, INDEX(id1, id2));";
			statement.execute(sql);
		}
	}
}
