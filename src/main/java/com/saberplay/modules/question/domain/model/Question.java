package com.saberplay.modules.question.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    private Long id;
    private String tenantId;
    private String area;
    private String difficulty;
    private String statement;
    private List<String> options;
    private int correctAnswerIndex;
}
