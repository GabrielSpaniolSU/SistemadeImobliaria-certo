package com.example.sistemadeimobliaria.service;


import com.example.sistemadeimobliaria.dto.ClienteDto;
import com.example.sistemadeimobliaria.model.Cliente;
import com.example.sistemadeimobliaria.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteDto> getAllClientes() {
        return clienteRepository
                .findAll()
                .stream()
                .map(cliente -> ClienteDto
                        .builder()
                        .nome(cliente.getNome())
                        .cpf(cliente.getCpf())
                        .email(cliente.getEmail())
                        .dataCadastro(cliente.getDataCadastro())
                        .telefone(cliente.getTelefone())
                        .endereco(cliente.getEndereco())
                        .build()
                )
        .toList();
    }

    public ClienteDto getClienteById(Long id){
        Cliente cliente = clienteRepository.findById(id).orElseThrow();
        return new ClienteDto()
                .builder()
                .nome(cliente.getNome())
                .cpf(cliente.getCpf())
                .email(cliente.getEmail())
                .telefone(cliente.getTelefone())
                .endereco(cliente.getEndereco())
                .dataCadastro(cliente.getDataCadastro())
                .build();
    }

    public Cliente saveCliente(ClienteDto cidadeDto){
        Cliente cliente = new Cliente();
        cliente.setNome(cidadeDto.getNome());
        cliente.setCpf(cidadeDto.getCpf());
        cliente.setEmail(cidadeDto.getEmail());
        cliente.setTelefone(cidadeDto.getTelefone());
        cliente.setEndereco(cidadeDto.getEndereco());
        cliente.setDataCadastro(cidadeDto.getDataCadastro());
        return clienteRepository.save(cliente);
    }

    public ClienteDto clienteEdit(long id, ClienteDto clienteDto){
        Cliente cliente = clienteRepository.findById(id).orElseThrow();
        cliente.setNome(clienteDto.getNome());
        cliente.setCpf(clienteDto.getCpf());
        cliente.setEmail(clienteDto.getEmail());
        cliente.setTelefone(clienteDto.getTelefone());
        cliente.setEndereco(clienteDto.getEndereco());
        cliente.setDataCadastro(clienteDto.getDataCadastro());
        Cliente clienteEdited = clienteRepository.save(cliente);
        return new ClienteDto()
                .builder()
                .nome(clienteEdited.getNome())
                .cpf(clienteEdited.getCpf())
                .email(clienteEdited.getEmail())
                .telefone(clienteEdited.getTelefone())
                .endereco(clienteEdited.getEndereco())
                .dataCadastro(clienteEdited.getDataCadastro())
                .build();
        }

        public boolean deleteCliente(Long id){
        try {
            Cliente cliente = clienteRepository.findById(id).orElseThrow();
            clienteRepository.delete(cliente);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
