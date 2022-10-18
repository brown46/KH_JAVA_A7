package kr.co.exam03;

import java.util.Arrays;

public class FoodMenu {

//	private String foodN[] = new String[0];
	private String foodN[] = {"김밥"};
//	private int foodC[] =new int[0];
	private int foodC[] = {4000};

	public void getMenu() {
		for (int i = 0; i < foodN.length; i++) {
			//System.out.println(foodN[i] + ": " + foodC[i] + "원");
			System.out.printf("%s\t%,d원\n",foodN[i],foodC[i]);
		}
	}
//	public String getMenu() {
//		String res="";
//		for(int i=0;i<foodN.length;i++) {
//			res+=String.format("%s\t%,d원\n",foodN[i],foodC[i]);
//		}
//		return res;
//	}

	public void findFood(String food) {
		for (int i = 0; i < foodN.length; i++)
			if (food.equals(foodN[i])) {
				System.out.println(foodC[i] + "원");
			}
	}

	public void addFood(String food, int cost) {
		for (int i = 0; i < foodN.length; i++) {//중복입력 방지
			if (food.equals(foodN[i])) {
				System.out.println("중복입력");
				return;
			}
		}
		foodN = Arrays.copyOf(foodN, foodN.length + 1);
		foodN[foodN.length - 1] = food;
		foodC = Arrays.copyOf(foodC, foodC.length + 1);
		foodC[foodC.length - 1] = cost;
	}

	public void modFood(String food, int cost) {
		for (int i = 0; i < foodN.length; i++)
			if (food.equals(foodN[i])) {
				foodC[i] = cost;
			}
	}

//	public void delFood(String food) {
//		for (int i = 0; i < foodN.length; i++)
//			if (food.equals(foodN[i])) {
//				foodC[i]=0;
//				foodN[i]="삭제됨";
//			}
//	}
	public void delFood(String food) {
		for (int i = 0; i < foodN.length; i++) {
			if (food.equals(foodN[i])) {
				for (int j = i; j < foodN.length - 1; j++) {
					foodN[j] = foodN[j + 1];
					foodC[j] = foodC[j + 1];
				}
				foodN = Arrays.copyOf(foodN, foodN.length - 1);
				foodC = Arrays.copyOf(foodC, foodC.length - 1);
				break;
			}
		}
	}

}
