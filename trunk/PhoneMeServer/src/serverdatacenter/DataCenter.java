package serverdatacenter;
import java.util.ArrayList;
import entity.*;
import algorithm.*;

public interface DataCenter {
	/**
	 * 将e绑定到该注册用户的id上，以便登录的时候可以通过e来得到id
	 * id是由系统自动生成的，一个id可以对应到多个emailAddr上，这个是由用户自己定的
	 * @param e
	 * @param info
	 * @return
	 */
	public ReturnType register(EmailAddr e, BaseUserInfo info);

	/**
	 * 返回e对应用户的id和加密后的密码
	 * @param e
	 * @return
	 */
	public ReturnType loginGetInfo(EmailAddr e);
	
	public ReturnType setUserInfo(UserInfo b);
	
	/**
	 * uid1增加同步联系人uid2
	 * @param visibility uid1到uid2的关系的可见层次为visibility
	 * @param uid1 实行该操作的用户
	 * @param uid2 同步联系人的ID
	 * @return
	 */
	public ReturnType addSynRelationship(ID uid1, ID uid2, int visibility);
	
	public ReturnType removeSynRelationship(ID uid1, ID uid2);
	
	/**
	 * 增加被授权联系人关系，（从uid1到uid2)(add permitted relationship)
	 * @param permission 该被授权联系人的权限
	 * @param uid1 实行该操作的用户
	 * @param uid2 被授权联系人的ID
	 * @return
	 */
	public ReturnType addPerRelationship(ID uid1, ID uid2, Permission permission);

	public ReturnType removePerRelationship(ID uid1, ID uid2);
	
	/**
	 * 建立或修改群组g
	 * @param g
	 * @return
	 */
	public ReturnType setGroup(Group g);
	
	/**
	 * 将用户uid加入群组g中，uid给g的权限为permission
	 * @param g
	 * @param uid
	 * @param permission
	 * @return
	 */
	public ReturnType addToGroup(Group g, ID uid, Permission permission);
	
	public ReturnType removeFromGroup(Group g, ID uid);
	
	public ReturnType removeGroup(Group g);
	
	/**
	 * 把用用户uid的一个未发送到消息（比如申请、邀请、通知等）缓存下来，等待其上线的时候发送。
	 * 该缓存应存入数据库中防止服务器DOWN掉以后数据丢失。
	 * @param uid
	 * @param msg
	 * @return
	 */
	public ReturnType addMessageBuffer(ID uid, Message msg);
	
	/**
	 * 把用用户uid的一个未发送到消息（比如申请、邀请、通知等）从缓存中删除。
	 * @param uid
	 * @param msg
	 * @return
	 */
	public ReturnType removeMessageBuffer(ID uid, Message msg);
	
	public ReturnType getMessageBuffer(ID uid);
	
	/**
	 * 返回uid用户所有同步联系人的ID
	 * @return
	 */
	public ReturnType getSynContactID(ID uid);

	/**
	 * 返回uid用户所有被授权联系人的ID
	 * @param uid
	 * @return
	 */
	public ReturnType getPerContactID(ID uid);
	
	/**
	 * 返回idList中所有ID对应的用户的BaseUserInfo
	 * idList长度为1的时候，就是查询一个用户的BaseUserInfo
	 * @param idList
	 * @return
	 */
	public ReturnType getUsersInfo(ArrayList<ID> idList);
	
	/**
	 * 返回uid到targetIDList中所有ID的授权
	 * 如果uid的被授权联系人中没有定义到targetIDList中某个ID的授权，那么返回一个NullObject。
	 * @param uid
	 * @param targetIDList
	 * @return
	 */
	public ReturnType getPermissions(ID uid, ArrayList<ID> targetIDList);
	
	/**
	 * 设定用户uid1到用户uid2的权限
	 * @param uid1
	 * @param uid2
	 * @return
	 */
	public ReturnType setPermission(ID uid1, ID uid2, Permission permission);
	
	/**
	 * 修改用户uid到群组g的权限
	 * @param uid
	 * @param g
	 * @return
	 */
	public ReturnType setGroupPermission(ID uid, Group g);
	
	/**
	 * 返回用户uid对群组g所定义的权限
	 * @param uid
	 * @param g
	 * @return
	 */
	public ReturnType getGroupPermission(ID uid, Group g);
	
	/**
	 * 返回uid到targetIDList中所有ID的关系可见性
	 * 如果uid的同步联系人中没有定义到targetIDList中某个ID的关系可见性，那么返回一个0。
	 * @param uid
	 * @param targetIDList
	 * @return
	 */
	public ReturnType getVisibilities(ID uid, ArrayList<ID> targetIDList);
	
	/**
	 * 对于搜索的info，返回所有匹配上的用户
	 * @param info
	 * @return
	 */
	public ReturnType searchUser(BaseUserInfo info);
	
	/**
	 * 设定用户uid1到用户uid2的关系可见性
	 * @param uid1
	 * @param uid2
	 * @param visibility
	 * @return
	 */
	public ReturnType setVisiblity(ID uid1, ID uid2, int visibility);
}
