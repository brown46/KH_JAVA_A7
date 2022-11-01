package kr.co.exam01;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Exam {
	public static void lotto(int times) {
		int arr[][] = new int[times][6];
		ArrayList<int[]> aaList = new ArrayList<int[]>();
		for (int i = 0; i < times; i++) {
			ArrayList<Integer> aList = new ArrayList<Integer>();
			while (true) {
				int num = (int) (Math.random() * 45 + 1);
				if (aList.contains(num)) {
					continue;
				}
				aList.add(num);
				if (aList.size() == 6)
					break;
			}
			Collections.sort(aList);

			for (int j = 0; j < 6; j++) {
				arr[i][j] = aList.get(j);
			}
			aaList.add(arr[i]);
		}
		File f = new File("D:\\lotto.txt");
		try (FileWriter fw = new FileWriter(f)) {
			for (int i = 0; i < times; i++) {
				for (int j = 0; j < 6; j++) {
					fw.append((aaList.get(i)[j]) + " ");
				}
				fw.append("\r\n");
			}
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
//	public static void lotto(int times) {
//		for(int i=0; i<times;i++) {
//			ArrayList<Integer> aList = new ArrayList<Integer>();
//			while (true) {
//				int num = (int) (Math.random() * 45 + 1);
//				if (aList.contains(num)) {
//					continue;
//				}
//				aList.add(num);
//				if (aList.size() == 6)
//					break;
//			}
//			Collections.sort(aList);
//			System.out.println(aList);
//	
//			File f = new File("D:\\lotto.txt");
//			try (FileWriter fw = new FileWriter(f, true)) {
//				fw.append(aList.toString() + "\n");
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//	}

	public static ArrayList<Integer> getLottoNumber(){
		ArrayList<Integer> numbers =new ArrayList<Integer>();
		Random rand = new Random();
		while(numbers.size()<6) {
			int num =rand.nextInt(45)+1;
		
			Integer i = Integer.valueOf(num);
			if(!numbers.contains(i))
				numbers.add(i);
		}
		
		Collections.sort(numbers);
		System.out.println(numbers);
		return numbers;
	}
	public static void main(String[] args) {
		/*
		 * 로또 번호 생성 -1~45 까지의 랜덤 번호를 생성하여 리스트에 담는다. 
		 * -중복된 값없이 리스트에 담도록 한다. 
		 * -총 6개의 정수값이 리스트에 저장될 수 있도록 한다.
		 * -마지막에 출력할 때 오름차순으로 정렬이 될 수 있도록 한다.
		 */

		/*
		 * 위에서 생성한 로또 번호 6개를 1셋트라고 하자.
		 * 
		 * 1. 사용자가 원하는 수의 셋트로 로또번호가 생성되어 파일에 저장 될 수 있도록한다. 
		 * 2. 저장할 때 D:\\ 에 lotto.txt파일로 저장되도록 한다. 
		 * 3. 한 줄에 1셋트의 번호가 출력되어야 한다.
		 */
		
		ArrayList<Integer> numbers =getLottoNumber();
		
		File f = new File("D:\\lotto.txt");
		
		try(BufferedWriter bw =new BufferedWriter(new FileWriter(f))){
			int setCount =6;
			for(int i =0 ;i<setCount;i++) {
				numbers =getLottoNumber();
				String[] sArr = new String[numbers.size()];
				for(int n= 0; n<sArr.length;n++) {
					sArr[n] =numbers.get(n).toString();
				}
				bw.write(String.join(",",sArr));
				bw.newLine();
			}
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		//lotto(12);
	}

}
