package fr.esiea.ex4A.agify;

import fr.esiea.ex4A.agify.mock.AgifyServiceMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import retrofit2.Call;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class AgifyServiceTest {

    @Mock
    private final AgifyService agifyService;

    AgifyServiceTest() {
        this.agifyService = new AgifyService(AgifyServiceMock.getAgifyClientMock());
    }

    @Test
    void get_age_of_jean_fr() throws IOException {
        assertThat(agifyService.getAge("Jean", "FR")).isEqualTo(68);
    }
}
