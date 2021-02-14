package br.com.roberto.dao;

import br.com.roberto.entity.Categoria;
import br.com.roberto.entity.Contato;
import br.com.roberto.entity.Operadora;

import javax.ejb.Stateless;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Stateless
public class ContatoDao {

    private static List<Contato> contatos = new ArrayList<>();
    private static Long ultimoId;

    public ContatoDao() {
        if (contatos.size()==0){
            this.populaDados();
        }
    }

    public List<Contato> getContatos(){
        return contatos;
    }

    public Contato getContato(Long id){

        Optional<Contato> optContato = contatos.stream().filter(contato -> contato.getId().equals(id)).findAny();
        if (optContato.isPresent()){
            return optContato.get();
        }else{
            return new Contato();
        }


    }

    public void criaContato(Contato contato){
        contatos.add(contato);
        ultimoId+=1;
    }

    public Contato atualizaContato(Long id, Contato contato){
        Optional<Contato> optContato = contatos.stream().filter(contatoInt -> contatoInt.getId().equals(id)).findAny();
        if (optContato.isPresent()){
            contatos.remove(optContato.get());
            contatos.add(contato);
            return contato;
        }else{
            return new Contato();
        }
    }

    public boolean excluiContato(Long id) {
        Optional<Contato> optContato = contatos.stream().filter(contato -> contato.getId().equals(id)).findAny();
        if (optContato.isPresent()) {
            return contatos.remove(optContato.get());
        } else {
            return false;
        }
    }


    private void populaDados(){
        contatos.add(new Contato(1L,"","Carlos Roberto Medeiros de Lima","9999-9999",new Operadora(14,"Oi", Categoria.CELULAR,new BigDecimal(2))));
        contatos.add(new Contato(2L,"","Luciene Alves Medeiros de Lima","8888-8888",new Operadora(15,"Vivo", Categoria.CELULAR, new BigDecimal(1))));
        contatos.add(new Contato(3L,"","Ezequias Alves de Lima","7777-7777",new Operadora(41,"Tim", Categoria.CELULAR, new BigDecimal(3))));
        ultimoId = 3L;
    }

}
