package br.edu.infnet.appAndreas.model.service;

import br.edu.infnet.appAndreas.dto.AgenciaDto;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appAndreas.model.domain.Agencia;
import br.edu.infnet.appAndreas.repository.AgenciaRepository;

import java.util.List;

@Service
public class AgenciaService {

    @Autowired
    private AgenciaRepository agenciaRepository;

    @Autowired
    private ModelMapper modelMapper;

    public AgenciaDto incluir(AgenciaDto agenciaDto) {
        Agencia agencia = modelMapper.map(agenciaDto, Agencia.class);
        agenciaRepository.save(agencia);

        return modelMapper.map(agencia, AgenciaDto.class);
    }

    public AgenciaDto alterar(AgenciaDto agenciaDto) {
        Agencia agencia = modelMapper.map(agenciaDto, Agencia.class);
        agenciaRepository.save(agencia);

        return modelMapper.map(agencia, AgenciaDto.class);
    }

    public List<AgenciaDto> obterLista() {
        return agenciaRepository.findAll().stream().map(p -> modelMapper.map(p, AgenciaDto.class)).toList();
    }

    public AgenciaDto obterPorId(Integer id) {
        //return agenciaRepository.findById(id).orElse(null);

        Agencia agencia = agenciaRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        return modelMapper.map(agencia, AgenciaDto.class);
    }

    public void excluir(Integer id) {
        agenciaRepository.deleteById(id);
    }

    public long obterQtde() {
        return agenciaRepository.count();
    }

    public AgenciaDto obterPorCodigo(String codigo) {
        //return agenciaRepository.findByCodigo(codigo);

        Agencia agencia = agenciaRepository.findByCodigo(codigo);
        return modelMapper.map(agencia, AgenciaDto.class);
    }
}
