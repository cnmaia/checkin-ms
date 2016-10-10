package br.mack.repository;

import br.mack.model.dto.UserDto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by cmaia on 29/09/16
 */
public interface UserRepository {

    @GET("users/{id}")
    Call<UserDto> find(@Path("id") Long id);
}
