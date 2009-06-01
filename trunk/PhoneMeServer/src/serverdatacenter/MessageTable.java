package serverdatacenter;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class MessageTable {
	private Connection connection;
	
	public MessageTable(Connection connection) throws SQLException{
		this.connection = connection;

		//!!!�����������б䶯������ɾ����Ȼ��ȴ��ù������½���
		//����Ƿ��б��û���򽨱�
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
