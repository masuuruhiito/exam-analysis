package com.shijw.front.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author SHI
 * @date 2023/5/18 23:01
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QueryScoreHeaderVO {
    private String chineseName;
    private String englishName;
    private double maxScore;
    private boolean scoreFlag;

    public QueryScoreHeaderVO(String chineseName, String englishName) {
        this.chineseName = chineseName;
        this.englishName = englishName;
        this.maxScore = 0;
        this.scoreFlag = false;
    }
}