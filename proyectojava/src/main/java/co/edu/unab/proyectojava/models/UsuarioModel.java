package co.edu.unab.proyectojava.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuario")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // para que sea campo autoincrementado
    @Column(name = "id_usuario") // esto no es obligatorio ya q el mismo framwork se encarga de los guion al piso
    private int idUsuario;
    @Column(name = "numero_documento")
    private int numeroDocumento;
    @Column(name = "tipo_documento")
    private String tipoDocumento;
    @Column(name = "correo_electronico")
    private String email;
    private String estado;
    private String genero;
    private String nombres;
    private String apellidos;
    private int edad;
    private String contraseña;
    @Column(name = "tipo_usuario")
    private String tipoUsuario;
    private boolean status;

}
