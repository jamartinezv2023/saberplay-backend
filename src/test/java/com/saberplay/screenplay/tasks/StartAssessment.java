package com.saberplay.screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class StartAssessment implements Task {
    private final String area;

    public StartAssessment(String area) {
        this.area = area;
    }

    public static StartAssessment forArea(String area) {
        return instrumented(StartAssessment.class, area);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Aquí iría la lógica de llamar al endpoint de la API
    }
}
