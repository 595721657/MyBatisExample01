import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
/**
 * ��Ӧ�̵�һ������
 * @author ����
 *
 */
class ProviderTest {

	@Test
	void test() {
		try {
			//1.���mybatis���������ļ�������������
			InputStream is=Resources.getResourceAsStream("mybatis-config.xml");
			//2.ͨ������������SqlSessionFactory����
			SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(is);
			//3.ͨ��SqlSessionFactory����SqlSession����
			SqlSession sqlsession=ssf.openSession();
			//4.����SqlSession��ִ�в���
			int counts=sqlsession.selectOne("dao.ProviderMapper.getCount");
		    //������
			System.out.println("��Ӧ�̱��������"+counts);
			//�ر�SqlSession����
			sqlsession.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
