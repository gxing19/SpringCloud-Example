package com.springcloud.shardingjdbc.service.impl;

import com.springcloud.shardingjdbc.entity.UserInfo;
import com.springcloud.shardingjdbc.repository.UserInfoRepository;
import com.springcloud.shardingjdbc.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * @name: UserInfoServiceImpl
 * @desc: TODO
 * @author: gxing
 * @date: 2019-06-19 10:29
 **/
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private UserInfoRepository userInfoRepository;

    /**
     * 读数据,返回集合
     *
     * @return
     */
    @Override
    public List<UserInfo> getAll() {
        String sql = "select * from user_info";
        RowMapper<UserInfo> userInfoRowMapper = new RowMapper<UserInfo>() {
            @Override
            public UserInfo mapRow(ResultSet resultSet, int i) throws SQLException {
                UserInfo userInfo = new UserInfo()
                        .setId(resultSet.getLong("id"))
                        .setRealName(resultSet.getString("real_name"))
                        .setNickName(resultSet.getString("nick_name"))
                        .setAge(resultSet.getInt("age"))
                        .setAddress(resultSet.getString("address"));
                return userInfo;
            }
        };
        return jdbcTemplate.query(sql, userInfoRowMapper);
    }

    /**
     * 写入数据
     *
     * @param userInfo
     * @return
     */
    @Override
    public int addUserInfo(UserInfo userInfo) {
        String sql = "insert into user_info (id,real_name,nick_name,age,address) values(?,?,?,?,?)";
        /*return jdbcTemplate.update(sql, userInfo.getId(), userInfo.getRealName(),
                userInfo.getNickName(), userInfo.getAge(), userInfo.getAddress());*/

        int count = 0;
        for (int i = 0; i < 20; i++) {
            jdbcTemplate.update(sql, i, userInfo.getRealName(),
                    userInfo.getNickName(), userInfo.getAge(), userInfo.getAddress());
            userInfo.setId((long) i);
            count++;
        }
        return count;
    }

    /**
     * 查询,强制路由到主库
     *
     * @param id
     * @return
     */
    @Override
    public UserInfo getById(Long id) {
        String sql = "select * from user_info where id = ?";

        Object[] objArr = new Object[1];
        objArr[0] = id;

        RowMapper<UserInfo> userInfoRowMapper = new RowMapper<UserInfo>() {
            @Override
            public UserInfo mapRow(ResultSet resultSet, int i) throws SQLException {
                UserInfo userInfo = new UserInfo()
                        .setId(resultSet.getLong("id"))
                        .setRealName(resultSet.getString("real_name"))
                        .setNickName(resultSet.getString("nick_name"))
                        .setAge(resultSet.getInt("age"))
                        .setAddress(resultSet.getString("address"));
                return userInfo;
            }
        };

//        HintManager.getInstance().setMasterRouteOnly();
        return jdbcTemplate.queryForObject(sql, objArr, userInfoRowMapper);
    }

    /**
     * 使用 JDBC Repository 接口方法
     *
     * @param id
     * @return
     */
    public UserInfo getByIdFromRepo(Long id) {
//        HintManager.getInstance().setMasterRouteOnly();

        Optional<UserInfo> userInfoOptional = userInfoRepository.findById(id);
        UserInfo userInfo = userInfoOptional.orElse(null);
        return userInfo;
    }
}