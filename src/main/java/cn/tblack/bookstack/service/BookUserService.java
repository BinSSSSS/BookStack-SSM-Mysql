package cn.tblack.bookstack.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tblack.bookstack.pojo.BookUser;
import cn.tblack.bookstack.pojo.BookUserExample;

/**
 * <span>服务层： 对于操作用户表的方法进行封装</span>
 * @author TD唐登
 * @Date:2019年8月26日
 * @Version: 1.0(测试版)
 */
public interface BookUserService {
	 long countByExample(BookUserExample example);
	    
	    /**
	     * @ 拿到数据表的全部条数
	     * @return
	     */
	    long count();
	    
	    /**
	     * @ 拿到数据表内指定用户名的数据条数
	     * @param username
	     * @return
	     */
	    long countByUsername(String username);
	    
	    /**
	     * @ 拿到数据库内指定账户的数据条数
	     * @param account
	     * @return
	     */
	    long countByAccount(Long account);
	    
	    /**
	     * @ 拿到数据表内指定的手机号的数据条数
	     * @param phoneNum
	     * @return
	     */
	    long countByPhoneNum(String phoneNum);
	    
	    int deleteByExample(BookUserExample example);

	    /**
	     * @ 删除数据表内的指定账户的数据
	     * @param account
	     * @return
	     */
	    int deleteByAccount(Long account);

	    /**
	     * @ 删除数据表内的指定用户名的数据
	     * @param username
	     * @return
	     */
	    int deleteByUsername(String username);
	    
	    /**
	     * @ 删除数据表内指定手机号的数据
	     * @param phoneNum
	     * @return
	     */
	    int deleteByPhoneNum(String phoneNum);

	    /**
	     * @ 插入一个新用户数据
	     * @param record
	     * @return
	     */
	    int insert(BookUser record);

	    /**
	     * @ 插入一个新用户数据， 空字段不插入
	     * @param record
	     * @return
	     */
	    int insertSelective(BookUser record);

	    List<BookUser> selectByExample(BookUserExample example);
	    
	    /**
	     * @ 拿到数据库内的所有数据
	     * @return
	     */
	    List<BookUser> selectAll();
	    
	    /**
	     * @ 查找指定账户的用户信息
	     * @param account
	     * @return
	     */
	    BookUser selectByAccount(Long account);
	    
	    /**
	     * @ 查找指定用户名的用户信息
	     * @param username
	     * @return
	     */
	    BookUser selectByUsername(String username);
	    
	    /**
	     * @ 查找指定手机号的用户信息
	     * @param phoneNum
	     * @return
	     */
	    BookUser selectByPhoneNum(String phoneNum);
	    
	    
	    /**
	     * @ 按照用户名进行模糊查找
	     * @param username
	     * @return
	     */
	    List<BookUser> fuzzySelectByUsername(String username);
	    
	    
	    int updateByExampleSelective(@Param("record") BookUser record, @Param("example") BookUserExample example);

	    int updateByExample(@Param("record") BookUser record, @Param("example") BookUserExample example);
	    
	    /**
	     * @ 更新用户信息， 空字段不更新
	     * @param record
	     * @return
	     */
	    int updateByUserIdSelective(BookUser record);

	    /**
	     * @ 更新用户信息
	     * @param record
	     * @return
	     */
	    int updateByUserId(BookUser record);
	    
	    /**
	     * @ 根据账户和密码来验证数据库数据
	     * @param account
	     * @param password
	     * @return
	     */
	    int verifyByAccount(@Param("account") Long account,@Param("password") String password);
	    
	    /**
	     * @ 根据用户名和密码来进行登录验证
	     * @param username
	     * @param password
	     * @return
	     */
	    int verifyByUsername(@Param("username") String username,@Param("password") String password);
	    
	    /**
	     * @ 根据手机号和密码来进行登录验证
	     * @param phoneNum
	     * @param password
	     * @return
	     */
	    int verifyByPhoneNum(@Param("phoneNum") String phoneNum,@Param("password") String password);


}
