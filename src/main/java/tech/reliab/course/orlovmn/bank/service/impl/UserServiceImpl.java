package tech.reliab.course.orlovmn.bank.service.impl;

import tech.reliab.course.orlovmn.bank.entity.Bank;
import tech.reliab.course.orlovmn.bank.entity.User;
import tech.reliab.course.orlovmn.bank.service.UserService;

import java.util.Date;
import java.util.Random;

public class UserServiceImpl implements UserService {
    private Long id = 0L;
    private Random random = new Random();
    private User user;

    /**
     *
     * @param fullName - имя клиента
     * @param birthDate - дата рождения клиента
     * @param job - место работы
     * @param bank - банк
     * @return - возвращает созданный объект клиент
     */
    @Override
    public User create(String fullName, Date birthDate, String job, Bank bank){
        double salary = random.nextInt(10000);
        user = new User(
                ++id,
                fullName,
                birthDate,
                job,
                salary,
                bank,
                null,
                null,
                salary / 10
        );
        return user;
    }

    /**
     *
     * @return - возвращает объект клиент
     */
    @Override
    public User read(){
        return user;
    }

    /**
     *
     * @param user - новый клиент
     */
    @Override
    public void update(User user){
        this.user = user;
    }

    /**
     *
     * @param user - клиент для удаления
     */
    @Override
    public void delete(User user){
        if(this.user == user){
            this.user = null;
        }
    }
}
