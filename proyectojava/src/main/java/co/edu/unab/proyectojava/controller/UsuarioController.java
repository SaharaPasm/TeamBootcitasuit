package co.edu.unab.proyectojava.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unab.proyectojava.models.UsuarioModel;
import co.edu.unab.proyectojava.services.UsuarioServices;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE })
@RequestMapping(path = "/usuario")

public class UsuarioController {
    @Autowired
    UsuarioServices usuarioServices;

    @GetMapping(path = "/all")
    public Iterable<UsuarioModel> getAllUsuario() {
        return usuarioServices.getUsuario();
    }

    @GetMapping(path = "{id}")
    public Optional<UsuarioModel> getUsuarioByid(@PathVariable("id") int id) {
        return usuarioServices.getUsuarioByid(id);
    }

    @PostMapping(path = "/guardar")
    public String guardarPaciente(@RequestBody UsuarioModel usuario) {
        return usuarioServices.SaveUsuario(usuario);
    }

    @DeleteMapping(path = "{id}")
    public String DeleteUsuarioById(@PathVariable("id") int id) {
        return usuarioServices.DeleteUsuario(id);

    }

    @GetMapping("/query")
    public ArrayList<UsuarioModel> obtenerPacientePorApellido(@RequestParam("apellido") String apellido) {
        return usuarioServices.getUsuarioApellido(apellido);

    }

    @GetMapping("edad/query")
    public ArrayList<UsuarioModel> obtenerPacientesMenoresQue(@RequestParam("edad") int edad) {
        return usuarioServices.getUsuarioMenorEdad(edad);

    }

}
