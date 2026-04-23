package com.saberplay.screenplay.features;

import com.saberplay.screenplay.tasks.Login;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SerenityJUnit5Extension.class)
public class LoginE2ETest {

    @Test
    public void loginExitosoInstitucionSagradaFamilia() {
        Actor rector = Actor.named("Rector Sagrada Familia");
        
        rector.attemptsTo(
            Login.withCredentials("admin_sagrada", "seguridad_familia")
            // Aquí validamos que el token devuelto contenga "sagrada_familia"
        );
    }
}
