package ec.edu.espe.examenbatch.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

@Data
@Builder
public class Estudiante {

    private String id;

    private String cedula;

    private String apellidos;

    private String nombres;

    private Integer nivel;
}
