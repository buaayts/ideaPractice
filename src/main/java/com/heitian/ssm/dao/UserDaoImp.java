package com.heitian.ssm.dao;

import com.heitian.ssm.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

/**
 * Created by yetaoshan on 17/8/12.
 * 和spring整合后的原始dao开发方法，需要在配置文件中配置
 * <bean id="userDao" class="com.heitian.ssm.dao.UserDaoImp">
 *     <property name="sqlSessionFactory" ref="sqlSessionFactory的id"/>
 * </bean>
 */
public class UserDaoImp extends SqlSessionDaoSupport implements UserDao{

    public User selectUserById(@Param("userId") Long userId) {
        //因为继承了SqlSessionSupport，所以可以直接得到
        SqlSession sqlSession=this.getSqlSession();
        User user = sqlSession.selectOne("selectUserById",userId);
        return user;
    }

    public User selectUserByPhoneOrEmail(@Param("emailOrPhone") String emailOrPhone, @Param("state") Short state) {
        return null;
    }

    public List<User> selectAllUser() {
        return null;
    }

    public void insertUser(@Param("userId") Long userId, @Param("user_name") String user_name, @Param("user_phone") String user_phone, @Param("user_email") String user_email, @Param("user_pwd") String user_pwd) {

    }
}
