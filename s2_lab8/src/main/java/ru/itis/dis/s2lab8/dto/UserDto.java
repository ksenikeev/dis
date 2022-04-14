package ru.itis.dis.s2lab8.dto;

import lombok.Data;

/*
    Класс для передачи данных из формы в контроллер

    <form method="post"  action="/save">
        <div><label for="username">username:</label><input type="text" name="userName" id="username"></div>
        <div><label for="password">passsword:</label><input type="text" name="password" id="password"></div>
        <div><label for="passport">passport:</label><input type="text" name="passport" id="passport"></div>
        <div><label for="email">email:</label><input type="text" name="email" id="email"></div>
        <div><input type="submit"></div>
    </form>
*/
@Data
public class UserDto {
    private String userName;
    private String password;
    private String passport;
    private String email;
}
