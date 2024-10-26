/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.cuychair.gui.gui.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class PaperDTO {
    private Integer id;
    private String title;
    private String Abstract;
    private String subtitle;
    private int authorId;
    private int conferemceId;

    public PaperDTO() {
    }
}