#s2_lab10UserLoginFormSpringSecurity
[проект](https://github.com/ksenikeev/dis/tree/master/s2_lab10UserLoginFormSpringSecurity) 
демонстрирует возможности __SpringBootSecurity__
по аутентификации через свою форму и разграничение доступа к ресурсам

1. Данные пользователей храняться в БД, пароль хешируется алгоритмом BCrypt
2. Создаем класс на основе интерфейса *UserDetails*, чтобы Spring мог
 работать с нашими пользователями
3. Создаем класс на основе интерфейса *UserDetailsService*, чтобы Spring мог
 искать пользователя по имени в нашей БД
4. Настраиваем конфигурацию SpringSecurity. В проекте для этого используется 
класс *WebSecurityConfig* который наследуется от *WebSecurityConfigurerAdapter*
5. Над классом ставим аннотацию *@Configuration*
6. Аннотация *@EnableWebSecurity* определяет класс, как конфигуратор 
аутентификации
7. Аннотация *@EnableGlobalMethodSecurity(securedEnabled=true)* позволяет организовать
ограничение доступа для методов web-контроллеров
8. Ограничение доступа можно задать в конфигурации:
````
        http.authorizeRequests()
                .antMatchers("/resources/**").permitAll()
                .antMatchers("/").authenticated()
                .antMatchers("/org").hasAnyAuthority("ADMIN")
                .anyRequest().authenticated();
````
или в контроллере:
````
@Controller
public class AllOrganizationController {
    //@Secured({"ADMIN"})
    //@PreAuthorize("permitAll()")
    //@PreAuthorize("isAuthentificated()")
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/org")
    public String getAllOrganization(Model model) {
        return "allorg";
    }
}
````