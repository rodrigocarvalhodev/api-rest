package net.rodrigocarvalho.apirest.controller.v1;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import net.rodrigocarvalho.apirest.model.request.UserRequest;
import net.rodrigocarvalho.apirest.model.response.UserResponse;
import net.rodrigocarvalho.apirest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService service;

    @ApiOperation("API responsável pela criação de usuários")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Criou um usuário"),
            @ApiResponse(code = 500, message = "Ocorreu uma exceção ao criar o usuário.")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UserResponse> create(@RequestBody @Valid UserRequest request) {
        return ResponseEntity.ok(service.create(request));
    }

    @ApiOperation("API responsável pela busca de usuários por paginação")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Busca realizada com sucesso."),
            @ApiResponse(code = 500, message = "Ocorreu um exceção ao obter os usuários")
    })
    @GetMapping
    public ResponseEntity<Page<UserResponse>> getAll(Pageable pageable) {
        return ResponseEntity.ok(service.getAll(pageable));
    }

    @ApiOperation("API responsável pela busca de usuários por id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Busca realizada com sucesso."),
            @ApiResponse(code = 404, message = "Usuário não encontrado"),
            @ApiResponse(code = 500, message = "Ocorreu um exceção ao obter o usuário")
    })
    @GetMapping("{id}")
    public ResponseEntity<UserResponse> get(@PathVariable Long id) {
        return service.get(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @ApiOperation("API responsável pela atualização de usuários")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Atualização realizada com sucesso."),
            @ApiResponse(code = 404, message = "Usuário não encontrado"),
            @ApiResponse(code = 500, message = "Ocorreu um exceção ao atualizar o usuário")
    })
    @PutMapping
    public ResponseEntity<UserResponse> update(@PathVariable Long id, UserRequest request) {
        return service.update(id, request)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @ApiOperation("API responsável pela deleção de usuários")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Deletado com sucesso."),
            @ApiResponse(code = 500, message = "Ocorreu um exceção ao atualizar o usuário")
    })
    @DeleteMapping
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}