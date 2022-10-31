package kr.co.demo02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Demo {

	public static void main(String[] args) {
		/*
		 * FileInputStream 클래스 
		 * 		- 바이트 기반 스트림으로 바이트 단위로 파일을 읽는다. 
		 * 
		 */
		File f = new File("D:\\입출력테스트.txt");
		//try ~ with ~ resource 구문 - 자동으로 close()해준다.
		//AutoCloseable 이 상속되어야함.
		try (FileInputStream fis = new FileInputStream(f)){
			byte[] bArr = new byte[(int) f.length()];
			byte[] buffer = new byte[8];
			
			int idx =0;
			while(true) {
				int readBytes = fis.read(buffer);//buffer에 읽은만큼 저장
				if(readBytes ==-1) break;
				System.arraycopy(buffer, 0, bArr, idx, readBytes);
				idx +=readBytes;
			}
			
			System.out.println(new String(bArr));
			
		} catch (FileNotFoundException e) {
			System.out.println(f.getPath()+" 경로에 파일이 존재하지 않습니다.");
		} catch (IOException e) {
			System.out.println("파일을 읽는 과정에서 문제가 발생했습니다.");
			e.printStackTrace();
		}
	}

}
