package com.saberplay.screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import static net.serenitybdd.tasks.instrumented;

public class RegisterInstitution implements Task {
    private final String name;

    public RegisterInstitution(String name) {
        this.name = name;
    }

    public static RegisterInstitution withName(String name) {
        return instrumented(RegisterInstitution.class, name);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Aquí Screenplay interactúa con el API Rest para registrar
        // IE Sagrada Familia con su tenantId único.
    }
}
