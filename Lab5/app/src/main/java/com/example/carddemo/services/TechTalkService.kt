import com.example.carddemo.services.dto.TechTalkDto
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface TechTalkService {
    @GET("/api/v1/tech-talks")
    fun getTechTalks(): Call<List<TechTalkDto>>
}