package ch18_io.sec11_Message;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class MessageMain {

	private static Scanner scan = new Scanner(System.in);
	private static MessageService messageService = new MessageServiceFileImpl();
	
	public static void main(String[] args) {
		List<Message> list = null;
		String writer = null, content = null;
		Message message = null;
		int mid = 0;
		
		boolean run = true;
		
		while (run) {
			System.out.println("─────────────────────────────────────────────────────────────────");
			System.out.println("1. 메시지 찾기(메시지번호)");
			System.out.println("2. 메시지 목록");
			System.out.println("3. 특정 인물의 메시지 목록");
			System.out.println("4. 메시지 추가");
			System.out.println("5. 메시지 수정");
			System.out.println("6. 메시지 삭제");
			System.out.println("7. 종료");
			System.out.println("─────────────────────────────────────────────────────────────────");
			System.out.print("선택: ");
			
			int selectNo = scan.nextInt();
			scan.nextLine();
			
			if (selectNo == 1) {
				System.out.print("찾을 메시지 번호 입력: ");
				mid = Integer.parseInt(scan.nextLine());
				
				Message message_ = messageService.findByMid(mid);
				
				if (message_ == null)
				{
					System.out.println("없는 메시지입니다.");
				}
				else
				{
					System.out.println("====================================");
					System.out.println("메세지 번호: " + message_.getMid());
					System.out.println("작성 시간: " + message_.getModTime());
					System.out.println("작성자: " + message_.getWriter());
					System.out.println("------------------------------------");
					System.out.println("메세지 내용▽");
					System.out.println(message_.getContent());
					System.out.println("====================================");
				}
			}
			else if (selectNo == 2)
			{
				List<Message> ms = messageService.getMessageListAll();
				
				printMessage(ms);
			}
			else if (selectNo == 3)
			{
				System.out.print("찾을 작성자 입력: ");
				writer = scan.nextLine();
				
				List<Message> ms = messageService.getMessageListByWriter(writer);
				
				printMessage(ms);
			}
			else if (selectNo == 4)
			{
				System.out.println("====================================");
				System.out.print("발신자: ");
				writer = scan.nextLine();
				System.out.println("메세지 작성▽");
				System.out.println("------------------------------------");
				content = scan.nextLine();
				System.out.println("====================================");
				
				LocalDateTime timenow = LocalDateTime.now();
				Message message_ = new Message(content, writer, timenow);
				
				messageService.insertMessage(message_);
			}
			else if (selectNo == 5)
			{
				System.out.print("찾을 메시지 번호 입력: ");
				mid = Integer.parseInt(scan.nextLine());
				Message message_ = messageService.findByMid(mid);
				
				if (message_ == null)
				{
					System.out.println("없는 메시지입니다.");
				}
				else
				{
					System.out.println("====================================");
					System.out.println("신규 번호▽ (기존: " + mid + ")");
					System.out.println("------------------------------------");
					int mid2 = Integer.parseInt(scan.nextLine());		
					System.out.println("====================================");
					System.out.println("기존 메시지▽");
					System.out.println("------------------------------------");
					System.out.println(message_.getContent());
					System.out.println("====================================");
					System.out.println("신규 메시지 작성▽");
					System.out.println("------------------------------------");
					content = scan.nextLine();
					System.out.println("====================================");
					
					messageService.deleteMessage(mid);
					
					message_.setMid(mid2);
					message_.setModTime(LocalDateTime.now());
					message_.setContent(content);
					
					messageService.updateMessage(message_);
				}
			}
			else if (selectNo == 6)
			{
				System.out.print("삭제할 메시지 번호 입력: ");
				mid = Integer.parseInt(scan.nextLine());
				
				messageService.deleteMessage(mid);
			}
			else
			{
				run = false;
				messageService.close();
				System.out.println("프로그램 종료");
				scan.close();
			}
		}
	}
	
	public static void printMessage(List<Message> message_)
	{
		for (Message m: message_)
		{
			System.out.println("====================================");
			System.out.println("메세지 번호: " + m.getMid());
			System.out.println("작성 시간: " + m.getModTime());
			System.out.println("작성자: " + m.getWriter());
			System.out.println("------------------------------------");
			System.out.println("메세지 내용▽");
			System.out.println(m.getContent());
			System.out.println("====================================");
		}
	}

}
