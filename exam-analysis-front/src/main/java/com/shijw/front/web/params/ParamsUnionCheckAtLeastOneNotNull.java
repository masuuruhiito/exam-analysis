package com.shijw.front.web.params;//package com.shijw.back.web.params;
//
//import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
// todo
//
//public class ParamsUnionCheckAtLeastOneNotNull implements DefaultGroupSequenceProvider<AAA> {
//
//    @Override
//    public List<Class<?>> getValidationGroups(AAA innerUserStroedRequest) {
//        List<Class<?>> defaultGroupSequence = new ArrayList<>();
//        defaultGroupSequence.add(AAA.class);
//
//        if(Objects.nonNull(innerUserStroedRequest)){
//            //储值金额为null，group = WhenAmountIsNull 的校验注解生效
//            if(Objects.isNull(innerUserStroedRequest.getAmount()) ){
//                defaultGroupSequence.add(InnerUserStroedRequest.WhenAmountIsNull.class);
//            }
//            //储值规则为null，group = WhenEntityIsNull 的校验注解生效
//            if(Objects.isNull(innerUserStroedRequest.getEntity())){
//                defaultGroupSequence.add(InnerUserStroedRequest.WhenEntityIsNull.class);
//            }
//        }
//        return defaultGroupSequence;
//    }
//}
//
//class AAA{
//    interface TheFirstCheckProperty {
//    }
//
//    interface TheSecondCheckProperty {
//    }
//
//    interface TheThirdCheckProperty {
//    }
//
//    interface TheFourthCheckProperty {
//    }
//}
//
//
//
//