package model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.dao.BookmarkDAO;
import model.dto.BookmarkDTO;
import model.dto.VisitDTO;

public class BookmarkService {

	public List<BookmarkDTO> getAll() {
		BookmarkDAO dao = new BookmarkDAO();
		List<BookmarkDTO> data = dao.selectAll();
		return data;
	}
	
public List<BookmarkDTO> getAllById(BookmarkDTO dto) {
		BookmarkDAO dao = new BookmarkDAO();
		List<BookmarkDTO> data =dao.selectAllById(dto);
		return data;
	}

	public boolean add(BookmarkDTO dto) {
		BookmarkDAO dao = new BookmarkDAO();
		int id= dao.getNextId();
		dto.setId(id);
		int rowCount= dao.insert(dto);
		if(rowCount==1) {
			dao.commit();
			dao.close();
			return true;
		}
//		dao.rollback();
		dao.close();
		return false;
	}

	public BookmarkDTO get(BookmarkDTO dto) {
		BookmarkDAO dao = new BookmarkDAO();
		BookmarkDTO data= dao.selectId(dto);
		return data;	
	}

	public boolean update(BookmarkDTO dto) {
		BookmarkDAO dao= new BookmarkDAO();
		int count = dao.update(dto);
		if(count==1) {
			dao.commit();
			dao.close();
			return true;
		}
		dao.rollback();
		dao.close();
		return false;
	}

	public boolean remove(BookmarkDTO dto) {
		BookmarkDAO dao =new BookmarkDAO();
		int count =dao.delete(dto);
		if(count==1) {
			dao.commit();
			dao.close();
			return true;
		}
		dao.rollback();
		dao.close();
		return false;
	}

	public int getAllPages(BookmarkDTO dto) {
		BookmarkDAO dao = new BookmarkDAO();
		int pages=0;
		int rowNum= dao.getRowNum(dto);
		if(rowNum==0) {
			pages=1;
		}else if(rowNum%10==0) {
			pages= rowNum/10;
		}else {			
			pages= rowNum/10+1;
		}
		return pages;
	}

	public List<BookmarkDTO> getPage(BookmarkDTO bdto) {
		BookmarkDAO dao = new BookmarkDAO();
		Map<String , Object> page = new HashMap<String, Object>() ;
		
		page.put("userId", bdto.getUserId());
		page.put("start", 1);
		page.put("end", 10);
		
		List<BookmarkDTO> data = dao.getPage(page);
		
		return data;
	}

	


}
