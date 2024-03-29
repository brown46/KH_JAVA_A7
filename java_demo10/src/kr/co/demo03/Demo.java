package kr.co.demo03;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Demo {

	public static void main(String[] args) {
		/*
		 * FileReader
		 * 		- 문자기반 스트림으로 문자 단위로 파일을 읽는다.
		 */
		File f = new File("D:\\입출력테스트.txt");
		
		try(FileReader fr = new FileReader(f)){
			
			char[] cArr = new char[0];
			char[] buffer = new char[8];
			
			while(true) {
				int readChars=	fr.read(buffer);
				System.out.println(buffer);
				System.out.println();
				if(readChars==-1)break;
				cArr =Arrays.copyOf(cArr, cArr.length+readChars);
				//System.out.println(cArr);
				System.arraycopy(buffer, 0, cArr, cArr.length-readChars, readChars);
				//System.out.println(buffer);
			}
			//System.out.println(cArr);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	
			
		
	}

}
