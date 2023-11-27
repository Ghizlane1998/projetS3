package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Connexion;
import dao.ArticleDao;
import dao.CategorieDao;
import entities.Article;

public class ArticleDaoImpl implements ArticleDao {

    private Connection connection = Connexion.getConnexion();
    private CategorieDao c = new CategorieDaoImpl();

    @Override
    public boolean create(Article o) {
        if (this.connection == null)
            return false;

        try {
            PreparedStatement ps = this.connection
                    .prepareStatement("insert into article (nomArticle,designation,prix,id_categorie) values (?, ?, ?,?,?);");

            ps.setString(1, o.getNomArticle());
            ps.setString(2, o.getDesignation());
            ps.setInt(3, o.getPrix());
            ps.setInt(5, o.getCategorie().getId_categorie());

            ps.executeUpdate();

            ps.close();

            System.out.println("Article bien Ajoutée ...");

            return true;

        } catch (SQLException e) {
            System.out.println("Probleme lors de l'ajout de Article " + e.getMessage());
        }

        return false;
    }

    @Override
    public boolean update(Article o) {
        if (this.connection == null)
            return false;

        try {
            PreparedStatement ps = this.connection.prepareStatement(
                    "update article set nomArticle = ?, designation = ? ,prix=? , id_categorie =?  where id_article = ?");
            ps.setString(1, o.getNomArticle());
            ps.setString(2, o.getDesignation());
            ps.setInt(3, o.getPrix());
            ps.setInt(5, o.getCategorie().getId_categorie());
            ps.setInt(6, o.getId_article());

            ps.executeUpdate();

            ps.close();

            System.out.println("Article bien Modifiée ...");

            return true;

        } catch (SQLException e) {
            System.out.println("Probleme lors de la modification de article " + e.getMessage());
        }

        return false;
    }

    @Override
    public boolean delete(Article o) {
        if (this.connection == null)
            return false;

        try {
            PreparedStatement ps = this.connection.prepareStatement("delete from article where id_article = ?");

            ps.setInt(1, o.getId_article());

            ps.executeUpdate();

            ps.close();

            System.out.println("article bien supprimée ...");

            return true;

        } catch (SQLException e) {
            System.out.println("Probleme lors de la suppression de article " + e.getMessage());
        }

        return false;
    }

    @Override
    public Article getById(int id) {
        if (this.connection == null)
            return null;

        try {
            PreparedStatement ps = this.connection.prepareStatement("select * from article where id_article = ? ");

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs != null && rs.next()) {
                Article e = new Article();
                e.setId_article(rs.getInt("id_article"));
                e.setNomArticle(rs.getString("nomArticle"));
                e.setDesignation(rs.getString("designation"));
                e.setPrix(rs.getInt("prix"));

                e.setCategorie(c.getById(rs.getInt("id_categorie")));

                rs.close();
                ps.close();

                return e;
            }

        } catch (SQLException e) {
            System.out.println("Probleme dans article getById " + e.getMessage());
        }

        return null;
    }

    @Override
    public List<Article> getAll() {

        if (this.connection == null)
            return null;

        try {
            PreparedStatement ps = this.connection.prepareStatement("select * from article");

            ResultSet rs = ps.executeQuery();

            List<Article> article = new ArrayList<Article>();

            while (rs.next()) {
                Article e = new Article();
                e.setId_article(rs.getInt("id_article"));
                e.setNomArticle(rs.getString("nomArticle"));
                e.setDesignation(rs.getString("designation"));
                e.setPrix(rs.getInt("prix"));

                e.setCategorie(c.getById(rs.getInt("id_categorie")));

                article.add(e);
            }

            rs.close();
            ps.close();

            return article;

        } catch (SQLException e) {
            System.out.println("Probleme dans article getAll " + e.getMessage());
        }

        return null;

    }

    @Override
    public List<String> getAllFields() {
        if (this.connection == null)
            return null;

        try {
            PreparedStatement ps = this.connection.prepareStatement("select * from article");

            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();

            List<String> fields = new ArrayList<String>();

            for (int i = 1; i <= rsmd.getColumnCount(); i++)
                fields.add(rsmd.getColumnName(i));

            rs.close();
            ps.close();

            return fields;

        } catch (SQLException e) {
            System.out.println("Probleme dans article getAllFields " + e.getMessage());
        }

        return null;
    }

}
