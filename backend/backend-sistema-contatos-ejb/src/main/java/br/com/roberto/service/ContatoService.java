package br.com.roberto.service;

import br.com.roberto.dto.ContatoDto;
import br.com.roberto.exceptions.ContatoNaoEncontradoException;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ContatoService {

    List<ContatoDto> recuperaContatos() throws ContatoNaoEncontradoException;

    ContatoDto recuperaContatoPor(Long id) throws ContatoNaoEncontradoException;

    void adicionaContato(ContatoDto contato);

    ContatoDto atualizaContato(Long id, ContatoDto contatoDto);

    boolean removeContato(Long id);

}
