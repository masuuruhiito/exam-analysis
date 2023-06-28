package com.shijw.front.service;

import com.shijw.front.model.vo.QueryClassVO;
import com.shijw.front.model.vo.QueryTeachInfoVO;
import com.shijw.front.web.params.FrontAddTeachInfoParams;
import com.shijw.front.web.params.FrontQueryTeachInfoParams;

import java.util.List;

/**
 * @author SHI
 * @date 2023/4/12 23:40
 */
public interface IFrontTeachInfoService {

    List<QueryTeachInfoVO> queryTeachInfoByConditions(FrontQueryTeachInfoParams params);

    void addTeachInfo(FrontAddTeachInfoParams params);
}
