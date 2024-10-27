/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.cuychair.gui.gui.services;

import co.edu.unicauca.cuychair.gui.gui.DTO.UserDTO;
import co.edu.unicauca.cuychair.gui.gui.controller.UserController;

/**
 *
 * @author julia
 */
public class UserServices {
    UserController userController;
    public UserDTO getUserById(int id) {
        return userController.getUserById(id);
    }

    public UserDTO addUser(UserDTO userDTO) {
        return userController.addUser(userDTO);
    }
}
