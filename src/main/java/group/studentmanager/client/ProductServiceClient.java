package group.studentmanager.client;
import group.studentmanager.configuration.client.FeignClientConfiguration;
import group.studentmanager.model.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@FeignClient(name = "FakeProduct", url = "https://fakestoreapi.com", configuration = FeignClientConfiguration.class)
public interface ProductServiceClient {


    @GetMapping("/mehemmed")
    List<ProductDto> getallproducts();

    @PostMapping("/products")
    ProductDto addProduct(@RequestBody ProductDto productDto);


}
