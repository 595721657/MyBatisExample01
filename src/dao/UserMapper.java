package dao;
/**
 * 操作数据库中数据的接口
 * @author 黄龙
 *创建时间 2020年3月27日下午3:08:54
 */

import java.util.List;
import java.util.Map;

import entity.User;

public interface UserMapper {
      //定义操作数据库的方法
	 //接口的方法与mapper.xml的id是一一对应的
	 /**
	 * 获得数据总条数
	 * @return 
	 */
	  int getCount();
	  /**
	   *      获得所有用户信息的方法
	   * @return 保存所有用户信息的集合
	   */
	  List<User> getAll();
	  /**
	   * 根据给定的名称模糊查询
	   * @param username 给定的用户名
	   * @return  保存符合条件的用户集合
	   */
	  List<User> findByName(String username);
      //根据条件查询数据库数据 按名称模糊查询并且要是指定的角色
	  List<User> getUserList(User user);
      //传递一个map集合来实现数据的查询
	  List<User> getUserMap(Map<String, Object> map);
      //传递的参数为一个list集合
	  List<User> getList(List<User> list);
	  /**
	   * 获得用户的详细信息包含用户名，角色名称
	   * 两张表的数据
	   * @param user  用户名称，角色id
	   * @return 一个具体的用户对象
	   */
      User getUserRoleName(User user);
      /**
       * 在xml中ResultMap去映射其他表的数据
       * @param user
       * @return
       */
      User getUserResultMap(User user);
}
