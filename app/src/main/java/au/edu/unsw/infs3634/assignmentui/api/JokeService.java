package au.edu.unsw.infs3634.assignmentui.api;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JokeService {
    @GET("jokes/random")
    Call<JokeResponse> getJoke(@Query("category") String category);
}
