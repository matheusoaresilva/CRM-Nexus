package com.matheus.crm.user.service;

import com.matheus.crm.user.dto.UserDTO;
import com.matheus.crm.user.entity.UserModel;
import com.matheus.crm.user.repository.UserRepository;
import com.matheus.crm.user.service.exceptions.DatabaseException;
import com.matheus.crm.user.service.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;


@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private ModelMapper modelMapper;


    public Page<UserDTO> getAllUsers(Pageable pageable){
        return repository.findAll(pageable)
                .map(p-> modelMapper.map(p, UserDTO.class));
    }

    public UserDTO findUserById(Long id){
        UserModel user = repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("User with id: "+ id +" not found!"));

        return modelMapper.map(user, UserDTO.class);
    }

    @Transactional
    public UserDTO createUser(UserDTO dto){
        UserModel user = repository.save(modelMapper.map(dto, UserModel.class));

        return modelMapper.map(user, UserDTO.class);
    }

    public UserDTO updateUser(Long id, UserDTO dto){
        UserModel user = repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("User with id: "+ id +" not found!"));

        modelMapper.map(dto, user);
        UserModel saveUser = repository.save(user);

        return modelMapper.map(saveUser, UserDTO.class);
    }

    public void deleteById(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException("Id not found!");
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        }
    }
}
