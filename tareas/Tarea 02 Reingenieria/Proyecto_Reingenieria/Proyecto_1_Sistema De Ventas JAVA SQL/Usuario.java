package UDEMY;

class Usuario {

    private int id;
    private String username;
    private String password;
    private String rol;
    private String nombreCompleto;

    public Usuario(int id, String username, String password,
                   String rol, String nombreCompleto) {

        this.id = id;
        this.username = username;
        this.password = password;
        this.rol = rol;
        this.nombreCompleto = nombreCompleto;
    }

    public int getId() { return id; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getRol() { return rol; }
    public String getNombreCompleto() { return nombreCompleto; }
}