package com.sn.knit.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sn.knit.domain.Menu;

import java.util.List;

/**
 * @author lenovo
 */
public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 通过用户ID查询用户信息
     *
     * @param userId userId
     * @return list
     */
    List<String> selectPermsByUserId(Long userId);
}
