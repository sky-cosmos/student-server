package com.kaiyu.web.dto;


import com.github.pagehelper.PageInfo;
import com.kaiyu.common.api.CommonPage;
import com.kaiyu.common.api.CommonResult;
import com.kaiyu.mbg.domain.UmsAdmin;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.Column;
import javax.validation.Valid;
import java.util.List;

/**
 * 查询接口
 */
@Data
public class UmsAdminQueryParam extends PageParam {
    @ApiModelProperty("用户名")
    private String username;
    @ApiModelProperty("用户名")
    private String nickName;
    @ApiModelProperty("状态")
    private Integer status;
}
