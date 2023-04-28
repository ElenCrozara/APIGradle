package apigradle.dominio;

// jackon databind faz a serialização  dos dados transformando um objeto em json e um json em objeto (foi baixado nas dependẽncias)

public class Usuario {

    private String name;
    private String job;
    private String email;

    public Usuario() {}

    public Usuario(String name, String job, String email) {
        this.name = name;
        this.job = job;
        this.email = email;
    }

    public String getName() {
        return name;
    }
    public String getJob() {
        return job;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) {  this.email = email;}
}
