import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class SistemaAtencionMedico {
    private List<Paciente> pacientes;
    private List<Medico> medicos;
    private List<ServicioMedico> serviciosMedicos;
    private static final double DESCUENTO_ADULTO_MAYOR = 0.25;
 
    public SistemaAtencionMedico() {
        this.pacientes = new ArrayList<>();
        this.medicos = new ArrayList<>();
        this.serviciosMedicos = new ArrayList<>();
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public List<ServicioMedico> getServiciosMedicos() {
        return serviciosMedicos;
    }

    public void agregarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public void agregarMedico(Medico medico) {
        medicos.add(medico);
    }

    public void agregarServicioMedico(ServicioMedico servicioMedico) {
        serviciosMedicos.add(servicioMedico);
    }

    public void agendarConsulta(Paciente paciente, Consulta consulta){
        double costoConsulta = consulta.getServicioMedico().getCosto();
        int edadPaciente = paciente.getEdad();
        costoConsulta = calcularValorFinalConsulta(costoConsulta, edadPaciente);
        System.out.println("Se han cobrado "+ costoConsulta+ " dolares de su tarjeta de credito");
        paciente.getHistorialMedico().getConsultas().add(consulta); // Corregido: acceder mediante getter
    }

    public double calcularValorFinalConsulta(double costoConsulta, int edadPaciente){
        double valorARestar = 0;
        if(edadPaciente >= 65){
            valorARestar = costoConsulta * DESCUENTO_ADULTO_MAYOR;
        }
        return costoConsulta - valorARestar;
    }

    public <T> T obtenerEntidadPorNombre(String nombre, List<T> lista, Function<T, String> getNombreFunction) {
        for (T entidad : lista) {
            if (getNombreFunction.apply(entidad).equals(nombre)) {
                return entidad;
            }
        }
        return null;
    }

    public Paciente obtenerPaciente(String nombrePaciente) {
        return obtenerEntidadPorNombre(nombrePaciente, pacientes, Paciente::getNombre);
    }

    public ServicioMedico obtenerServicioMedico(String nombreServicio) {
        return obtenerEntidadPorNombre(nombreServicio, serviciosMedicos, ServicioMedico::getNombre);
    }

    public Medico obtenerMedico(String nombreMedico) {
        return obtenerEntidadPorNombre(nombreMedico, medicos, Medico::getNombre);
    }
}