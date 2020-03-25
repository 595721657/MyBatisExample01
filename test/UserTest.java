import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
/**
 * 测试用户操作的一个测试类
 * @author 黄龙
 *
 */
class UserTest {

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
			System.out.println("获得的数据总数："+count);
			//5.关闭sqlsession对象
			sqlsession.close();			
		} catch (IOException e) {
			e.printStackTrace();
		}
  	}

}
