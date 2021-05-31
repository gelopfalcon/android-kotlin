import com.example.carddemo.services.dto.TechTalkDto
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface TechTalkService {
    @GET("/api/v1/tech-talks")
    fun getTechTalks(): Call<List<TechTalkDto>>

    @POST("/api/v1/tech-talks/{id}")
    fun createTechTalk(@Path("id") id: String): Call<TechTalkDto>
}