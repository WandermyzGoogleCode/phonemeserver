package serverdatacenter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import entity.ID;

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
			sql = "CREATE TABLE Visibility(uid BIGINT NOT NULL, id BIGINT NOT NULL, v INT NOT NULL, INDEX(uid, id)) CHARACTER SET gbk COLLATE gbk_bin;";
			statement.execute(sql);
		}
	}

	private boolean hasVisibility(ID uid, ID id) throws SQLException{
		String psql = "SELECT COUNT(*) FROM Visibility WHERE uid=? AND id=?";
		PreparedStatement pStatement = connection.prepareStatement(psql);
		pStatement.setLong(1, uid.getValue());
		pStatement.setLong(2, id.getValue());
		ResultSet res = pStatement.executeQuery();
		return (res.next() && res.getInt(1) > 0);
	}

	public void setVisibility(ID uid, ID id, int visibility) throws SQLException{
		String psql;
		if (hasVisibility(uid, id))
			psql = "UPDATE Visibility SET v=? WHERE uid=? AND id=?";
		else
			psql = "INSERT INTO Visibility (v, uid, id)VALUES(?, ?, ?)";
		PreparedStatement pStatement = connection.prepareStatement(psql);
		pStatement.setInt(1, visibility);
		pStatement.setLong(2, uid.getValue());
		pStatement.setLong(3, id.getValue());
		pStatement.execute();
	}
}
