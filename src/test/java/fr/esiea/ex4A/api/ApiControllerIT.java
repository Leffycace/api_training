package fr.esiea.ex4A.api;

import static org.junit.jupiter.api.Assertions.*;

import fr.esiea.ex4A.agify.AgifyService;
import fr.esiea.ex4A.entity.User;
import fr.esiea.ex4A.fakebdd.Fakebdd;;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class ApiControllerIT {

    private final MockMvc mockMvc;

    @MockBean
    private AgifyService agifyService;

    @MockBean
    private Fakebdd repository;

    ApiControllerIT(@Autowired MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    @Order(3)
    void add_user() throws Exception {
        doReturn(52).when(agifyService).getAge(anyString(), anyString());

        mockMvc
            .perform(MockMvcRequestBuilders.post(
                "/api/inscription").contentType(MediaType.APPLICATION_JSON).content("""
                  {
                    "userEmail": "machin@truc.com",
                    "userName": "machin",
                    "userTweeter": "machin45",
                    "userCountry": "FR",
                    "userSex": "M",
                    "userSexPref": "M"
                  }      
                """)
            )
            .andExpect(status().isCreated())
            .andExpect(content().json("""
                  {
                   "userEmail": "machin@truc.com",
                   "userName": "machin",
                   "userTweeter": "machin45",
                   "userCountry": "FR",
                   "userSex": "M",
                   "userSexPref": "M",
                   "userAge": 52
                  }
                """)
            );

        verify(agifyService, times(1)).getAge(anyString(), anyString());
    }

    @Test
    @Order(1)
    void get_matches_no_users_registered() throws Exception {
        mockMvc
            .perform(MockMvcRequestBuilders.get("/api/matches")
                .queryParam("userName", "machin")
                .queryParam("userCountry", "FR")
            )
            .andExpect(status().isOk())
            .andExpect(content().json("""
                  []
                """)
            );
    }

    @Test
    @Order(2)
    void get_matches_few_users_registered() throws Exception {
        List<User> users = List.of(
            new User("test1@test.fr", "pierre", "pierre86", "FR", "M", "M", 53),
            new User("test2@test.fr", "jean", "jeanno", "FR", "M", "M", 55),
            new User("test3@test.fr", "thierry", "thenry", "FR", "M", "M", 51),
            new User("test4@test.fr", "julie", "julie", "FR", "F", "M", 32)
        );

        doReturn(users).when(repository).getUsers();

        mockMvc
            .perform(MockMvcRequestBuilders.get("/api/matches")
                .queryParam("userName", "jean")
                .queryParam("userCountry", "FR")
            )
            .andExpect(status().isOk())
            .andExpect(content().json("""
                  [
                      {
                        "name": "pierre",
                        "twitter": "pierre86"
                      },
                      {
                        "name": "thierry",
                        "twitter": "thenry"
                      }
                    ]
                """)
            );

        verify(repository, times(2)).getUsers();
    }
}
