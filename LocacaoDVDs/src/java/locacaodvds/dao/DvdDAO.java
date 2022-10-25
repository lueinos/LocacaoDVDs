/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locacaodvds.dao;

import locacaodvds.entidades.ClassificacaoEtaria;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import locacaodvds.entidades.Ator;
import locacaodvds.entidades.Dvd;
import locacaodvds.entidades.Genero;

/**
 *
 * @author Octavio, Luana
 */
public class DvdDAO extends DAO<Dvd>{
    public DvdDAO() throws SQLException {
    }

    @Override
    public void salvar( Dvd obj ) throws SQLException {

        PreparedStatement stmt = getConnection().prepareStatement(
                "INSERT INTO " + 
                "dvd(" + 
                "    titulo, " + 
                "    ano_lancamento, " + 
                "    ator_principal_id, " + 
                "    ator_coadjuvante_id, " + 
                "    data_lancamento, " + 
                "    duracao_minutos, " + 
                "    classificacao_etaria_id, " + 
                "    genero_id) " +
                "VALUES( ?, ?, ?, ?, ?, ?, ?, ?);" );
                
        
        
        stmt.setString( 1, obj.getTitulo() );
        stmt.setInt( 2, obj.getAnoLancamento() );
        stmt.setInt( 3, obj.getAtorPrincipal().getId() );
        stmt.setInt( 4, obj.getAtorCoadjuvante().getId() );
        stmt.setDate( 5, obj.getDataLancamento() );
        stmt.setInt( 6, obj.getDuracaoMinutos() );
        System.out.println(obj.getDuracaoMinutos());
        stmt.setInt( 7, obj.getClassificacaoEtaria().getId());
        stmt.setInt( 8, obj.getGenero().getId() );

        
        stmt.executeUpdate();
        
        
        stmt.close();

    }

    @Override
    public void atualizar( Dvd obj ) throws SQLException {

        PreparedStatement stmt = getConnection().prepareStatement(
                "UPDATE dvd " + 
                "SET" + 
                "    titulo = ?, " + 
                "    ano_lancamento = ?, " + 
                "    ator_principal_id = ?, " + 
                "    ator_coadjuvante_id = ?, " + 
                "    data_lancamento = ?, " + 
                "    duracao_minutos = ?, " + 
                "    classificacao_etaria_id = ?, " + 
                "    genero_id = ? " + 
                "WHERE" + 
                "    id = ?;" );

        
        stmt.setString( 1, obj.getTitulo() );
        System.out.println(obj.getTitulo());
        stmt.setInt( 2, obj.getAnoLancamento() );
        System.out.println(obj.getAnoLancamento());
        stmt.setInt( 3, obj.getAtorPrincipal().getId() );
        System.out.println(obj.getAtorPrincipal().getId());
        stmt.setInt( 4, obj.getAtorCoadjuvante().getId() );
        System.out.println(obj.getAtorCoadjuvante().getId());
        stmt.setDate( 5, obj.getDataLancamento() );
        System.out.println(obj.getDataLancamento());
        stmt.setInt( 6, obj.getDuracaoMinutos() );
        System.out.println(obj.getDuracaoMinutos());
        stmt.setInt( 7, obj.getClassificacaoEtaria().getId());
        System.out.println(obj.getClassificacaoEtaria().getId());
        stmt.setInt( 8, obj.getGenero().getId() );
        
        stmt.setInt( 9, obj.getId() );
        System.out.println(obj.getId());

        stmt.executeUpdate();
        stmt.close();

    }

    @Override
    public void excluir( Dvd obj ) throws SQLException {

        PreparedStatement stmt = getConnection().prepareStatement(
                "DELETE FROM dvd " + 
                "WHERE" + 
                "    id = ?;" );

        stmt.setInt( 1, obj.getId() );

        stmt.executeUpdate();
        stmt.close();

    }

