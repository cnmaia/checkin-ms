package br.mack.config;

import br.mack.repository.UserRepository;
import com.squareup.okhttp.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit.JacksonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by cmaia on 09/10/16
 */
@Configuration
public class RetrofitConfiguration {

    @Value("${url.users.service}")
    private String usersUrl;

    @Bean
    public OkHttpClient client() {
        return new OkHttpClient();
    }

    @Bean
    public Retrofit retrofit(OkHttpClient client) {
        return new Retrofit.Builder()
                .addConverterFactory(JacksonConverterFactory.create())
                .baseUrl(usersUrl)
                .client(client)
                .build();
    }

    @Bean
    public UserRepository userRepository(Retrofit retrofit) {
        return retrofit.create(UserRepository.class);
    }
}
