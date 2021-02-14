package br.com.roberto.service.impl;

import br.com.roberto.dao.ContatoDao;
import br.com.roberto.dto.ContatoDto;
import br.com.roberto.entity.Contato;
import br.com.roberto.exceptions.ContatoNaoEncontradoException;
import br.com.roberto.service.ContatoService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;


@Stateless
public class ContatoServiceImpl implements ContatoService {

    @Inject
    ContatoDao contatoDao;

    @Override
    public List<ContatoDto> recuperaContatos() throws ContatoNaoEncontradoException {
        List<Contato> contatos = contatoDao.getContatos();
        List<ContatoDto> contatosDto = new ArrayList<>();

        contatos.forEach(contato -> {
            contatosDto.add(converteContatoParaContatoDTO(contato));
        });

        return contatosDto;
    }

    @Override
    public ContatoDto recuperaContatoPor(Long id) throws ContatoNaoEncontradoException {
        Contato contato = contatoDao.getContato(id);
        return converteContatoParaContatoDTO(contato);
    }

    @Override
    public void adicionaContato(ContatoDto contato) {
        contatoDao.criaContato(converteContatoDtoParaContato(contato));
    }

    @Override
    public ContatoDto atualizaContato(Long id, ContatoDto contatoDto) {
        Contato contatoInterno =  contatoDao.atualizaContato(id,converteContatoDtoParaContato(contatoDto));
        return converteContatoParaContatoDTO(contatoInterno);
    }

    @Override
    public boolean removeContato(Long id) {
        return contatoDao.excluiContato(id);
    }

    private ContatoDto converteContatoParaContatoDTO(Contato contato) {
        ContatoDto contatoDto = new ContatoDto();
        contatoDto.setId(contato.getId());
        contatoDto.setData(contato.getData());
        contatoDto.setNome(contato.getNome());
        contatoDto.setSerial(contato.getSerial());
        contatoDto.setTelefone(contato.getTelefone());
        contatoDto.setOperadora(contato.getOperadora());
        return contatoDto;
    }

    private Contato converteContatoDtoParaContato(ContatoDto contatoDto) {
        Contato contato = new Contato();
        contato.setId(contatoDto.getId());
        contato.setData(contatoDto.getData());
        contato.setNome(contatoDto.getNome());
        contato.setSerial(contatoDto.getSerial());
        contato.setTelefone(contatoDto.getTelefone());
        contato.setOperadora(contatoDto.getOperadora());
        return contato;
    }

}
