package serverdatacenter;
import java.util.List;
import entity.*;
import entity.infoField.*;
import entity.message.Message;
import algorithm.*;

public interface ServerDataCenter {
	/**
	 * ��info�ϵ�IdenticalInfoField�󶨵���ע���û���id�ϣ��Ա��¼��ʱ�����ͨ��
	 * �������õ�id��id����ϵͳ�Զ����ɵģ�һ��id���Զ�Ӧ�����IdenticalInfoField
	 * pwdΪ�û�������
	 * @param e
	 * @param info
	 * @return
	 */
	public ReturnType register(BaseUserInfo info, Password pwd);

	/**
	 * ���idField��Ӧ�û��������pwd��ȣ���
	 * ����idField��Ӧ�û���id�����򷵻�һ��nullID����ʾ
	 * �û������ڻ������벻��ȡ�
	 * @param e
	 * @return
	 */
	public ID loginGetInfo(IdenticalInfoField idField, Password pwd);
	
	/**
	 * ��IDΪuid���û��Ĵ��ڷ���������Ϣ��BaseUserInfo������Ϊb
	 * @param uid �û�ID
	 * @param b �µ��û���Ϣ
	 * @return
	 */
	public ReturnType setBaseUserInfo(ID uid, BaseUserInfo b);
	
	/**
	 * uid1����ͬ����ϵ��uid2
	 * @param visibility uid1��uid2�Ĺ�ϵ�Ŀɼ����Ϊvisibility
	 * @param uid1 ʵ�иò������û�
	 * @param uid2 ͬ����ϵ�˵�ID
	 * @return
	 */
	public ReturnType addSynRelationship(ID uid1, ID uid2, int visibility);
	
	/**
	 * uid1ɾ��ͬ����ϵ��uid2
	 * @param uid1 ʵ�иò������û�
	 * @param uid2 ͬ����ϵ�˵�ID
	 * @return
	 */
	public ReturnType removeSynRelationship(ID uid1, ID uid2);
	
	/**
	 * ���ӱ���Ȩ��ϵ�˹�ϵ������uid1��uid2)(add permitted relationship)
	 * @param permission �ñ���Ȩ��ϵ�˵�Ȩ��
	 * @param uid1 ʵ�иò������û�
	 * @param uid2 ����Ȩ��ϵ�˵�ID
	 * @return
	 */
	public ReturnType addPerRelationship(ID uid1, ID uid2, Permission permission);

	/**
	 * ɾ������Ȩ��ϵ�˹�ϵ������uid1��uid2)
	 * @param uid1 ʵ�иò������û�
	 * @param uid2 ����Ȩ��ϵ�˵�ID
	 * @return
	 */
	public ReturnType removePerRelationship(ID uid1, ID uid2);
	
	/**
	 * �������޸�Ⱥ��g
	 * @param g
	 * @return
	 */
	public ReturnType setGroup(Group g);
	
	/**
	 * ���û�uid����Ⱥ��g�У�uid��g��Ȩ��Ϊpermission
	 * @param g Ⱥ��
	 * @param uid ��Ҫ��ӵ��û�ID
	 * @param permission IDΪuid���û���Ⱥ�����û���Ȩ��
	 * @return
	 */
	public ReturnType addToGroup(Group g, ID uid, Permission permission);
	
	/**
	 * ���û�uid��Ⱥ��g��ɾ��
	 * @param g Ⱥ��
	 * @param uid ��Ҫɾ�����û�ID
	 * @return
	 */
	public ReturnType removeFromGroup(Group g, ID uid);
	
	/**
	 * ɾ��Ⱥ��g
	 * @param g Ⱥ��
	 * @return
	 */
	public ReturnType removeGroup(Group g);
	
