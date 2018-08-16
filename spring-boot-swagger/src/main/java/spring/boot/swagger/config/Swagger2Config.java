//package spring.boot.swagger.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//@Configuration
//@EnableSwagger2
//public class Swagger2Config {
//	
//	public static final String SWAGGER_SCAN_BASE_PACKAGE = "spring.boot.swagger.controller";
//    public static final String VERSION = "1.0.0";
//
//    @Bean
//    public Docket createRestApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE))//api接口包扫描路径
//                .paths(PathSelectors.any())//可以根据url路径设置哪些请求加入文档，忽略哪些请求
//                .build();
//    }
//    
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//            .title("Swagger2 接口文档示例")//设置文档的标题
//            .description("更多内容请关注：http://www.abc.com")//设置文档的描述->1.Overview
//            .version(VERSION)//设置文档的版本信息-> 1.1 Version information
//            .contact(new Contact("ABC Boot", "http://www.abc.comt", ""))//设置文档的联系方式->1.2 Contact information
//            .termsOfServiceUrl("www.abc.com")//设置文档的License信息->1.3 License information
//            .build();
//    }
//
//}
