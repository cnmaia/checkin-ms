package br.mack.config;

import br.mack.repository.UserRepository;
import com.squareup.okhttp.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit.JacksonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by cmaia on 09/10/16
 */
@Configuration
public class RetrofitConfiguration {

    @Bean
    public OkHttpClient client() {
        return new OkHttpClient();
    }

    @Bean
    public Retrofit retrofit(OkHttpClient client) {
        return new Retrofit.Builder()
                .addConverterFactory(JacksonConverterFactory.create())
                .baseUrl("http://localhost:8081/users/api")
                .client(client)
                .build();
    }

    @Bean
    public UserRepository userRepository(Retrofit retrofit) {
        return retrofit.create(UserRepository.class);
    }
}
