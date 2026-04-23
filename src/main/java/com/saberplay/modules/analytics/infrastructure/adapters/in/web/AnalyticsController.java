package com.saberplay.modules.analytics.infrastructure.adapters.in.web;

import com.saberplay.shared.infrastructure.TenantContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/analytics")
public class AnalyticsController {

    @GetMapping("/welcome")
    public Map<String, String> getWelcomeMessage() {
        return Map.of(
            "message", "Bienvenido a SaberPlay",
            "institucion", TenantContext.getTenantId() != null ? TenantContext.getTenantId() : "Desconocida",
            "status", "0 estudiantes activos (Sincronización pendiente)"
        );
    }
}
