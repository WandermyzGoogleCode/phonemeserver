package serverdatacenter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import entity.ID;
import entity.message.Message;

public class MessageTable {
	private Connection connection;

	public MessageTable(Connection connection) throws SQLException {
		this.connection = connection;

		// !!!�����������б䶯������ɾ����Ȼ��ȴ��ù������½���
		// ����Ƿ��б��û���򽨱�
		Statement statement = (Statement) connection.createStatement();
		String sql = "DESCRIBE Message";
		try {
			statement.execute(sql);
		} catch (Exception e) {
			sql = "CREATE TABLE Message(mid BIGINT NOT NULL, uid BIGINT NOT NULL, msg BLOB NOT NULL, PRIMARY KEY(mid), INDEX(uid)) CHARACTER SET gbk COLLATE gbk_bin;";
			statement.execute(sql);
		}
	}

	public void addMessage(ID mid, ID uid, Message msg) throws SQLException {
		String psql = "REPLACE INTO Message VALUES(?, ?, ?)";
		PreparedStatement pStatement = connection.prepareStatement(psql);
		pStatement.setLong(1, mid.getValue());
		pStatement.setLong(2, uid.getValue());
		pStatement.setBlob(3, new SerialBlob(Serializer.serialize(msg)));
		pStatement.execute();
	}

	public List<Message> getAllMessages(ID uid) throws SQLException{
		String psql = "SELECT msg FROM Message WHERE uid=?";
		PreparedStatement pStatement = connection.prepareStatement(psql);
		pStatement.setLong(1, uid.getValue());
		List<Message> res = new ArrayList<Message>();
		ResultSet resultSet = pStatement.executeQuery();
		while (resultSet.next()){
			res.add((Message)Serializer.unserialize(resultSet.getBlob(1)));
		}
		return res;
	}
}