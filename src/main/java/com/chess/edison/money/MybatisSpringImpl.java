package com.chess.edison.money;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component("mybatisSpringImpl")
public class MybatisSpringImpl implements TransferDAO {

	@Autowired
	UserDAO userDAO;

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public void transferMoney(Long srcUserId, Long targetUserId, Double count) {
		// TODO Auto-generated method stub
		userDAO.balanceSub(count, srcUserId);
		userDAO.balanceAdd(count, targetUserId);
	}

	private void ex() throws Exception {
		throw new Exception("我故意抛的异常");
	}
}
