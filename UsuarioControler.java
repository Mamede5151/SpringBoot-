package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.Usuario;
import repository.UsuarioRepository;

@RestController
public class UsuarioControler {
	@Autowired
	private UsuarioRepository repository;
	@GetMapping("/users")
	public List<Usuario> getUsers(){
		return repository.findAll();
		
	}
	@GetMapping("/user/{username}")
	public Usuario getOne(@PathVariable("username") String username) {
		return repository.findByUsername(username);
	}
	@DeleteMapping("/user/{id}")
	public void delete(@PathVariable("id") Integer id) {
		repository.deleteById(id);
	}
	@PostMapping("/user")
	public void postUser(@RequestBody Usuario usuario) {
		repository.save(usuario);
	}
}
