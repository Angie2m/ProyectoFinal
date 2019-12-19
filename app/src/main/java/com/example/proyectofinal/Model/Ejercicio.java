package com.example.proyectofinal.Model;

public class Ejercicio {
    private Long id;
    private String nombre;
    private String maquina;
    private String tipo;
    private String series;
    private String repeticiones;
    private String calentamiento;

    public Ejercicio(){}

    public Ejercicio(Long id, String nombre, String maquina,
                     String tipo, String series, String repeticiones, String calentamiento) {
        this.id = id;
        this.nombre = nombre;
        this.maquina = maquina;
        this.tipo = tipo;
        this.series = series;
        this.repeticiones = repeticiones;
        this.calentamiento = calentamiento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMaquina() {
        return maquina;
    }

    public void setMaquina(String maquina) {
        this.maquina = maquina;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(String repeticiones) {
        this.repeticiones = repeticiones;
    }

    public String getCalentamiento() {
        return calentamiento;
    }

    public void setCalentamiento(String calentamiento) {
        this.calentamiento = calentamiento;
    }
}
