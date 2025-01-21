package br.ufrn.imd.yulearn.authentication.services;

import br.ufrn.imd.yulearn.authentication.model.dto.UserDTO;
import br.ufrn.imd.yulearn.authentication.model.entities.User;
import br.ufrn.imd.yulearn.authentication.repositories.UserRepository;
import br.ufrn.imd.yulearn.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService implements UserDetailsService {

    private UserRepository userRepository;
    private Mapper mapper;

    @Autowired
    public UserService(UserRepository userRepository, Mapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public User loadUserByUsername(String username)  {
        User user = userRepository.findByEmail(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }

    public List<UserDTO> findAll() {
        return mapper.convertList(userRepository.findAll(), UserDTO.class);
    }

    public UserDTO findById(String id) {
        var user = userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User not found"));
        return mapper.convertValue(user, UserDTO.class);
    }

    public UserDTO update(UserDTO userDTO, String id) {

        var user = userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User not found"));

        user.setEmail(userDTO.getEmail());
        user.setName(userDTO.getName());

        return mapper.convertValue(userRepository.save(user), UserDTO.class);
    }

    public void deleteById(String id) {
        userRepository.deleteById(id);
    }

}
