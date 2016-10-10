package br.mack.service.helper;

import br.mack.exception.IntegrationException;
import br.mack.exception.ResourceNotFoundException;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class ServiceHelper {

    public static <T> T executeCall(Call<T> call) throws IntegrationException, ResourceNotFoundException {
        try {
            Response<T> response = call.execute();
            if (response.isSuccessful())
                return response.body();
            if (response.code() == 404)
                throw new ResourceNotFoundException(response.errorBody().string());
            throw new IntegrationException(response.errorBody().string());
        } catch (IOException ex) {
            throw new IntegrationException("Error getting entity", ex);
        }
    }

    public static Long executeCallAndGetNewId(Call<Void> call) throws IntegrationException {
        try {
            Response<Void> response = call.execute();
            if (response.isSuccessful())
                return Long.parseLong(response.headers().get("ETag").replace("\"", ""));
            if (response.code() == 404)
                throw new ResourceNotFoundException(response.errorBody().string());
            throw new IntegrationException(response.errorBody().string());
        } catch (IOException ex) {
            throw new IntegrationException("Error getting entity", ex);
        } catch (NumberFormatException ex) {
            throw new IntegrationException("Entity was created but its id is invalid", ex);
        }
    }
}
