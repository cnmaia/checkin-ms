package br.mack.repository;

import br.mack.model.User;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by cmaia on 29/09/16
 */
public interface UserRepository {

    @GET("/users/{id}")
    Call<User> find(@Path("id") Long id);
}
