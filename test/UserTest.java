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
 * �����û�������һ��������
 * @author ����
 *
 */
class UserTest {
	//����һ����־��¼����
    private Logger log=Logger.getLogger(UserTest.class);
	/**
	 * 
	 */
	@Test
	void test() {
		try {
			//1.���mybatis���������ļ�����������
			InputStream is=Resources.getResourceAsStream("mybatis-config.xml");
		    //2.ͨ������������sqlsessionFactory����
			SqlSessionFactory fac=new SqlSessionFactoryBuilder().build(is);
		    //3.ͨ��sqlsessionFactory���󴴽�sqlsession����
			SqlSession sqlsession=fac.openSession();
			//3.����sqlsession����ķ�����ִ�в���
			//ִ��sql���ֻ����һ�����ݵķ��� selectOne
			int count=sqlsession.selectOne("dao.UserMapper.getCount");		
			//�����������־��
			log.debug("count====>"+count);
			//5.�ر�sqlsession����
			sqlsession.close();			
		} catch (IOException e) {
			e.printStackTrace();
		}
  	}

	private SqlSession sqlsession=null;
	//����һ��������еķ���
	@Test
	void testgetAll() {
		//1.�������mybatis���������ļ�����������
		//2.��ù�������
		//3.���sqlsession����
		//4.���÷���������
		//5.�ر�ִ�ж���
		try {
			/*
			 * //1.���mybatis���������ļ����������� InputStream
			 * is=Resources.getResourceAsStream("mybatis-config.xml");
			 * //2.ͨ������������sqlsessionFactory���� SqlSessionFactory fac=new
			 * SqlSessionFactoryBuilder().build(is);
			 */
		    //3.ͨ��sqlsessionFactory���󴴽�sqlsession����
			sqlsession=MyBatisUtils.createSqlSession();
			//3.����sqlsession����ķ�����ִ�в���
			//ִ��sql���ֻ����һ�����ݵķ��� selectOne
			///List<User> list=sqlsession.selectList("dao.UserMapper.getAll");			
			//ͨ������mapper�ӿڵķ�ʽ���������ݿ�����
			/**
			 * getMapper�����������ȥ��ö�Ӧ�Ľӿڶ���
			 */
			List<User> list=sqlsession.getMapper(UserMapper.class).getAll();
			//�����������־��
			for (User user : list) {
				log.debug("userCode:"+user.getUserCode()+"\t"+"userName:"+user.getUserName());
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//5.�ر�sqlsession����
			MyBatisUtils.closeSqlSession(sqlsession);
		}
	}
	//����һ��ͨ������ģ����ѯ�Ĳ��Է���
	@Test
	void findByName() {
		try {
			String userName="��";
			//���ù�����sqlsession�ķ���
			sqlsession=MyBatisUtils.createSqlSession();
			//����SQLsession�ķ�����ִ�в���
			List<User> list=sqlsession.selectList("dao.UserMapper.findByName",userName);
			//������
			for (User user : list) {
				log.debug("userCode:"+user.getUserCode()+"\t"+"userName:"+user.getUserName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisUtils.closeSqlSession(sqlsession);
		}	  
	}
	//���Զ�������ѯ����user
	@Test
	public void testGetUserList() {
		try {
			//����һ���û�����
			User user=new User();
			//Ϊ�û���ֵ
			user.setUserName("��");
			user.setUserRole(2);
			sqlsession=MyBatisUtils.createSqlSession();
			//����mapper�ӿڵķ���
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
	//���Զ�������ѯ����map
		@Test
		public void testGetUserMap() {
			try {
				//����һ��map����
				Map<String, Object> map=new HashMap<String, Object>();
				map.put("uname","��");
                map.put("urole",2);
				sqlsession=MyBatisUtils.createSqlSession();
				//����mapper�ӿڵķ���
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
	//���Զ�������ѯ����list
	@Test
	public void testGetList() {
		try {
			//����һ��list����
			List<User> list2=new ArrayList<User>();
			list2.add(new User("��",2));
			sqlsession=MyBatisUtils.createSqlSession();
			//����mapper�ӿڵķ���
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
	//������飨2��
	@Test
	public void testGetUserRole() {
		try {
			//����һ��user����
			User user3=new User();
			user3.setUserName("��");
			user3.setUserRole(2);
			sqlsession=MyBatisUtils.createSqlSession();
			//����mapper�ӿڵķ���
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
			//����һ��user����
			User user3=new User();
			user3.setUserName("��");
			user3.setUserRole(2);
			sqlsession=MyBatisUtils.createSqlSession();
			//����mapper�ӿڵķ���
			User user2=sqlsession.getMapper(UserMapper.class).getUserResultMap(user3);
			log.debug("userCode:"+user2.getUserCode()+"\t"+"userName:"+user2.getUserName()+"\t"+"userRole:"+user2.getRole().getUserRoleName());
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlsession.close();
		}
	}
}
