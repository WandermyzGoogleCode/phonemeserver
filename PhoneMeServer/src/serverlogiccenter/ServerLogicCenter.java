package serverlogiccenter;

import entity.ID;
import entity.message.Message;

import java.rmi.Remote;
import java.util.List;

public interface ServerLogicCenter extends Remote {
	/**
	 * �����û�user����δ�������Ϣ
	 * @param user
	 * @return
	 */
	public List<Message> getAllMessages(ID user);
	/**
	 * �����û�user���¸��µ���Ϣ
	 * @param user
	 * @return
	 */
	public Message getNewMessage(ID user);
}
