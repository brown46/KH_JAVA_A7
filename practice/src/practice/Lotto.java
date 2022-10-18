package practice;

public class Lotto {
	int arr[] = new int[7];
	int i=0;
	 int round=i;
	public void creatNum() {
		boolean overlap=true;
	
		for(;overlap==true;) {
			overlap=false;
			loop1: for (int i = 0; i < 7; i++) {
				arr[i] = (int) (Math.random() * 46 + 1);
				if(i==0)continue;
				for (int j = 0; j <i; j++) {
					if (j == i)
						continue;
					if (arr[j] == arr[i]) {
						overlap=true;
						break loop1;
					}
				
				}
			}
		}
		i++;
	}
	public void getNum() {
		 for(int i=0;i<7;i++) {
			System.out.print(arr[i]+" ");
		}
		 System.out.println();
	}
	public void getRound() {
		System.out.println("현재 회차: "+i+"회차");
	}

}
