package cn.tblack.bookstack.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tblack.bookstack.mapper.BookUserMapper;
import cn.tblack.bookstack.pojo.BookUser;
import cn.tblack.bookstack.pojo.BookUserExample;
import cn.tblack.bookstack.service.BookUserService;

/**
 * <span>服务层实现类： 用户实现父类接口定义的方法</span>
 * @author TD唐登
 * @Date:2019年8月26日
 * @Version: 1.0(测试版)
 */
@Service
public class BookUserServiceImpl implements BookUserService{

	
	@Autowired
	BookUserMapper userMapper ;

	@Override
	public long countByExample(BookUserExample example) {
		return userMapper.countByExample(example);
	}

	@Override
	public long count() {
		return userMapper.count();
	}

	@Override
	public long countByUsername(String username) {
		return userMapper.countByUsername(username);
	}

	@Override
	public long countByAccount(Long account) {
		return userMapper.countByAccount(account);
	}

	@Override
	public long countByPhoneNum(String phoneNum) {
		return userMapper.countByPhoneNumber(phoneNum);
	}

	@Override
	public int deleteByExample(BookUserExample example) {
		return userMapper.deleteByExample(example);
	}

	@Override
	public int deleteByAccount(Long account) {
		return userMapper.deleteByAccount(account);
	}

	@Override
	public int deleteByUsername(String  username) {
		return userMapper.deleteByUsername(username);
	}

	@Override
	public int deleteByPhoneNum(String phoneNum) {
		return userMapper.deleteByPhoneNumber(phoneNum);
	}

	@Override
	public int insert(BookUser record) {
		return userMapper.insert(record);
	}

	@Override
	public int insertSelective(BookUser record) {
		return userMapper.insertSelective(record);
	}

	@Override
	public List<BookUser> selectByExample(BookUserExample example) {
		return userMapper.selectByExample(example);
	}

	@Override
	public List<BookUser> selectAll() {
		return userMapper.selectAll();
	}

	@Override
	public BookUser selectByAccount(Long account) {
		return userMapper.selectByAccount(account);
	}

	@Override
	public BookUser selectByUsername(String username) {
		return userMapper.selectByUsername(username);
	}

	@Override
	public BookUser selectByPhoneNum(String phoneNum) {
		return userMapper.selectByPhoneNum(phoneNum);
	}

	@Override
	public int updateByExampleSelective(BookUser record, BookUserExample example) {
		return userMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(BookUser record, BookUserExample example) {
		return userMapper.updateByExample(record, example);
	}

	@Override
	public int updateByUserIdSelective(BookUser record) {
		return userMapper.updateByUserIdSelective(record);
	}

	@Override
	public int updateByUserId(BookUser record) {
		return userMapper.updateByUserId(record);
	}

	@Override
	public int verifyByAccount(Long account, String password) {
		return userMapper.verifyByAccount(account, password);
	}

	@Override
	public int verifyByUsername(String username, String password) {
		return userMapper.verifyByUsername(username, password);
	}

	@Override
	public int verifyByPhoneNum(String phoneNum, String password) {
		return userMapper.verifyByPhoneNumber(phoneNum, password);
	}

	@Override
	public List<BookUser> fuzzySelectByUsername(String username) {
		return userMapper.fuzzySelectByUsername(username);
	}		
}
