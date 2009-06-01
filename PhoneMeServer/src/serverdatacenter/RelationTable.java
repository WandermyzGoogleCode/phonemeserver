package serverdatacenter;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public abstract class RelationTable {
	private Connection connection;
	
	//����˵���Լ��ı���
	abstract public String getTableName();
	
	public RelationTable(Connection connection) throws SQLException{
		this.connection = connection;
		
		//��������ڣ�������
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
