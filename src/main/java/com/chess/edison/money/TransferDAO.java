package com.chess.edison.money;

public interface TransferDAO {
	public void transferMoney(Long srcUserId,Long targetUserId,Double count);
}
