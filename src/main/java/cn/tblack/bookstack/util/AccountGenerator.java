package cn.tblack.bookstack.util;

import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.tblack.bookstack.service.BookUserService;

/**
 * <span>账号生成器-用于产生随机的10位账户用于前端页面注册使用-需要保证产生的数据不重复</span>
 * @author TD唐登
 * @Date:2019年6月16日
 * @Version: 1.0(测试版)
 */
@Component
public class AccountGenerator implements  Generator<Long>{

	
	private static Random rand ;
	
	private static final long BOUND =  10000000000L; //最大产生10位的数字
	
//	private static final long BOUND = Long.valueOf("10000000000");  //最大产生10位的数字
	
	private  BookUserService userService;
	
	public AccountGenerator(BookUserService uService) {
		this.userService =  uService;
	}
	
	static{
		rand = new Random();
	}

	@Override
	public  Long next() {
		
		/*@ 随机产生整数，并查询是否在账户， 如果不存在的话， 则可以使用*/
		long account =  (rand.nextLong() + BOUND / 10) % BOUND;
		
		System.out.println("用户服务类: " + userService);
		
		/*@ 确保产生的随机数不小于8位数,并且数据库内不存在该账号*/
		while(account < (BOUND / 100) || userService.countByAccount(account) > 0) {
			account =  (rand.nextLong() + BOUND / 10) % BOUND;
		}
	
		System.out.println("账号生成为:" + account);
		return Math.abs(account);
	}
	
}
