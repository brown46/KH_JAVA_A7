package kr.co.demo01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;



public class Demo {

	public static void main(String[] args) {
		/*
		 * 컬렉션 
		 * 	  - 자바에서 제공하는 자료 구조를 담당하는 프레임 워크
		 * 	  - 배열에 데이터를 담아 관리하는 방법에서 좀 더 편하게 데이터를 
		 * 		추가/수정/삭제 할 수 있는 방법을 제공 
		 * 	  - 구현된 자료 구조 종류에 따라 List, Set, Map 으로 분류하여 제공
		 * 
		 * 배열 VS 컬렉션
		 * 	  배열 특징
		 * 	  	- 한 번 크기를 정하면 변경할 수 없다.
		 * 	  	- 배열에 저장된 데이터의 추가 / 수정이 불편하다.
		 * 	  	- 한 가지 타입에 대해서만 저장 할 수 있다.
		 * 	  컬렉션 특징
		 * 		- 언제든 크기를 늘리거나 줄일 수 있다.
		 * 		- 컬렉션에 저장된 데이터의 추가 / 수정 / 삭제 등의 작업이
		 * 		  컬렉션에서 제공하는 메서드에 의해 처리 된다.
		 * 		- 여러 타입에 대한 데이터 저장이 가능하다.
		 */

		/*
		 *  List 컬렉션 
		 *  	- 데이터를 순차적으로 나열한 자료 구조로 인덱스로 관리한다.
		 *  	- 중복 데이터 저장이 가능하다.
		 *  	- 구현 클래스로 ArrayList, Vector, LinkedList가 있다.
		 *  
		 *  ArrayList
		 *  	- List의 구현체로 초기 저장 용량 10 에서 데이터가 추가/삭제
		 *  	  될 때마다 자동으로 늘어나면서 데이터를 관리한다.
		 *  	- Thread Safe 기능을 제공하지 않는다.
		 *  
		 *  Vector 
		 *  	- List의 구현체로 ArrayList와 동일하며, Thread Safe 기능을
		 *  	  제공한다.
		 *  
		 *  LinkedList 
		 *  	- List의 구현체로 특정 위치에서 객체를 추가하거나 제거를 하면 앞/뒤 
		 *  	  노드의 링크 정보만 변경하는 형태로 동작하기 때문에 빈번한 데이터 추가 
		 *  	  삭제 작업이 이루어지는 경우 성능이 가장 우수한 컬렉션이다. 
		 */
		ArrayList<Integer> aList = new ArrayList<Integer>();
//		 <> <- 컬렉션으로 관리할 데이터 타입을 작성
//		       (제네렉 타입)
		
		//데이터 추가 : 가장 마지막 순서에 추가.
		aList.add(10); aList.add(20); aList.add(30);
		aList.add(50); aList.add(60); aList.add(70);
		System.out.println("add "+aList);
		
		//데이터 추가 : 원하는 위치에 추가
		aList.add(1,40);
		System.out.println("add "+aList);
		
		//데이터 변경 : 지정한 위치의 데이터 변경
		aList.set(2, 25);
		System.out.println("add "+aList);
		
		// 데이터 삭제 : 지정한 위치의 데이터 삭제 
		aList.remove(2);
		System.out.println("remove "+aList);
		
		//데이터 삭제 : 지정한 객체와 동일한 데이터 삭제
		aList.remove(Integer.valueOf(40));
		System.out.println("remove "+aList);
		
		//데이터 검색 : 지정한 위치의 데이터 반환 
		Integer i =aList.get(2);
		System.out.println("get "+i+" | "+aList);
		
		//데이터 검색 : 지정한 객체와 동일한 객체가 있는지 검사 
		boolean isExist = aList.contains(Integer.valueOf(60));
		System.out.println("contains "+isExist+" | "+ aList);
		
		//데이터 검색 : 지정한 객체와 동일한 객체의 위치 반환
		int index =aList.indexOf(Integer.valueOf(60));
		System.out.println("indexOf "+index +" | "+aList);
		
		//저장된 데이터 수 확인 
		int size = aList.size();
		System.out.println("size "+size+" | "+ aList);
		
		//데이터 추가 : 컬레션에 컬렉션 데이터 추가
		ArrayList<Integer> bList = new ArrayList<Integer>();
		bList.add(100); bList.add(200); bList.add(300);
		
		aList.addAll(bList);
		System.out.println("addAll "+aList);
		
		//데이터 전부 삭제 : 전부 삭제
		bList.clear();
		System.out.println("clear "+bList);
		
		//데이터 존재 유무 확인 
		boolean isEmpty = aList.isEmpty();
		System.out.println("isEmpty "+isEmpty +" | "+ aList);
	
		isEmpty = bList.isEmpty();
		System.out.println("isEmpty "+isEmpty +" | "+ bList);
		
		//전체 탐색
		for(int n=0; n<aList.size();n++) {
			System.out.print(aList.get(n)+" ");
		}
		System.out.println();
		
		//for each 형태로 전체 탐색
		//접근은 가능하지만 수정은 할 수 없다.
		for(Integer n: aList) {
			System.out.print(n+" ");
		}
		System.out.println();
		
		//리스트를 분리하여 새로운 리스트로 반환
		ArrayList<Integer> subList = new ArrayList<Integer>(aList.subList(2,5));
		System.out.println("subList "+subList);
		
		//리스트를 Object 배열로 반환
		Object[] obj = aList.toArray();
		System.out.println("obj "+Arrays.toString(obj));
		
		//리스트를 제공한 정수 배열로 반환
		Integer iArr[]= new Integer[aList.size()];
		iArr = aList.toArray(iArr);
		System.out.println(Arrays.toString(iArr));
		
		//정렬 - reverse
		Collections.reverse(aList);
		System.out.println("reverse "+aList);
		
		//정렬 - sort(오름차순)
		Collections.sort(aList);
		System.out.println("sort "+aList);
		
		//정렬 - sort 후 reverse 하면 내림차순
		Collections.sort(aList);
		Collections.reverse(aList);
		System.out.println(aList);
		
		// 직접 정렬 위한 로직 구현
		Collections.sort(aList, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				
				if (o1>o2) return 1; //양수를 반환하면 오름차순, 음수를 반환하면 내름차순
				else if(o1<o2) return -1;
				return 0;
			}
		});
		
		System.out.println("sort "+aList);
		
		ArrayList<Subject> sList = new ArrayList<Subject>();
		sList.add(new Subject("영어",88.5));
		sList.add(new Subject("국어",94.2));
		sList.add(new Subject("수학",89.3));
		sList.add(new Subject("과학",78.1));
		
		System.out.println(sList);
		System.out.println();
		
		Collections.sort(sList);
		Collections.reverse(sList);
		System.out.println(sList);
		
//		Collections.sort(sList,new Comparator<Subject>() {
//
//			@Override
//			public int compare(Subject o1, Subject o2) {
//				if (o1.getScore()>o2.getScore()) return 1; //양수를 반환하면 오름차순, 음수를 반환하면 내름차순
//				else if(o1.getScore()<o2.getScore()) return -1;
//				return 0;
//			}
//		}); Subject 클래스에서 작성함
	}

}
