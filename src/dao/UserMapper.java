package dao;
/**
 * �������ݿ������ݵĽӿ�
 * @author ����
 *����ʱ�� 2020��3��27������3:08:54
 */

import java.util.List;
import java.util.Map;

import entity.User;

public interface UserMapper {
      //����������ݿ�ķ���
	 //�ӿڵķ�����mapper.xml��id��һһ��Ӧ��
	 /**
	 * �������������
	 * @return 
	 */
	  int getCount();
	  /**
	   *      ��������û���Ϣ�ķ���
	   * @return ���������û���Ϣ�ļ���
	   */
	  List<User> getAll();
	  /**
	   * ���ݸ���������ģ����ѯ
	   * @param username �������û���
	   * @return  ��������������û�����
	   */
	  List<User> findByName(String username);
      //����������ѯ���ݿ����� ������ģ����ѯ����Ҫ��ָ���Ľ�ɫ
	  List<User> getUserList(User user);
      //����һ��map������ʵ�����ݵĲ�ѯ
	  List<User> getUserMap(Map<String, Object> map);
      //���ݵĲ���Ϊһ��list����
	  List<User> getList(List<User> list);
	  /**
	   * ����û�����ϸ��Ϣ�����û�������ɫ����
	   * ���ű������
	   * @param user  �û����ƣ���ɫid
	   * @return һ��������û�����
	   */
      User getUserRoleName(User user);
      /**
       * ��xml��ResultMapȥӳ�������������
       * @param user
       * @return
       */
      User getUserResultMap(User user);
}
