package controles;

import entidades.Usuario;
import entidades.Foto;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilidades.HibernateUtil;

public class FotoControle {

    //Função de salvar uma foto
    public static boolean salvar(Foto foto){
        try{
            Session sessionRecheio;
            sessionRecheio = HibernateUtil.getSession();
            Transaction tr = sessionRecheio.beginTransaction();
            sessionRecheio.saveOrUpdate(foto);
            tr.commit();
            return true;
        }
        catch(Exception ex){
            return false;
        }        
    }
    
    //Localiza uma foto pelo id
    public static Foto buscar(Integer id)
    {
        String idFoto = id.toString();
        Session sessionRecheio;
        sessionRecheio = HibernateUtil.getSession();
        Transaction tr = sessionRecheio.beginTransaction();
        String hql = "from Foto f where f.id='"+idFoto+"'";
        Foto foto = (Foto)sessionRecheio.createQuery(hql).uniqueResult();
        tr.commit();
        return foto;
    }
    
    //Retorna todas as fotos de um usuario do sistema
    public static List<Foto> listar(Usuario usuario)
    {
        Session sessionRecheio;
        sessionRecheio = HibernateUtil.getSession();
        Transaction tr = sessionRecheio.beginTransaction();
        String hql = "from Foto f where f.usuario.id ='"+usuario.getId()+"'";
        List<Foto> lista = (List)sessionRecheio.createQuery(hql).list();
        tr.commit();
        return lista;
    }
    
    //Função de apagar um usuario
    public static boolean deletar(Foto foto){
        try{
            Session sessionRecheio;
            sessionRecheio = HibernateUtil.getSession();
            Transaction tr = sessionRecheio.beginTransaction();
            sessionRecheio.delete(foto);
            tr.commit();
            return true;
        }
        catch(Exception ex){
            return false;
        }        
    }    
}
