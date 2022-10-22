package co.edu.unab.proyectojava.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unab.proyectojava.models.UsuarioModel;
import co.edu.unab.proyectojava.repositories.UsuarioRepository;

@Service
public class UsuarioServices {
    @Autowired // se autoestancia
    UsuarioRepository usuarioRepository;

    public Iterable<UsuarioModel> getUsuario() {
        return usuarioRepository.findAll();
    }

    public Optional<UsuarioModel> getUsuarioByid(int id) {
        return usuarioRepository.findById(id);
    }

    // save guarda si el objeto a guardar no existe en la tabla, si existe actualiza
    public String SaveUsuario(UsuarioModel usuario) {
        boolean existe = usuarioRepository.existsById(usuario.getIdUsuario());// consulta si el registro esta en base de
                                                                              // datos
        usuarioRepository.save(usuario); // guarda o actualiza
        if (existe)
            return "actualizo";
        else
            return "se ha guardado registro";
    }

    public String DeleteUsuario(int id) {
        try {
            usuarioRepository.deleteById(id);
            return "borrado con exito";
        } catch (Exception e) {
            return "error";
        }
    }

    public ArrayList<UsuarioModel> getUsuarioMenorEdad(int edad) {
        return usuarioRepository.findByEdadLessThan(edad);
    }

    public ArrayList<UsuarioModel> getUsuarioApellido(String apellido) {
        return usuarioRepository.findByApellido(apellido);
    }
}
