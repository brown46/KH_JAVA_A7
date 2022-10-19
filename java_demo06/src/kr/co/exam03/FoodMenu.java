package kr.co.exam03;

import java.util.Arrays;

public class FoodMenu {

////	private String foodN[] = new String[0];
//	private String foodN[] = {"김밥"};
////	private int foodC[] =new int[0];
//	private int foodC[] = {4000};
	
	private Food food[] =new Food[0];  //객체 배열

	public void getMenu() {
		for (int i = 0; i < food.length; i++) {
			//System.out.println(foodN[i] + ": " + foodC[i] + "원");
			System.out.printf("%s\t%,d원\n",food[i].name,food[i].price);
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
		for (int i = 0; i <this.food.length; i++)
			if (food.equals(this.food[i].name)) {
				System.out.println(this.food[i].price + "원");
			}
	}

	public void addFood(String food, int cost) {
		for (int i = 0; i < this.food.length; i++) {//중복입력 방지
			if (food.equals(this.food[i].name)) {
				System.out.println("중복입력");
				return;
			}
		}
		this.food = Arrays.copyOf(this.food, this.food.length + 1);
		this.food[this.food.length - 1] =new Food(food,cost);
	}

	public void modFood(String food, int cost) {
		for (int i = 0; i < this.food.length; i++)
			if (food.equals(this.food[i].name)) {
				this.food[i].price = cost;
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
		for (int i = 0; i < this.food.length; i++) {
			if (food.equals(this.food[i].name)) {
				for (int j = i; j < this.food.length - 1; j++) {
					this.food[j].name = this.food[j + 1].name;
					this.food[j].price = this.food[j+1].price;
				}
				this.food = Arrays.copyOf(this.food, this.food.length - 1);

				break;
			}
		}
	}
	
	private int findIndex(String name) {
		// 메뉴를 찾아서 찾은 메뉴의 위치(Index)를 반환하기 위한 메서드
		int idx = -1;
		for(int i = 0; i < this.food.length; i++) {
			if(this.food[i].equals(name)) {
				idx = i;
				break;
			}
		}
		return idx;
	}
	public boolean remove(String name) {
		int idx= findIndex(name);
		if(idx!=-1) {
//			String tmpName[]= new String[foodN.length-1];
//			int tmpCost[]= new int[foodC.length-1];
			Food food2[]= new Food[food.length-1];
			for(int i=0,j=0;i<food.length;i++) {
				if(idx!=i) {
					food2[j]=food[i];
//					tmpName[j]=this.foodN[i];
//					tmpCost[j]=this.foodC[i];
					j++;
				}
			}
//			this.foodN=tmpName;
//			this.foodC=tmpCost;
			food=food2; 
			
			return true;
		}
		return false;
	}
	
}
