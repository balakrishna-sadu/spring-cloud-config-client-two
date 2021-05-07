package spring.cloud.config.clienttwo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ClientTwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientTwoApplication.class, args);
	}

}

@RefreshScope
@RestController
class MessageRestController {

	@Value("${bar.foo:Unable to connect to config server}")
	private String message1;

	//gitUri = https://github.com/solivaf/config-properties-foo
	@RequestMapping("/app-foo/message")
	String getMsg() {
		return this.message1+":bar.foo";
	}
}