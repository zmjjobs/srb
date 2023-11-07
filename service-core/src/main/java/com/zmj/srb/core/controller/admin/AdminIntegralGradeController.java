package com.zmj.srb.core.controller.admin;


import com.zmj.common.result.R;
import com.zmj.srb.core.pojo.entity.IntegralGrade;
import com.zmj.srb.core.service.IntegralGradeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 积分等级表 前端控制器
 * </p>
 *
 * @author zhumengjun
 * @since 2023-11-07
 */
@Api(tags="积分等级管理")
@CrossOrigin //自动跨域
@RestController
@RequestMapping("/admin/core/integralGrade")
public class AdminIntegralGradeController {

    @Resource
    private IntegralGradeService integralGradeService;

    @GetMapping("/list")
    @ApiOperation("积分等级列表")
    public R<List<IntegralGrade>> listAll(){
        List<IntegralGrade> list = integralGradeService.list();
        return R.ok().data("list",list).message("获取列表成功");
    }

    @ApiOperation(value = "根据ID删除积分等级",notes = "逻辑删除")
    @DeleteMapping("removeById/{id}")
    public R<Boolean> removeById(
            @ApiParam(value = "记录ID",example = "100",required = true)
            @PathVariable Integer id) {
        boolean b = integralGradeService.removeById(id);
        if (b) {
            return R.ok().message("删除成功").data("result",true);
        }
        return R.error().message("删除失败").data("result",false);
    }
}

