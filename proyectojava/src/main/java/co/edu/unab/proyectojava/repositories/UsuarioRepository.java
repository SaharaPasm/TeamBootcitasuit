package co.edu.unab.proyectojava.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.unab.proyectojava.models.UsuarioModel;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Integer> {
    public ArrayList<UsuarioModel> findByEdadLessThan(int edad);

    public ArrayList<UsuarioModel> findByApellido(String apellido);
}
