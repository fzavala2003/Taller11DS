public class Fecha {
    private int dia;
    private int mes;
    private int año;
    private String hora;

    public Fecha(int dia, int mes, int año, String hora) {
        this.dia = dia;
        this.mes = mes;
        this.año = año;
        this.hora = hora;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return dia + "/" + mes + "/" + año + " " + hora;
    }
}
