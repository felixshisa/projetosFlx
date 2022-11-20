package com.example.demo.domain.repository;

import com.example.demo.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

//@Repository não é mais necessário pois a interface que herda o JpaRepository já é um repository
public interface Clientes extends JpaRepository<Cliente, Integer> {

    // Query Methods:

    // faz a query por nome baseado na convenção do nome do método

    @Query(value = " select * from cliente c where c.nome like '%:nome%' ", nativeQuery = true)
    List<Cliente> encontrarPorNome( @Param("nome") String nome );

    @Query(" delete from Cliente c where c.nome =:nome ")
    @Modifying
    void deleteByNome(String nome);

    boolean existsByNome(String nome);

    @Query(" select c from Cliente c left join fetch c.pedidos where c.id = :id  ")
    Cliente findClienteFetchPedidos( @Param("id") Integer id );


//    @Query(value = "SELECT C FROM CLIENTE WHERE c.nome Like :nome") // insere o código SQL e injeta no método sem precisar do nome específico(Ex.:findByNomeLike())
//    // também há como executar sql nativo usado o (@Query(value = "códigoSql, nativeQuery = true)
//    List<Cliente> encontrarPorNome(@Param(value = "nome") String nome);
//    // é necessário o @Param para indicar o parâmetro que será usado na query do @Query
//
//    @Query(value = "DELETE FROM CLIENTE C WHERE C.nome = :nome")
//    @Modifying // como não é um método de consulta e sim de alteração, precisa da annotation @Modifying
//    void deleteByNome(@Param(value = "nome") String nome);
//
//    //pesquisar sobre query methods para achar mais naming conventions
//    List<Cliente> findByNomeLike(String nome, Integer id);
//
//
//    boolean existsByNome(String nome);
//
//    @Query(" SELECT C FROM Cliente C LEFT JOIN FETCH C.Pedidos WHERE c.id =:id")
//    Cliente findClienteFetchPedidos(@Param("id") Integer id);




//    @Autowired
//    private EntityManager entityManager;
//
//    @Transactional // É necessário, diferente do JdbcTemplate, colocar a annotation @Transaction
//    //para indicar ao EntityManager que o método fará uma transação na base de dados
//    public Cliente salvar(Cliente cliente) {
//        entityManager.persist(cliente);
//        return cliente;
//        //entity manager reconhece as entidades mapeadas e já faz toda a persistência
//    }
//
//    @Transactional
//    public Cliente atualizar(Cliente cliente) {
//        entityManager.merge(cliente); // .merge serve para atualizar o objeto na base de dados.
//        return cliente;
//    }
//
//    @Transactional
//    public void deletar(Integer id) { //passa o id
//        // em seguida, cria uma instância de cliente é o cliente encontrado pelo id com o método .find
//        Cliente cliente = entityManager.find(Cliente.class, id);
//        // deleta o cliente encontrado pelo id usando o outro método.
//        deletar(cliente);
//    }
//
//    @Transactional
//    public void deletar(Cliente cliente) {
//        if (!entityManager.contains(cliente)) { // verifica se o cliente está sincronizado com o entityManager, depois sincroniza-o
//            entityManager.merge(cliente); // pois se o cliente não estiver no estado "Managed" ele não pode ser excluído
//        }
//
//        entityManager.remove(cliente);
//    }
//
//    @Transactional (readOnly = true)
//    public  List<Cliente> buscarPorNome(String nome) {
//        String jpql = "SELECT c FROM CLIENTE c WHERE c.nome like :nome "; // parâmetro setado por :
//        TypedQuery<Cliente> query = entityManager.createQuery(jpql, Cliente.class); // query é criada.
//        query.setParameter("nome", "%" + nome + "%"); // .setparameter define qual é o parâmetro definido na query pelos :
//        return query.getResultList(); // retorna o resultado da query como uma lista
//    }
//
//    //obtem todos os clientes salvos na tabela Clientes
//    public List<Cliente> obterTodos() {
//        return entityManager // método entende que tem de selecionar todos apenas com o FROM CLIENTE
//                .createQuery("FROM CLIENTE", Cliente.class).getResultList();
//        // retorna todos os clientes da tabela, método retorna uma TypedQuery então o .getResultList() é necessário
//        // pois retorna em lista
//    }

//    private RowMapper<Cliente> obterClienteMapper() {
//        //é usado o RowMapper para pegar o resultado da query e colocar tudo numa classe.
//        return new RowMapper<Cliente>() {
//            @Override
//            public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
//                //usa o parâmetro ResultSet(resultado da consulta).
//                Integer id = rs.getInt("id");
//                String nome = rs.getString("nome");
//                return new Cliente(id, nome);
//                //o resultSet pega a String da colunas especificada com o parâmetro columnLabel e define no construtor que criamos
//            }
//        };
//
//    }
}
