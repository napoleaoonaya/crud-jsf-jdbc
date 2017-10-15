/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agenda.controller;

import br.com.agenda.dao.ClienteDAO;
import br.com.agenda.model.Cliente;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Napoleao Kazu Onaya
 */
@ManagedBean
@RequestScoped
public class ClienteController {

    private Cliente cliente;

    public ClienteController() {
        cliente = new Cliente();
    }

    public void inserir() {
        new ClienteDAO().inserir(getCliente());
    }

    public void deletar() {
        new ClienteDAO().deletar(getCliente());
    }

    public List<Cliente> selecionaTodos() {

        ResultSet result = new ClienteDAO().selecionaTodos();

        List<Cliente> clientes = new ArrayList<Cliente>();

        Cliente c;

        try {

            while (result.next()) {
                c = new Cliente();
                c.setNome(result.getString("nome"));
                c.setTelefone(result.getString("telefone"));
                clientes.add(c);
            }
            return clientes;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
