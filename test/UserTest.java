import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
/**
 * �����û�������һ��������
 * @author ����
 *
 */
class UserTest {

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
			System.out.println("��õ�����������"+count);
			//5.�ر�sqlsession����
			sqlsession.close();			
		} catch (IOException e) {
			e.printStackTrace();
		}
  	}

}
