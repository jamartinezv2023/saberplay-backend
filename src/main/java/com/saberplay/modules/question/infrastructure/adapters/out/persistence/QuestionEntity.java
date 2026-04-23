package com.saberplay.modules.question.infrastructure.adapters.out.persistence;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import java.util.List;

@Entity
@Table(name = "questions")
@Getter
@Setter
@FilterDef(name = "tenantFilter", parameters = @ParamDef(name = "tenantId", type = String.class))
@Filter(name = "tenantFilter", condition = "tenant_id = :tenantId")
public class QuestionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tenant_id", nullable = false)
    private String tenantId;

    private String area;
    private String difficulty;
    @Column(columnDefinition = "TEXT")
    private String statement;
    
    @ElementCollection
    private List<String> options;
}
