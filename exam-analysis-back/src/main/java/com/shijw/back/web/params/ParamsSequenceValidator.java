package com.shijw.back.web.params;

import javax.validation.GroupSequence;


/**
 * Created by @author shibinbin on 2018/3/3.
 * 此处的GroupSequence是根据目前的先后顺序进行验证，当存在一个验证不通过的情况则不会验证后一个分组
 * 直接返回验证错误信息，验证顺序是PasswordCheck--》UserNameCheck--》Default
 * <p>
 * 关于Default，此处我springvalidation默认生成的验证接口，验证的范围是所有带有验证信息的属性，
 * 若是属性上方写了验证组，则是验证该组内的属性
 * 若是验证实体类类上写了GroupSequence({}) 则说明重写了Default验证接口，Default就
 * 按照GroupSequence里所写的组信息进行验证
 */
@GroupSequence({TheFirstValidProperty.class,
        TheSecondValidProperty.class,
        TheThirdValidProperty.class,
        TheFourthValidProperty.class,
        TheFifthValidProperty.class,
        TheSixthValidProperty.class})

public interface ParamsSequenceValidator {
}

interface TheFirstValidProperty {
}

interface TheSecondValidProperty {
}

interface TheThirdValidProperty {
}

interface TheFourthValidProperty {
}

interface TheFifthValidProperty {
}

interface TheSixthValidProperty {
}
