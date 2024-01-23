package ch12_interface.Example_message;

import java.time.LocalDateTime;
import java.util.Scanner;

public class MessageMain {
	private static Scanner scan = new Scanner(System.in);
	private static MessageService messageService = new MessageServiceArrayimpl();
	
	public static void main(String[] args) {
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
				int mid = Integer.parseInt(scan.nextLine());
				
				Message message_ = messageService.findByMid(mid);
				
				if (message_ == null)
				{
					System.out.println("없는 메시지입니다.");
				}
				else
				{
					System.out.println("====================================");
					System.out.println("메세지 번호: " + message_.getMid());
					System.out.println("작성 시간: " + message_.getGenTime());
					System.out.println("작성자: " + message_.getWriter());
					System.out.println("------------------------------------");
					System.out.println("메세지 내용▽");
					System.out.println(message_.getContent());
					System.out.println("====================================");
				}
			}
			else if (selectNo == 2)
			{
				messageService.messageList();
			}
			else if (selectNo == 3)
			{
				System.out.print("찾을 작성자 입력: ");
				String writer = scan.nextLine();
				
				messageService.messsageListByWriter(writer);
			}
			else if (selectNo == 4)
			{
				System.out.println("====================================");
				System.out.print("발신자: ");
				String writer = scan.nextLine();
				System.out.println("메세지 작성▽");
				System.out.println("------------------------------------");
				String content = scan.nextLine();
				System.out.println("====================================");
				
				LocalDateTime timenow = LocalDateTime.now();
				Message message_ = new Message(content, writer, timenow);
				
				messageService.insertMessage(message_);
			}
			else if (selectNo == 5)
			{
				System.out.print("찾을 메시지 번호 입력: ");
				int mid = Integer.parseInt(scan.nextLine());
				
				Message message_ = messageService.findByMid(mid);
				
				if (message_ == null)
				{
					System.out.println("없는 메시지입니다.");
				}
				else
				{
					messageService.updateMessage(message_);
				}
			}
			else if (selectNo == 6)
			{
				System.out.print("삭제할 메시지 번호 입력: ");
				int mid = Integer.parseInt(scan.nextLine());
				
				messageService.deleteMessage(mid);
			}
			else
			{
				run = false;
				System.out.println("프로그램 종료");
			}
		}
	}
}
