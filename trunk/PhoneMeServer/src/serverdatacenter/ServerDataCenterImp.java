package serverdatacenter;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import datacenter.DataCenterImp;

import entity.BaseUserInfo;
import entity.BoolInfo;
import entity.CustomUserInfo;
import entity.Group;
import entity.ID;
import entity.Password;
import entity.Permission;
import entity.ReturnType;
import entity.UserInfo;
import entity.infoField.IdenticalInfoField;
import entity.infoField.IndexedInfoField;
import entity.message.Message;

public class ServerDataCenterImp implements ServerDataCenter {
	// ���ݿ��û���
	private String userName = "root";
	// ����
	private String userPasswd = "81999";
	// ���ݿ���
	private String dbName = "PhoneMeServer";
	// �����ַ���
	private String url = "jdbc:mysql://localhost/" + dbName + "?user="
			+ userName + "&password=" + userPasswd;

	private static ServerDataCenterImp instance = null;
	
	private UserInfoTable userInfoTable;
	private GroupInfoTable groupInfoTable;
	private GroupMemTable groupMemTable;
	private SynRelationTable synRelationTable;
	private PerRelationTable perRelationTable;
	private VisibilityTable visibilityTable;
	private PermissionTable permissionTable;
	private MessageTable messageTable;
	private PwdTable pwdTable;
	private IDMapTable idMap;

	/**
	 * ���캯�������г�ʼ�����Ա���������������򽨱�Ȳ���
	 */
	private ServerDataCenterImp() {
		// TODO NEXT

		// ����
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connection = (Connection) DriverManager
					.getConnection(url);
			userInfoTable = new UserInfoTable(connection);
			groupInfoTable = new GroupInfoTable(connection);
			groupMemTable = new GroupMemTable(connection);
			synRelationTable = new SynRelationTable(connection);
			perRelationTable = new PerRelationTable(connection);
			visibilityTable = new VisibilityTable(connection);
			permissionTable = new PermissionTable(connection);
			messageTable = new MessageTable(connection);
			pwdTable = new PwdTable(connection);
			idMap = new IDMapTable(connection);
		}
		catch (Exception e) {
			System.out.println(e);
			System.exit(0);
		}
	}
	
	public synchronized static ServerDataCenter getInstance(){
		if (instance == null)
			instance = new ServerDataCenterImp();
		return instance;
	}

	@Override
	public ReturnType addMessageBuffer(ID uid, Message msg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReturnType addPerRelationship(ID uid1, ID uid2, Permission permission) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReturnType addSynRelationship(ID uid1, ID uid2, int visibility) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReturnType addToGroup(Group g, ID uid, Permission permission) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Group getGroup(ID gid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Group> getGroups(ID uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> getMessageBuffer(ID uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ID> getPerContactID(ID uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Permission> getPermissions(ID uid, List<ID> targetIDList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ID> getSynContactID(ID uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BaseUserInfo> getUsersInfo(List<ID> idList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> getVisibilities(ID uid, List<ID> targetIDList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isPerContact(ID id1, ID id2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ID loginGetInfo(IdenticalInfoField idField, Password pwd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReturnType register(BaseUserInfo info, Password pwd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReturnType removeFromGroup(Group g, ID uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReturnType removeGroup(Group g) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoolInfo removeMessageBuffer(ID uid, Message msg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReturnType removePerRelationship(ID uid1, ID uid2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReturnType removeSynRelationship(ID uid1, ID uid2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Group> searchGroup(Group info) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BaseUserInfo> searchUser(BaseUserInfo info) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ID searchUserID(IdenticalInfoField idInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReturnType setBaseUserInfo(ID uid, BaseUserInfo b) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReturnType setGroup(Group g) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReturnType setPermission(ID id1, ID id2, Permission permission) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReturnType setVisiblity(ID uid1, ID uid2, int visibility) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String args[]){
		ServerDataCenterImp.getInstance();
	}
}