 @Override
    public List<Dvd> listarTodos() throws SQLException {

        List<Dvd> lista = new ArrayList<>();

        PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT" + 
                "    d.id as idDvd, " + 
                "    d.titulo, " + 
                "    d.ano_lancamento, " +
                "    d.data_lancamento, " +
                "    d.duracao_minutos, " +
                "    d.ator_principal_id, " +
                "    d.ator_coadjuvante_id, " +
                "    d.genero_id, " +
                "    d.classificacao_etaria_id, " +
                "    g.id as idGenero, " + 
                "    g.descricao as descricaoGenero, "+
                "    c.id as idClassificacaoEtaria, " +
                "    c.descricao as descricaoClassificacaoEtaria, " +
                "(SELECT id FROM ator where ator.id = ator_principal_id) as idAtorPrincipal,"+
                "(SELECT nome from ator where ator.id = ator_principal_id) as nomeAtorPrincipal,"+
                "(SELECT sobrenome from ator where ator.id = ator_principal_id) as sobreNomeAtorPrincipal,"+
                "(SELECT data_estreia from ator where ator.id = ator_principal_id) as dataEstreiaAtorPrincipal,"+
                "(SELECT id from ator where ator.id = ator_coadjuvante_id) as idAtorCoadjuvante,"+
                "(SELECT nome from ator where ator.id = ator_coadjuvante_id) as nomeAtorCoadjuvante,"+
                "(SELECT sobrenome from ator where ator.id = ator_coadjuvante_id) as sobreNomeAtorCoadjuvante,"+
                "(SELECT data_estreia from ator where ator.id = ator_coadjuvante_id) as dataEstreiaAtorCoadjuvante "+
                "FROM" + 
                "    dvd d, " + 
                "    genero g, " + 
                "    classificacao_etaria c " +
                        
                "WHERE" + 
                "    g.id = d.genero_id AND " +
                "    c.id = d.classificacao_etaria_id;");
                
 
        ResultSet rs = stmt.executeQuery();

        while ( rs.next() ) {

            Dvd d = new Dvd();
            Ator atorPrincipal = new Ator();
            Ator atorCoadjuvante = new Ator();
            Genero g = new Genero();
            ClassificacaoEtaria c = new ClassificacaoEtaria();
            
            atorPrincipal.setId(rs.getInt("idAtorPrincipal"));
            atorPrincipal.setNome(rs.getString("nomeAtorPrincipal"));
            atorPrincipal.setSobreNome(rs.getString("sobreNomeAtorPrincipal"));
            atorPrincipal.setDataEstreia(rs.getDate("dataEstreiaAtorPrincipal"));

            atorCoadjuvante.setId(rs.getInt("idAtorCoadjuvante"));
            atorCoadjuvante.setNome(rs.getString("nomeAtorCoadjuvante"));
            atorCoadjuvante.setSobreNome(rs.getString("sobreNomeAtorCoadjuvante"));
            atorCoadjuvante.setDataEstreia(rs.getDate("dataEstreiaAtorCoadjuvante"));

            g.setId(rs.getInt("idGenero"));
            g.setDescricao(rs.getString("descricaoGenero"));
            
            c.setId(rs.getInt("idClassificacaoEtaria"));
            c.setDescricao(rs.getString("descricaoClassificacaoEtaria"));
               
            d.setId(rs.getInt("idDvd"));
            d.setTitulo(rs.getString("titulo"));
            d.setAnoLancamento(rs.getInt("ano_lancamento"));
            d.setDataLancamento(rs.getDate("data_lancamento"));
            d.setDuracaoMinutos(rs.getInt("duracao_minutos"));
 
            d.setGenero(g);
            d.setClassificacaoEtaria(c);
            d.setAtorPrincipal(atorPrincipal);
            d.setAtorCoadjuvante(atorCoadjuvante);

            lista.add( d );

        }

        rs.close();
        stmt.close();

