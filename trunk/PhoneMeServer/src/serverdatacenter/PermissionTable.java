package serverdatacenter;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class PermissionTable {
	private Connection connection;
	
	public PermissionTable(Connection connection) throws SQLException{
		this.connection = connection;
		
		//!!!如果表的设置有变动，必须删除表，然后等待该过程重新建立
		//检查表格是否存在，不存在则建立表格
		Statement statement = (Statement)connection.createStatement();
		String sql = "DESCRIBE Permission";
		try{
			statement.execute(sql);
		}
		catch (Exception e) {
			sql = "CREATE TABLE Permission(uid BIGINT NOT NULL, id BIGINT NOT NULL, permission BLOB NOT NULL, INDEX(uid, id));";
			statement.execute(sql);
		}
	}

}
