package serverdatacenter;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class GroupMemTable extends RelationTable{
	
	public GroupMemTable(Connection connection) throws SQLException{
		super(connection);
	}
	
	@Override
	public String getTableName() {
		return "GroupMem";
	}
}
