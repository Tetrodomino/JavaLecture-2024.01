package mysql.sec05_message;

import java.util.List;

public class MessageServiceMysqlImpl implements MessageService{
	
	private MessageDao msgDao = new MessageDao();
	

	@Override
	public Message findByMid(int mid) {
		Message m = msgDao.getMessageByMid(mid);
		return m;
	}

	@Override
	public List<Message> getMessageListAll() {
		List<Message> list = msgDao.getMessageByWriter("%"); // 미정 문자를 넣어서 전체를 리턴
		return list;
	}

	@Override
	public List<Message> getMessageListByWriter(String writer) {
		List<Message> list = msgDao.getMessageByWriter("%" + writer + "%");
		return list;
	}

	@Override
	public void insertMessage(Message message) {
		msgDao.insertMessage(message);
	}

	@Override
	public void updateMessage(Message message) {
		msgDao.updateMessage(message);
	}

	@Override
	public void deleteMessage(int mid) {
		msgDao.deleteMessage(mid);
	}

}
