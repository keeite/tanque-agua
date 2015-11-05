/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.ausiasmarch.tanque.modelo;

/**
 *
 * @author a044887852v
 */
public class ControlRiego {
    String mensaje;
    int sequia;
    int humedad;
    EstadoTanque estado;
    
    public void ControlRiego(EstadoTanque estado){
        this.estado = estado;
    }
    public void ControlRiego(){
    
    }

    public String getMensaje() {
        return mensaje;
    }

    public int getSequia() {
        return sequia;
    }

    public void setSequia(int sequia) {
        this.sequia = sequia;
    }

    public int getHumedad() {
        return humedad;
    }

    public void setHumedad(int humedad) {
        this.humedad = humedad;
    }

    public EstadoTanque getEstado() {
        return estado;
    }

    public void setEstado(EstadoTanque estado) {
        this.estado = estado;
    }
    
    public int permitidoLlenar(){
        int valor = 0;
        if(sequia > 10 || sequia < 0 ){
            valor = 1;
            mensaje = "El valor de la sequia no puede ser mayor de 10 o menor de 0";
        }
        if(estado == EstadoTanque.LLENO){
          valor = 2;
          mensaje = "El tanque no se puede llenar si esta lleno";
        }
        if(sequia == 10){
           valor = 3;
           mensaje = "No se puede llenar si la sequia es 10";            
        }
        if(estado == EstadoTanque.MEDIO && sequia >= 7){
          valor = 4;
          mensaje = "No se puede llenar mas de la mitad si la sequia es mayor o igual a 7";
        }
    return valor;    
    }
    public int permitidoVaciar(){
        int valor = 0;
        if(humedad > 10 || humedad < 0){
           valor = 1;
           mensaje = "el valor de la humedad no puede ser mayor a 10 o menor a 0";
        }
        if(estado == EstadoTanque.VACIO){
            valor = 2;
            mensaje = "No se puede vaciar si el tanque esta vacio";
        }
        if((estado == EstadoTanque.LLENO || estado == EstadoTanque.MEDIO) && humedad >= 7){
            valor = 3;
            mensaje = "No se puede vaciar nada si la humedad es mayor o igual a 7";
            
        }
        if((humedad >= 3 && humedad < 7) && estado == EstadoTanque.MEDIO){
           valor = 3;
           mensaje = "no se puede vaciar mas de la mitad si la humedad es mayor o igual a 3 y menor de 7";
        }
        return valor;
    }
    
}
