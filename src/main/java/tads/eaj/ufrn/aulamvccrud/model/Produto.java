package tads.eaj.ufrn.aulamvccrud.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    Date deleted;
    String imageURI;
    @NotBlank
    @Size(max = 20, min = 4)
    String nome;
    @NotBlank
    Float preco;
    String tipo;
    String material;
    Float tamanho;
    String cor;

//    public void tituloMaiusculo(){
//        this.titulo.toUpperCase();
//    }
}
