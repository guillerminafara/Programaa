package modelo;

/**
 * DinoEnum
 */
public enum DinoEnum {
    GRANDE("Grande"),
    MEDIANO("Mediano"),
    PEQUE("Pequeño");
    private final String tamanyo;

     DinoEnum(String tamanyo){
        this.tamanyo = tamanyo;
    }
    public String getTamanyo(){
        return tamanyo;
    }
    public String getTamMinus() {
        return name().toLowerCase();
    }

}