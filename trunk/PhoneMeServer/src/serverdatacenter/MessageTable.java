package serverdatacenter;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class MessageTable {
	private Connection connection;
	
	public MessageTable(Connection connection) throws SQLException{
		this.connection = connection;

		//!!!如果表的设置有变动，必须删除表，然后等待该过程重新建立
		//检查是否有表格，没有则建表
		Statement statement = (Statement)connection.createStatement();
		String sql = "DESCRIBE Message";
		try{
			statement.execute(sql);
		}
		catch (Exception e) {
			sql = "CREATE TABLE Message(mid BIGINT NOT NULL, uid BIGINT NOT NULL, msg BLOB NOT NULL, PRIMARY KEY(mid), INDEX(uid));";
			statement.execute(sql);
		}
	}

}
