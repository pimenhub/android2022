package com.jpimentel.myappsw.basededatossw;

public class ClienteVO {

    private Integer codCliente;
    private String nombreCliente;
    private String apellidoCliente;
    private String correCliente;
    private String fechaNacimientoCliente;
    private Double limiteCreditoCliente;

    public ClienteVO() {
    }

    public ClienteVO(Integer codCliente, String nombreCliente, String apellidoCliente, String correCliente, String fechaNacimientoCliente, Double limiteCreditoCliente) {
        this.codCliente = codCliente;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.correCliente = correCliente;
        this.fechaNacimientoCliente = fechaNacimientoCliente;
        this.limiteCreditoCliente = limiteCreditoCliente;
    }

    public Integer getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Integer codCliente) {
        this.codCliente = codCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getCorreCliente() {
        return correCliente;
    }

    public void setCorreCliente(String correCliente) {
        this.correCliente = correCliente;
    }

    public String getFechaNacimientoCliente() {
        return fechaNacimientoCliente;
    }

    public void setFechaNacimientoCliente(String fechaNacimientoCliente) {
        this.fechaNacimientoCliente = fechaNacimientoCliente;
    }

    public Double getLimiteCreditoCliente() {
        return limiteCreditoCliente;
    }

    public void setLimiteCreditoCliente(Double limiteCreditoCliente) {
        this.limiteCreditoCliente = limiteCreditoCliente;
    }
}
