package com.sn.knit.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * <h1>授权中心鉴权之后给客户端的 Token</h1>
 *
 * @author Administrator
 * @date 2022/06/19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtToken {

    /**
     * JWT
     */
    private String token;
}
