package ch12_interface.sec04_dao;

import java.util.List;

//DAO(Data Access Object) - DB를 액세스하기 위한 코드
//DTO(Data Transfer Object), VO(Value Object) - DB를 액세스 할 때 사용되는 데이터 구조
public interface CustomerDao {

	// DB의 5가지 기본 메소드
	Customer getCustomer(int cid);
	
	List<Customer> getCustomerList();
	
	void insertCustomer(Customer customer);
	
	void updateCustomer(Customer customer);
	
	void deleteCustomer(int cid);
}
