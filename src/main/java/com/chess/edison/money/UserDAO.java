package com.chess.edison.money;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO {

	@Update("update `UserBalance` set `balance` = `balance` + #{0} where userId = #{1}")
	public void balanceAdd(@Param("0")Double count,@Param("1")Long userId);

	@Update("update `UserBalance` set `balance` = `balance` - #{0} where userId = #{1}")
	public void balanceSub(@Param("0")Double count,@Param("1")Long userId);
}
