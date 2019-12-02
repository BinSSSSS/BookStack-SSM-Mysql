package cn.tblack.bookstack.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tblack.bookstack.pojo.BookAdmin;

/**
 * <span>管理员数据库操作方法</span>
 * @author TD唐登
 * @Date:2019年8月26日
 * @Version: 1.0(测试版)
 */
public interface BookAdminMapper {
	
	
	/**
	 * @ 拿到数据库内的所有数据条数
	 * @return
	 */
    long count();
    
    /**
     * @ 根据管理员id来进行查询数据条数
     * @param adminId
     * @return
     */
    long countByAdminId(Integer adminId);		
    
    /**
     * @ 根据管理员名字来进行查询数据条数
     * @param adminName
     * @return
     */
    long countByAdminName(String adminName);		
    
    
    /**
     * @ 根据管理员id来进行删除操作
     * @param adminId
     * @return
     */
    int deleteByAdminId(Integer adminId);
    
    /**
     * @ 根据管理员名字来进行删除操作
     * @param adminName
     * @return
     */
    int deleteByAdminName(String adminName);

    /**
     * @ 插入一条新的管理员数据库操作
     * @param record
     * @return
     */
    int insert(BookAdmin record);

    /**
     * @ 插入一条新的管理员数据， 但是如果提供的字段有空字段的话， 那么则不进行插入。
     * @param record
     * @return
     */
    int insertSelective(BookAdmin record);

    /**
     * @ 拿到所有数据库内的数据，并且装入到一个容器中
     * @return
     */
    List<BookAdmin> selectAll();

    /**
     * @ 通过管理员id来获取到管理员的数据
     * @param adminId
     * @return
     */
    BookAdmin selectByAdminId(Integer adminId);

    /**
     * @ 通过管理员名字来获取到管理员的数据
     * @param adminName
     * @return
     */
    BookAdmin selectByAdminName(String adminName);
    
    /**
     * @ 根据管理员id来进行数据的更新操作。空字段不进行更新操作
     * @param record
     * @return
     */
    int updateByAdminIdSelective(BookAdmin record);
    
    /**
     * @ 根据管理员id来进行数据的更新操作。
     * @param record
     * @return
     */
    int updateByAdminId(BookAdmin record);

    /**
     * @ 根据管理员名字和密码来进行验证。
     * @param adminName
     * @param password
     * @return 返回的状态码可以用来表示出错的类型。（如： 用户名不正确， 密码不正确。 用户名不存在等）
     */
    int verify(@Param("adminName") String adminName,@Param("password") String password);
}