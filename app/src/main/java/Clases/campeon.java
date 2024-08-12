package Clases;

public class campeon {

    String medalla;
    String pais;
    String deporte;
    String nombreAtleta;
    String sexo;


    public campeon(String medalla, String pais, String deporte, String nombreAtleta, String sexo) {
        this.medalla = medalla;
        this.pais = pais;
        this.deporte = deporte;
        this.nombreAtleta = nombreAtleta;
        this.sexo = sexo;
    }


    //Getters
    public String getMedalla() {
        return medalla;
    }

    public String getPais() {
        return pais;
    }

    public String getDeporte() {
        return deporte;
    }

    public String getNombreAtleta() {
        return nombreAtleta;
    }

    public String getSexo() {
        return sexo;
    }




//Setters
    public void setMedalla(String medalla) {
        this.medalla = medalla;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public void setNombreAtleta(String nombreAtleta) {
        this.nombreAtleta = nombreAtleta;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
