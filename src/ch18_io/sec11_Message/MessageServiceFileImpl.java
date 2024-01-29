package ch18_io.sec11_Message;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MessageServiceFileImpl implements MessageService{
	
	private List<Message> list = new ArrayList<Message>();
	private int index = 101;
	private String saveFilename = "C:/Temp/message.ser";
	
	public MessageServiceFileImpl()
	{
		File saveFile = new File(saveFilename);
		
		if (saveFile.exists()) {
			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(saveFile));
				list = (List<Message>) ois.readObject();
				index += list.size();
				Message msg = list.get(list.size() - 1);
				index = msg.getMid() + 1;
				ois.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else {
			list.add(new Message(index++, "안녕하세요 반갑습니다", "James", LocalDateTime.of(2022, 5, 1, 12, 10, 10), 0));
			list.add(new Message(index++, "오늘 날씨는 어때요", "James", LocalDateTime.of(2022, 6, 12, 5,	5, 7), 0));
			list.add(new Message(index++, "2023년이 밝았네요", "Maria", LocalDateTime.of(2023, 1, 1, 12, 6, 13), 0));
		}
	}

	@Override
	public Message findByMid(int mid) {
		for (Message m: list)
		{
			if (m.getMid() == mid)
				return m;
		}
		
		return null;
	}

	@Override
	public List<Message> getMessageListAll() {
		List<Message> mes = new ArrayList<>();
		
		for (Message m: list)
		{
			if (m.getIsDeleted() != MessageService.DELETED)
				mes.add(m);
		}
		
		return mes;
	}

	@Override
	public List<Message> getMessageListByWriter(String writer) {
		List<Message> mes = new ArrayList<>();
		
		for (Message m: list)
		{
			if (m.getIsDeleted() != MessageService.DELETED && m.getWriter().equals(writer))
				mes.add(m);
		}
		
		return mes;
	}

	@Override
	public void insertMessage(Message message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateMessage(Message message_) {
		
		int count2 = 0;
		for (Message m: list)
		{
			if (m.getMid() >= message_.getMid())
			{	
				list.add(count2, message_);
				return;
			}
			
			count2++;
		}
		list.add(message_);
	}

	@Override
	public void deleteMessage(int mid) {
		list.remove(findByMid(mid));
	}

	public void close() {
		try {			
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(saveFilename));
			oos.writeObject(list);
			oos.flush();
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
