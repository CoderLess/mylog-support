package com.ibn;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @version 1.0
 * @description:
 * @projectName：mylog-support
 * @see: com.ibn
 * @author： RenBin
 * @createTime：2020/1/20 15:17
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.ibn.dao"})
public class ApplicationStarter {
    private final static Logger logger = LoggerFactory.getLogger(ApplicationStarter.class);
    private static final String SERVER_PORT = "server.port";
    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext application = SpringApplication.run(ApplicationStarter.class, args);
        Environment env = application.getEnvironment();
        logger.info("\n----------------------------------------------------------\n\t" +
                        "Application '{}' is running! Access URLs:\n\t" +
                        "External: \thttp://{}:{}\n\t"+
                        "API测试: \thttp://{}:{}/swagger-ui.html\n\t"+
                        "API文档: \thttp://{}:{}/doc.html\n"+
                        "----------------------------------------------------------",
                env.getProperty("spring.application.name"),
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty(SERVER_PORT),
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty(SERVER_PORT),
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty(SERVER_PORT));
    }
}
