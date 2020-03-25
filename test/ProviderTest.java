import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
/**
 * 供应商的一个测试
 * @author 黄龙
 *
 */
class ProviderTest {

	@Test
	void test() {
		try {
			//1.获得mybatis核心配置文件的输入流对象
			InputStream is=Resources.getResourceAsStream("mybatis-config.xml");
			//2.通过输入流创建SqlSessionFactory对象
			SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(is);
			//3.通过SqlSessionFactory创建SqlSession对象
			SqlSession sqlsession=ssf.openSession();
			//4.调用SqlSession来执行操作
			int counts=sqlsession.selectOne("dao.ProviderMapper.getCount");
		    //输出结果
			System.out.println("供应商表的条数："+counts);
			//关闭SqlSession对象
			sqlsession.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
