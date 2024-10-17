package group.studentmanager.configuration.client;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class StudentErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder defaultErrorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        switch (response.status()) {
            case 504:
                log.error("TIME_OUT");
                return new StudentBadRequestException("TIME_OUT_EXAMPLE");
            case 400:
                log.error("Error 400: Bad Request from Feign Client - Method: {}", methodKey);
                return new StudentBadRequestException("400 Error: Bad Request from Feign Client");
            case 404:
                log.error("Error 404: elcan burda hecne not found - Method: {}", methodKey);
                return new StudentNotFountException("404 Error: Resource not found from Feign Client");
            default:
                log.error("Unexpected error: Status code {} - Method: {}", response.status(), methodKey);
                return defaultErrorDecoder.decode(methodKey, response);
        }
    }
}
