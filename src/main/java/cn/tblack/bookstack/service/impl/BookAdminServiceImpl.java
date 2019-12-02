package cn.tblack.bookstack.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tblack.bookstack.mapper.BookAdminMapper;
import cn.tblack.bookstack.pojo.BookAdmin;
import cn.tblack.bookstack.service.BookAdminService;

/**
 * <span>服务层实现类： 用户实现父类接口定义的方法</span>
 * @author TD唐登
 * @Date:2019年8月26日
 * @Version: 1.0(测试版)
 */
@Service
public class BookAdminServiceImpl implements BookAdminService{

	@Autowired
	BookAdminMapper adminMapper ;

	@Override
	public long count() {
		return adminMapper.count();
	}

	@Override
	public long countByAdminId(Integer adminId) {
		return adminMapper.countByAdminId(adminId);
	}

	@Override
	public long countByAdminName(String adminName) {
		return adminMapper.countByAdminName(adminName);
	}

	@Override
	public int deleteByAdminId(Integer adminId) {
		return adminMapper.deleteByAdminId(adminId);
	}

	@Override
	public int deleteByAdminName(String adminName) {
		return adminMapper.deleteByAdminName(adminName);
	}

	@Override
	public int insert(BookAdmin record) {
		return adminMapper.insert(record);
	}

	@Override
	public int insertSelective(BookAdmin record) {
		return adminMapper.insertSelective(record);
	}

	@Override
	public List<BookAdmin> selectAll() {
		return adminMapper.selectAll();
	}

	@Override
	public BookAdmin selectByAdminId(Integer adminId) {
		return adminMapper.selectByAdminId(adminId);
	}

	@Override
	public BookAdmin selectByAdminName(String adminName) {
		return adminMapper.selectByAdminName(adminName);
	}

	@Override
	public int updateByAdminIdSelective(BookAdmin record) {
		return adminMapper.updateByAdminIdSelective(record);
	}

	@Override
	public int updateByAdminId(BookAdmin record) {
		return adminMapper.updateByAdminId(record);
	}

	@Override
	public int verify(String adminName, String password) {
		return adminMapper.verify(adminName, password);
	}
	
	
	
}
