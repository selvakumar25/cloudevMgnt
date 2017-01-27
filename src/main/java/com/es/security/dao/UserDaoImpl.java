/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.es.security.dao;

import com.es.security.dto.UserDto;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author VIGNESH
 */
@Service
public class UserDaoImpl extends GenericDaoImpl implements UserDao {

    @Override
    public List<UserDto> getAllUserDetails() {
        String sql = "select u.username as username, GROUP_CONCAT(a.name) as role from user as u"
                + " inner join user_has_role as uhr on u.id_user=uhr.id_user "
                + " inner join authority as a on uhr.id_authority=a.id_authority GROUP BY u.username ";
        return jdbcTemplate.query(sql, (rs, i) -> {
            UserDto item = new UserDto();
            item.setName(rs.getString("username"));
            item.setAuthority(rs.getString("role"));
            return item;
        });
    }

}
