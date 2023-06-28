package com.shijw.front.model.dto;

import com.shijw.front.model.vo.QueryScoreHeaderVO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

/**
 * @author SHI
 * @date 2023/5/18 15:05
 */
@Data
@AllArgsConstructor
public class CourseObjectiveInfoDto {

    /**
     * 分数名称，课程目标信息 (为了方便查询是否添加了某个分数名称)
     */
    private Map<String, ObjectiveInfoDto> objectiveInfoDtos;

    public static Map<String, ObjectiveInfoDto> toEnglishScoreNameMap(Collection<ObjectiveInfoDto> objectiveInfoDtos) {
        Map<String, ObjectiveInfoDto> res = new LinkedHashMap<>();
        objectiveInfoDtos.forEach(e -> {
            res.put(e.getScoreName(), e);
        });
        return res;
    }

    public static Map<String, ObjectiveInfoDto> toChineseScoreNameMap(Collection<ObjectiveInfoDto> objectiveInfoDtos) {
        Map<String, ObjectiveInfoDto> res = new LinkedHashMap<>();
        objectiveInfoDtos.forEach(e -> {
            res.put(e.getScoreChineseName(), e);
        });
        return res;
    }

    /**
     * 获取课程目标介绍在Mysql中的存储形式
     *
     * @return {@link Collection}<{@link ObjectiveInfoDto}>
     */
    public Collection<ObjectiveInfoDto> toList() {
        return objectiveInfoDtos.values();
    }

    @Data
    @AllArgsConstructor
    public static class ObjectiveInfoDto {
        private String scoreName;
        private double totalScore;
        private String scoreChineseName;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ObjectiveInfoDto that = (ObjectiveInfoDto) o;
            return Objects.equals(scoreName, that.scoreName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(scoreName);
        }
    }
}
