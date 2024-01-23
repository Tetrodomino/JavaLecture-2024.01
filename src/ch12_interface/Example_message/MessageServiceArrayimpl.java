package ch12_interface.Example_message;

import java.time.LocalDateTime;
import java.util.Scanner;

public class MessageServiceArrayimpl implements MessageService {
	
	private static Scanner scan = new Scanner(System.in);
	private static Message[] message = new Message[100];
	
	public MessageServiceArrayimpl() {
		message[0] = new Message(0, "안녕하세요 반갑습니다", "James", LocalDateTime.of(2022, 5, 1, 12, 10, 10));
		message[1] = new Message(1, "오늘 날씨는 어때요", "James", LocalDateTime.of(2022, 6, 12, 5,	5, 7));
		message[2] = new Message(2, "2023년이 밝았네요", "Maria", LocalDateTime.of(2023, 1, 1, 12, 6, 13));
	}

	@Override
	public Message findByMid(int mid) {
		for (int i = 0; i < message.length; i++)
		{
			if (message[i] == null)
				continue;
			
			if (message[i].getMid() == mid && message[i].getIsDeleted() != MessageService.DELETED)
				return message[i];
		}
		return null;
	}

	@Override
	public void messageList() {
		for (int i = 0; i < message.length; i++)
		{
			if (message[i] == null)
				continue;
			
			else if (message[i].getIsDeleted() != MessageService.DELETED)
			{
				System.out.println("====================================");
				System.out.println("메세지 번호: " + message[i].getMid());
				System.out.println("작성 시간: " + message[i].getGenTime());
				System.out.println("작성자: " + message[i].getWriter());
				System.out.println("------------------------------------");
				System.out.println("메세지 내용▽");
				System.out.println(message[i].getContent());
				System.out.println("====================================");
			}
		}
	}

	@Override
	public void messsageListByWriter(String writer) {
		
		int count = 0;
		
		for (int i = 0; i < message.length; i++)
		{
			if (message[i] == null)
				continue;
			
			if (message[i].getIsDeleted() != MessageService.DELETED && message[i].getWriter().equals(writer))
			{
				System.out.println("====================================");
				System.out.println("메세지 번호: " + message[i].getMid());
				System.out.println("작성 시간: " + message[i].getGenTime());
				System.out.println("작성자: " + message[i].getWriter());
				System.out.println("------------------------------------");
				System.out.println("메세지 내용▽");
				System.out.println(message[i].getContent());
				System.out.println("====================================");
				count++;
			}
		}
		
		if (count <= 0)
			System.out.println("찾는 작성자의 메시지가 없습니다.");
		
	}

	@Override
	public void insertMessage(Message message_) {
//		System.out.println("====================================");
//		System.out.print("발신자: ");
//		String writer = scan.nextLine();
//		System.out.println("메세지 작성▽");
//		System.out.println("------------------------------------");
//		String content = scan.nextLine();
//		System.out.println("====================================");
		
		for (int i = 0; i < message.length; i++)
		{
			if (message[i] != null)
				continue;
			else
			{	
				message_.setMid(i);
				message[i] = message_;
				break;
			}
		}
	}

	@Override
	public void updateMessage(Message message_) {
		System.out.println("====================================");
		System.out.println("기존 메시지▽");
		System.out.println("------------------------------------");
		System.out.println(message_.getContent());
		System.out.println("====================================");
		System.out.println("신규 메시지 작성▽");
		System.out.println("------------------------------------");
		String content = scan.nextLine();
		System.out.println("====================================");
		
		message_.setContent(content);
		message_.setGenTime(LocalDateTime.now());

		System.out.println("메시지 수정 완료");
	}

	@Override
	public void deleteMessage(int mid) {
		Message message_ = findByMid(mid);
		
		if (message_ == null || message_.getIsDeleted() == MessageService.DELETED)
		{
			System.out.println("해당되는 id의 메시지가 없습니다");
			return;
		}
			
		message_.setIsDeleted(MessageService.DELETED);
		System.out.println("메시지 삭제 완료");
	}

}
