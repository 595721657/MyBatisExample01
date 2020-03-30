import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import commons.MyBatisUtils;
import dao.UserMapper;
import entity.User;
/**
 * 测试用户操作的一个测试类
 * @author 黄龙
 *
 */
class UserTest {
	//创建一个日志记录对象
    private Logger log=Logger.getLogger(UserTest.class);
	/**
	 * 
	 */
	@Test
	void test() {
		try {
			//1.获得mybatis核心配置文件输入流对象
			InputStream is=Resources.getResourceAsStream("mybatis-config.xml");
		    //2.通过输入流创建sqlsessionFactory对象
			SqlSessionFactory fac=new SqlSessionFactoryBuilder().build(is);
		    //3.通过sqlsessionFactory对象创建sqlsession对象
			SqlSession sqlsession=fac.openSession();
			//3.调用sqlsession对象的方法来执行操作
			//执行sql语句只返回一个数据的方法 selectOne
			int count=sqlsession.selectOne("dao.UserMapper.getCount");		
			//将它输出到日志中
			log.debug("count====>"+count);
			//5.关闭sqlsession对象
			sqlsession.close();			
		} catch (IOException e) {
			e.printStackTrace();
		}
  	}

	private SqlSession sqlsession=null;
	//定义一个获得所有的方法
	@Test
	void testgetAll() {
		//1.创建获得mybatis核心配置文件输入流对象
		//2.获得工厂对象
		//3.获得sqlsession对象
		//4.调用方法保存结果
		//5.关闭执行对象
		try {
			/*
			 * //1.获得mybatis核心配置文件输入流对象 InputStream
			 * is=Resources.getResourceAsStream("mybatis-config.xml");
			 * //2.通过输入流创建sqlsessionFactory对象 SqlSessionFactory fac=new
			 * SqlSessionFactoryBuilder().build(is);
			 */
		    //3.通过sqlsessionFactory对象创建sqlsession对象
			sqlsession=MyBatisUtils.createSqlSession();
			//3.调用sqlsession对象的方法来执行操作
			//执行sql语句只返回一个数据的方法 selectOne
			///List<User> list=sqlsession.selectList("dao.UserMapper.getAll");			
			//通过操作mapper接口的方式来操作数据库数据
			/**
			 * getMapper这个方法就是去获得对应的接口对象
			 */
			List<User> list=sqlsession.getMapper(UserMapper.class).getAll();
			//将它输出到日志中
			for (User user : list) {
				log.debug("userCode:"+user.getUserCode()+"\t"+"userName:"+user.getUserName());
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//5.关闭sqlsession对象
			MyBatisUtils.closeSqlSession(sqlsession);
		}
	}
	//定义一个通过姓名模糊查询的测试方法
	@Test
	void findByName() {
		try {
			String userName="赵";
			//调用工具类sqlsession的方法
			sqlsession=MyBatisUtils.createSqlSession();
			//调用SQLsession的方法来执行操作
			List<User> list=sqlsession.selectList("dao.UserMapper.findByName",userName);
			//输出结果
			for (User user : list) {
				log.debug("userCode:"+user.getUserCode()+"\t"+"userName:"+user.getUserName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisUtils.closeSqlSession(sqlsession);
		}	  
	}
	//测试多条件查询方法user
	@Test
	public void testGetUserList() {
		try {
			//创建一个用户对象
			User user=new User();
			//为用户给值
			user.setUserName("赵");
			user.setUserRole(2);
			sqlsession=MyBatisUtils.createSqlSession();
			//调用mapper接口的方法
			List<User> list=sqlsession.getMapper(UserMapper.class).getUserList(user);
			for (User user1 : list) {
				log.debug("userCode:"+user1.getUserCode()+"\t"+"userName:"+user1.getUserName()+"\t"+"userRole:"+user1.getUserRole());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlsession.close();
		}
	}
	//测试多条件查询方法map
		@Test
		public void testGetUserMap() {
			try {
				//创建一个map集合
				Map<String, Object> map=new HashMap<String, Object>();
				map.put("uname","赵");
                map.put("urole",2);
				sqlsession=MyBatisUtils.createSqlSession();
				//调用mapper接口的方法
				List<User> list=sqlsession.getMapper(UserMapper.class).getUserMap(map);
				for (User user1 : list) {
					log.debug("userCode:"+user1.getUserCode()+"\t"+"userName:"+user1.getUserName()+"\t"+"userRole:"+user1.getUserRole());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				sqlsession.close();
			}
		}
	//测试多条件查询方法list
	@Test
	public void testGetList() {
		try {
			//创建一个list集合
			List<User> list2=new ArrayList<User>();
			list2.add(new User("赵",2));
			sqlsession=MyBatisUtils.createSqlSession();
			//调用mapper接口的方法
			List<User> list=sqlsession.getMapper(UserMapper.class).getList(list2);
			for (User user1 : list) {
				log.debug("userCode:"+user1.getUserCode()+"\t"+"userName:"+user1.getUserName()+"\t"+"userRole:"+user1.getUserRole());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlsession.close();
		}
	}
	//多表联查（2）
	@Test
	public void testGetUserRole() {
		try {
			//创建一个user集合
			User user3=new User();
			user3.setUserName("赵");
			user3.setUserRole(2);
			sqlsession=MyBatisUtils.createSqlSession();
			//调用mapper接口的方法
			User user2=sqlsession.getMapper(UserMapper.class).getUserRoleName(user3);
			log.debug("userCode:"+user2.getUserCode()+"\t"+"userName:"+user2.getUserName()+"\t"+"userRole:"+user2.getRole());
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlsession.close();
		}
	}
	@Test
	public void testGetUserResultMap() {
		try {
			//创建一个user集合
			User user3=new User();
			user3.setUserName("赵");
			user3.setUserRole(2);
			sqlsession=MyBatisUtils.createSqlSession();
			//调用mapper接口的方法
			User user2=sqlsession.getMapper(UserMapper.class).getUserResultMap(user3);
			log.debug("userCode:"+user2.getUserCode()+"\t"+"userName:"+user2.getUserName()+"\t"+"userRole:"+user2.getRole().getUserRoleName());
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlsession.close();
		}
	}
}
