package ch12_interface.Example_message;

public interface MessageService {
	
	int DELETED = 1;
	
	Message findByMid(int mid);
	void messageList();
	void messsageListByWriter(String writer);
	void insertMessage(Message message);
	void updateMessage(Message message);
	void deleteMessage(int mid);
}
