package model.service;

import model.dao.UserDAO;
import model.dto.UserDTO;

public class UserService {

	public int add(UserDTO dto) {
		UserDAO dao = new UserDAO();
		
		
		UserDTO data=dao.selectUser(dto);//데이터가 없으면 null이 저장됨
		
		if(data ==null) {		
			int count = dao.insert(dto);
			if(count==1) {
				dao.commit(); dao.close();
				return 1;
			}
			dao.rollback(); dao.close();
			return -1;
		}
		dao.close();
		return -2;  //아이디가 중복일시
		
	}
	
}
