package com.saberplay.config.beans;

import com.saberplay.shared.infrastructure.TenantContext;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TenantAspect {

    @Autowired
    private EntityManager entityManager;

    @Before("execution(* com.saberplay.modules..*.infrastructure.adapters.out.persistence.*.*(..))")
    public void beforeExecution() {
        String tenantId = TenantContext.getTenantId();
        if (tenantId != null) {
            Session session = entityManager.unwrap(Session.class);
            session.enableFilter("tenantFilter").setParameter("tenantId", tenantId);
        }
    }
}
