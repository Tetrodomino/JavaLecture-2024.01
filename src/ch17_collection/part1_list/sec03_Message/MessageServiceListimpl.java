package ch17_collection.part1_list.sec03_Message;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MessageServiceListimpl implements MessageService{
	List<Message> message = new ArrayList<Message>();
	
	public MessageServiceListimpl() {
		Message m1 = new Message(0, "안녕하세요 반갑습니다", "James", LocalDateTime.of(2022, 5, 1, 12, 10, 10), 0);
		Message m2 = new Message(1, "오늘 날씨는 어때요", "James", LocalDateTime.of(2022, 6, 12, 5,	5, 7), 0);
		Message m3 = new Message(2, "2023년이 밝았네요", "Maria", LocalDateTime.of(2023, 1, 1, 12, 6, 13), 0);
		
		message.add(m1);
		message.add(m2);
		message.add(m3);
	}

	@Override
	public Message findByMid(int mid) {
		for (Message m: message)
		{
			if (m.getMid() == mid)
				return m;
		}
		
		return null;
	}

	@Override
	public List<Message> getMessageListAll() {
		List<Message> mes = new ArrayList<>();
		
		for (Message m: message)
		{
			if (m.getIsDeleted() != MessageService.DELETED)
				mes.add(m);
		}
		
		return mes;
	}

	@Override
	public List<Message> getMessageListByWriter(String writer) {
		List<Message> mes = new ArrayList<>();
		
		for (Message m: message)
		{
			if (m.getIsDeleted() != MessageService.DELETED && m.getWriter().equals(writer))
				mes.add(m);
		}
		
		return mes;
	}

	@Override
	public void insertMessage(Message message_) {
		int index = message.size();
		Message Lastmessage = message.get(index - 1);
		message_.setMid(Lastmessage.getMid() + 1);
		
		message.add(message_);
	}

	@Override
	public void updateMessage(Message message_) {
		
		int count2 = 0;
		for (Message m: message)
		{
			if (m.getMid() >= message_.getMid())
			{	
				message.add(count2, message_);
				return;
			}
			
			count2++;
		}
		message.add(message_);
	}

	@Override
	public void deleteMessage(int mid) {
		message.remove(findByMid(mid));
	}
}
