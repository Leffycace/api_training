package fr.esiea.ex4A.fakebdd;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FakebddTest {

    @Test
    void repository_get_users(){
        Fakebdd repository = new Fakebdd();

        assertThat(repository.getUsers()).isInstanceOf(List.class);
    }

}
