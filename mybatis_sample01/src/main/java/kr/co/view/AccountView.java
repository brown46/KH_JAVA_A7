package kr.co.view;

import java.util.List;

import kr.co.vo.AccountVO;

public class AccountView {

	public void show(List<AccountVO> data) {
		for(AccountVO a :data) {
			System.out.println(a);
		}
		
	}

}