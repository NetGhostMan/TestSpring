package com.chess.edison.service;

import org.springframework.stereotype.Component;

@Component
public class ServiceTwo {
	//ServiceOne into 方法正常返回。
		public void into() {
			System.out.println("方法：服务2 的增加功能执行了。");
		}
		//select 有返回值的
		public int select() {
			System.out.println("方法：服务2 的查询功能执行了");
			return 12;
		}
		// 有参数的方法
		public void delete(int id) {
			System.out.println("方法：服务2 删除了Id='"+id+"'的值。");
		}
		//有异常的方法
		public void update() throws Exception {
			System.out.println("方法：服务2 开始修改记录");
			throw new Exception("服务2 修改失败了");
		}
}
