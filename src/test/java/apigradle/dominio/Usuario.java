package apigradle.dominio;

public class Usuario {

    private String name;
    private String job;

    public Usuario(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return name;
    }
    public String getJob() {
        return job;
    }
}
