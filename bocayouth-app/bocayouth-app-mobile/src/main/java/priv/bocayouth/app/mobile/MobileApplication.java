package priv.bocayouth.app.mobile;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;

@Log4j2
@SpringBootApplication(scanBasePackages = "priv.bocayouth.**")
public class MobileApplication implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("(♥◠‿◠)ﾉﾞ  Mobile Application 启动成功   ლ(´ڡ`ლ)ﾞ");
    }

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(MobileApplication.class);
        application.setApplicationStartup(new BufferingApplicationStartup(2048));
        application.run(args);
    }
}
