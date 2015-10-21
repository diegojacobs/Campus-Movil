package com.example.usuario.uvgmovil;

/**
 * Created by Diego Jacobs on 20/10/2015.
 */
public class User {
    private String carnet = new String();
    private String name = new String();
    private String email = new String();
    private String password = new String();
    private String facultade = new String();
    private String carrera = new String();
    private String parqueo = new String();
    private String mapaC = new String();
    private String horario = new String();
    private Users usuarios = new Users();

    public User()
    {

    }

    public User(String Email)
    {
        this.email = Email;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFacultade() {
        return facultade;
    }

    public void setFacultade(String facultade) {
        this.facultade = facultade;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getParqueo() {
        return parqueo;
    }

    public void setParqueo(String parqueo) {
        this.parqueo = parqueo;
    }

    public String getMapaC() {
        return mapaC;
    }

    public void setMapaC(String mapaC) {
        this.mapaC = mapaC;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public boolean validateUser(String Email, String Password)
    {
        int index = usuarios.EmailIndex(Email);
        if (index != -1)
            return usuarios.CorrectPassword(index,Password);
        else
            return false;
    }
}