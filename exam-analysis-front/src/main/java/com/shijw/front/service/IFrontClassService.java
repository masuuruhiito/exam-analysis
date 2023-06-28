package com.shijw.front.service;

import com.shijw.front.model.FrontPersonalClass;
import com.shijw.front.model.vo.QueryClassVO;
import com.shijw.front.web.params.FrontClassQueryClassByConditionsParams;
import com.shijw.front.web.params.FrontClassRegisterParams;
import com.shijw.front.web.params.FrontClassUpdateParams;

import java.util.List;

/**
 * @author SHI
 * @date 2023/4/12 23:40
 */
public interface IFrontClassService {
    List<QueryClassVO> queryClassByConditions(FrontClassQueryClassByConditionsParams params);

    void registerPersonalClass(FrontClassRegisterParams params);

    String getClassName(FrontPersonalClass classInfo);

    void updatePersonalClass(FrontClassUpdateParams params);
}
