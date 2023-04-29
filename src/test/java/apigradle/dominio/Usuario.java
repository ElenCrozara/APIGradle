package apigradle.dominio;

// jackon databind faz a serialização  dos dados transformando um objeto em json e um json em objeto (foi baixado nas dependẽncias)

public class Usuario {

    private String name; // é necessário criar primeiro atributos privados para depois com o get transformar em publico (usual do java)
    private String job;
    private String email;


    public Usuario() {} // construtor simples sem parametro


    public Usuario(String name, String job, String email) { // construtor passando parametros
        this.name = name;
        this.job = job;
        this.email = email;
    }

    public String getName() {return name;} // gets construidos para tornar o atributo publico porque o restassured reclamou do tipo private
    public String getJob() {
        return job;
    }
    public String getEmail() { return email; }

    public void setEmail(String email) {  this.email = email;} // setEmail construido para passar apenas um valor no parametro do construtor simples e não retornar nada, por isso é void
}
