package kh.spring.s02.common.file;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public class FileUtil {

	private static final String UPLOAD_FOLDER ="\\resources\\uploadfiles";
	
	
	
	/**
	 * 
	 * @param multi
	 * @param request
	 * @return : map - "original" :original file path,"rename": saved file path
	 */
	public Map<String, String> saveFile(MultipartFile multi, HttpServletRequest request,String addedPath)throws Exception {
		Map<String, String> result =null; 
		
		String renameFilePath=null;
		if(multi!=null&& !multi.equals("")) {
			String originalFileName = multi.getOriginalFilename();
			String webServerRoot= request.getSession().getServletContext().getRealPath("");
			System.out.println(webServerRoot);
			
			String savePath = webServerRoot+UPLOAD_FOLDER;
			if(addedPath!=null) {
				savePath+=addedPath;
			}
			File folder = new File(savePath);
			if(!folder.exists()) {
				folder.mkdirs();
			}
			
			String renameByTime =System.currentTimeMillis()+"_"+multi.getOriginalFilename();
//			String renameByUUID= UUID.randomUUID().toString()+"_"+multi.getOriginalFilename();
			
			renameFilePath= savePath+"\\"+renameByTime;
			
			multi.transferTo(new File(renameFilePath));
	
			result.put("original", originalFileName);
			result.put("rename", renameByTime);
		}
		return result;
	}
	public List<Map<String, String>> saveFileList(MultipartHttpServletRequest multiReq, HttpServletRequest request, String addedPath) throws Exception {
		List<Map<String, String>> result =new ArrayList<Map<String,String>>();
		
		Iterator<String> iterator = multiReq.getFileNames();//Name: <input name="n1" type="file">
		while(iterator.hasNext()) {
			String name = iterator.next();//"n1"
			MultipartFile multiFile = multiReq.getFile(name);
			Map<String, String> map = new HashMap<String, String>();
			map =  saveFile(multiFile, request, addedPath);
			result.add(map);
		}
	
		return result;
	}
}
