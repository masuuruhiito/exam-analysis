package com.shijw.front.model;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.shijw.front.excel.vo.ExportStudentScoreBookVO;
import com.shijw.front.model.dto.StudentScoreDTO;
import com.shijw.front.model.vo.QueryScoreVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FrontPersonalScore {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private String teachInfoId;

    private String studentId;

    private String studentName;

    private String scoreList;

    private Double usualScore;

    private Double midTermScore;

    private Double endTermScore;

    public static List<ExportStudentScoreBookVO> toScoreBookDTOList(List<FrontPersonalScore> scoreList) {
        List<ExportStudentScoreBookVO> resList = new ArrayList<>();
        if (CollectionUtils.isEmpty(scoreList)) {
            return resList;
        }
        int i = 0;
        for (FrontPersonalScore scoreInfo : scoreList) {
            ExportStudentScoreBookVO resDTO = new ExportStudentScoreBookVO();
            BeanUtils.copyProperties(scoreInfo, resDTO);
            // 重置id
            resDTO.setId(++i);
            resDTO.setUsual(scoreInfo.getUsualScore() / 2);
            resDTO.setEndTerm(scoreInfo.getEndTermScore() / 2);
            resDTO.setOverall(BigDecimal.valueOf(resDTO.getUsual() + resDTO.getEndTerm()).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
            resList.add(resDTO);
        }
        return resList;
    }

    public static QueryScoreVO toQueryScoreVO(FrontPersonalScore frontPersonalScore) {
        QueryScoreVO res = new QueryScoreVO();
        BeanUtils.copyProperties(frontPersonalScore, res);
        return res;
    }

    public Map<String, Double> getStudentScoreMap() {
        return JSONArray.parseArray(scoreList, StudentScoreDTO.class)
                .stream()
                .collect(Collectors.toMap(StudentScoreDTO::getScoreName, StudentScoreDTO::getScore));
    }

    public static JSONObject toJsonObject(FrontPersonalScore score) {
        return new JSONObject() {{
            put("id", score.id);
            put("studentId", score.studentId);
            put("studentName", score.studentName);

            putAll(score.getStudentScoreMap());

            put("usualScore", score.usualScore);
            put("midTermScore", score.midTermScore);
            put("endTermScore", score.endTermScore);
        }};
    }
}