package main.java.ch.planner.plannersvc.config;


@Configuration
public class WebConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer(){
            @Override
            public void addCorsMapping(CorsRegistry registry){
                registry.addMapping("/**").allowedOrigins("http://localhost:4200");
            }
        }
    }
}
