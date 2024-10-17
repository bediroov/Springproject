package group.studentmanager.client;
import group.studentmanager.model.dto.FakeStudentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@FeignClient(name = "fakeStudent", url = "https://fake-json-api.mock.beeceptor.com")
public interface StudentServiceClient {

    @GetMapping("/users")
    List<FakeStudentDto> getFakeStudent();


}