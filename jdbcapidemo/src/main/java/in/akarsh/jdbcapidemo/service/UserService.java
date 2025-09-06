package in.akarsh.jdbcapidemo.service;

import in.akarsh.jdbcapidemo.model.User;
import in.akarsh.jdbcapidemo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<User> findAll(){
        return userRepository.findAll();
    }

    public void createUser(User user) {
        userRepository.createUser(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteUser(id);

    }

    public User findUserById(Long id) {
      return  userRepository.findUserByID(id);
    }

    public void updateUser(User user) {
        userRepository.update(user);
    }
}
