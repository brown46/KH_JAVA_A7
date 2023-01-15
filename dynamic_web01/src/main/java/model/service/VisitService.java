package model.service;


import java.util.List;

import model.dao.VisitDAO;
import model.dto.VisitDTO;

public class VisitService {

	public boolean add(VisitDTO data) {
		VisitDAO dao= new VisitDAO();
		int result=dao.insert(data);
		if(result==1) {
			return true;
		}
		return false;	
	}

	public List<VisitDTO> getList() {
		VisitDAO dao = new VisitDAO();
		List<VisitDTO> dataList =dao.select();
		return dataList;
	}

	public boolean delete(VisitDTO dto) {
		VisitDAO dao = new VisitDAO();
		int count= dao.delete(dto);
		if(count==1) {
			dao.commit();
			dao.close();
			return true;
		}
		dao.rollback();
		dao.close();	
		return false;
	}

	public VisitDTO get(VisitDTO dto) {
		VisitDAO dao = new VisitDAO();
		VisitDTO data=new VisitDTO();
		data=dao.select(dto);

		return data;
	
	}

	public boolean update(VisitDTO dto) {
		VisitDAO dao =new VisitDAO();
		int count= dao.update(dto);
		if(count==1) {
			dao.commit();
			dao.close();
			return true;
		}
		dao.rollback();
		dao.close();	
		return false;	
	}
}