	/**
	 * �����û�uid��һ��δ���͵���Ϣ���������롢���롢֪ͨ�ȣ������������ȴ������ߵ�ʱ���͡�
	 * �û���Ӧ�������ݿ��з�ֹ������DOWN���Ժ����ݶ�ʧ��
	 * @param uid
	 * @param msg
	 * @return
	 */
	public ReturnType addMessageBuffer(ID uid, Message msg);
	
	/**
	 * �����û�uid��һ��δ���͵���Ϣ���������롢���롢֪ͨ�ȣ��ӻ�����ɾ����
	 * 
	 * ���ص�����������ֵ��һ��ָʾ�ɹ����(BoolInfo.isTrue())��һ����ʾ
	 * ��Ӧ�Ľ��ͣ����������Ϣ��
	 * @param uid
	 * @param msg
	 * @return
	 */
	public BoolInfo removeMessageBuffer(ID uid, Message msg);
	
	/**
	 * ����û�uid�Ļ����˵�δ���͵���Ϣ���������롢���롢֪ͨ�ȣ���
	 * �������Ը��û�����Ϣ
	 * @param uid 
	 * @return
	 */
	public List<Message> getMessageBuffer(ID uid);
	
	/**
	 * ����uid�û�����ͬ����ϵ�˵�ID
	 * @return
	 */
	public ReturnType getSynContactID(ID uid);

	/**
	 * ����uid�û����б���Ȩ��ϵ�˵�ID
	 * @param uid
	 * @return
	 */
	public ReturnType getPerContactID(ID uid);
	
	/**
	 * ����idList������ID��Ӧ���û���BaseUserInfo
	 * idList����Ϊ1��ʱ�򣬾��ǲ�ѯһ���û���BaseUserInfo
	 * @param idList
	 * @return
	 */
	public List<BaseUserInfo> getUsersInfo(List<ID> idList);
	
	/**
	 * ����uid��targetIDList������ID����Ȩ
	 * ���uid�ı���Ȩ��ϵ����û�ж��嵽targetIDList��ĳ��ID����Ȩ����ô����һ��NullObject��
	 * @param uid
	 * @param targetIDList
	 * @return
	 */
	public ReturnType getPermissions(ID uid, List<ID> targetIDList);
	
	/**
	 * �趨�û�uid1���û�uid2��Ȩ��
	 * @param uid1
	 * @param uid2
	 * @return
	 */
	public ReturnType setPermission(ID uid1, ID uid2, Permission permission);
	
	/**
	 * �޸��û�uid��Ⱥ��g��Ȩ��
	 * @param uid
	 * @param g
	 * @return
	 */
	public ReturnType setGroupPermission(ID uid, Group g);
	
	/**
	 * �����û�uid��Ⱥ��g�������Ȩ��
	 * @param uid
	 * @param g
	 * @return
	 */
	public ReturnType getGroupPermission(ID uid, Group g);
	
	/**
	 * ����uid��targetIDList������ID�Ĺ�ϵ�ɼ���
	 * ���uid��ͬ����ϵ����û�ж��嵽targetIDList��ĳ��ID�Ĺ�ϵ�ɼ��ԣ���ô����һ��0��
	 * @param uid
	 * @param targetIDList
	 * @return
	 */
	public ReturnType getVisibilities(ID uid, List<ID> targetIDList);
	
	/**
	 * ����������info����������ƥ���ϵ��û�
	 * @param info
	 * @return
	 */
	public ReturnType searchUser(BaseUserInfo info);
	
	/**
	 * ����IdenticalInfoField�����û���ID
	 * ��Ϊ�ҵ�ƥ���û����򷵻�nullID����Ҫ����null
	 * @param idInfo
	 * @return
	 */
	public ID searchUserID(IdenticalInfoField idInfo);
	
	/**
	 * �趨�û�uid1���û�uid2�Ĺ�ϵ�ɼ���
	 * @param uid1
	 * @param uid2
	 * @param visibility
	 * @return
	 */
	public ReturnType setVisiblity(ID uid1, ID uid2, int visibility);
}
