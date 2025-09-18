package entities;

public class Gestionnaire extends Person {
    private String idGestionnaire;

    public Gestionnaire(int id, String firstName, String lastName, String email, String password, String idGestionnaire){
        super(id, firstName, lastName, email, password);
        this.idGestionnaire = idGestionnaire;
    }

    public void setIdGestionnaire(String idGestionnaire){
        this.idGestionnaire = idGestionnaire;
    }

    public String getIdGestionnaire(){
        return this.idGestionnaire;
    }
}
