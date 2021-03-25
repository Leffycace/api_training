package fr.esiea.ex4A.agify.mock;

import fr.esiea.ex4A.agify.AgifyClient;
import retrofit2.Call;
import retrofit2.mock.BehaviorDelegate;

import java.util.HashMap;
import java.util.Map;

public class AgifyClientMock implements AgifyClient {

    private final BehaviorDelegate<AgifyClient> delegate;

    public AgifyClientMock(BehaviorDelegate<AgifyClient> delegate) {
        this.delegate = delegate;
    }

    @Override
    public Call<Map<String, String>> getAge(String name, String countryId) {
        Map<String, String> response = new HashMap<>();
        response.put("name", name);
        response.put("country_id", countryId);
        response.put("age", "68");

        return delegate.returningResponse(response).getAge(name, countryId);
    }
}