        return lista;

    }

    @Override
    public Dvd obterPorId( int id ) throws SQLException {

        Dvd dvd = null;

        PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT" + 
                "    d.id as idDvd, " + 
                "    d.titulo, " + 
                "    d.ano_lancamento, " +
                "    d.data_lancamento, " +
                "    d.duracao_minutos, " +
                "    d.ator_principal_id, " +
                "    d.ator_coadjuvante_id, " +
                "    d.genero_id, " +
                "    d.classificacao_etaria_id, " +
                "    g.id as idGenero, " + 
                "    g.descricao as descricaoGenero, "+
                "    c.id as idClassificacaoEtaria, " +
                "    c.descricao as descricaoClassificacaoEtaria, " +
                "(SELECT id FROM ator where ator.id = ator_principal_id) as idAtorPrincipal,"+
                "(SELECT nome from ator where ator.id = ator_principal_id) as nomeAtorPrincipal,"+
                "(SELECT sobrenome from ator where ator.id = ator_principal_id) as sobreNomeAtorPrincipal,"+
                "(SELECT data_estreia from ator where ator.id = ator_principal_id) as dataEstreiaAtorPrincipal,"+
                "(SELECT id from ator where ator.id = ator_coadjuvante_id) as idAtorCoadjuvante,"+
                "(SELECT nome from ator where ator.id = ator_coadjuvante_id) as nomeAtorCoadjuvante,"+
                "(SELECT sobrenome from ator where ator.id = ator_coadjuvante_id) as sobreNomeAtorCoadjuvante,"+
                "(SELECT data_estreia from ator where ator.id = ator_coadjuvante_id) as dataEstreiaAtorCoadjuvante "+
                "FROM" + 
                "    dvd d, " + 
                "    genero g, " + 
                "    classificacao_etaria c " +
                        
                "WHERE" + 
                "    g.id = d.genero_id AND " +
                "    c.id = d.classificacao_etaria_id AND"+
                " d.id = ?;");

        stmt.setInt( 1, id );

        ResultSet rs = stmt.executeQuery();

        if ( rs.next() ) {

            dvd = new Dvd();
            Ator atorPrincipal = new Ator();
            Ator atorCoadjuvante = new Ator();
            Genero g = new Genero();
            ClassificacaoEtaria c = new ClassificacaoEtaria();
            
            atorPrincipal.setId(rs.getInt("idAtorPrincipal"));
            atorPrincipal.setNome(rs.getString("nomeAtorPrincipal"));
            atorPrincipal.setSobreNome(rs.getString("sobreNomeAtorPrincipal"));
            atorPrincipal.setDataEstreia(rs.getDate("dataEstreiaAtorPrincipal"));

            atorCoadjuvante.setId(rs.getInt("idAtorCoadjuvante"));
            atorCoadjuvante.setNome(rs.getString("nomeAtorCoadjuvante"));
            atorCoadjuvante.setSobreNome(rs.getString("sobreNomeAtorCoadjuvante"));
            atorCoadjuvante.setDataEstreia(rs.getDate("dataEstreiaAtorCoadjuvante"));

            g.setId(rs.getInt("idGenero"));
            g.setDescricao(rs.getString("descricaoGenero"));
            
            c.setId(rs.getInt("idClassificacaoEtaria"));
            c.setDescricao(rs.getString("descricaoClassificacaoEtaria"));
               
            dvd.setId(rs.getInt("idDvd"));
            dvd.setTitulo(rs.getString("titulo"));
            dvd.setAnoLancamento(rs.getInt("ano_lancamento"));
            dvd.setDataLancamento(rs.getDate("data_lancamento"));
            dvd.setDuracaoMinutos(rs.getInt("duracao_minutos"));
 
            dvd.setGenero(g);
            dvd.setClassificacaoEtaria(c);
            dvd.setAtorPrincipal(atorPrincipal);
            dvd.setAtorCoadjuvante(atorCoadjuvante);

            

        }

        rs.close();
        stmt.close();

        return dvd;

    
   }
}
