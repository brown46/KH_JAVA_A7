package kr.co.exam03;

public class Elevator {
	private int presentFloor = 1;
	private int minFloor = 1;
	private int maxFloor = 0;
	private int targetFloor = 0;

	Elevator(int maxFloor) {
		this.maxFloor = maxFloor;
	}

	Elevator(int minFloor, int maxFloor) {
		this.maxFloor = maxFloor;
		this.minFloor = minFloor;
	}

	public void moveTar(int targetFloor) {
		this.targetFloor = targetFloor;
		move();
	}

	private void move() {
		if (minFloor <= targetFloor && targetFloor <= maxFloor) {
			if (targetFloor == presentFloor) {
				System.out.println("현재 위치한 층과 같습니다");
			} else if (targetFloor == 0) {
				System.out.println("1층으로 이동합니다.");
				targetFloor = 1;
			}
			if (targetFloor > presentFloor) {
				System.out.println("현재층에서 " + targetFloor + "층으로 올라갑니다");
				presentFloor = targetFloor;
			} else if (targetFloor < presentFloor) {
				System.out.println("현재층에서 " + targetFloor + "층으로 내려갑니다");
				presentFloor = targetFloor;
			}
		} else {
			System.out.println("1층으로 이동합니다.");
			presentFloor = 1;
		}
	}
}
