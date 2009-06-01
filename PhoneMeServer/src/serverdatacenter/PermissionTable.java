package serverdatacenter;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class PermissionTable {
	private Connection connection;
	
	public PermissionTable(Connection connection) throws SQLException{
		this.connection = connection;
		
		//!!!�����������б䶯������ɾ����Ȼ��ȴ��ù������½���
		//������Ƿ���ڣ��������������
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
