package ec.edu.espe.examenbatch.process;

import ec.edu.espe.examenbatch.model.Estudiante;
import ec.edu.espe.examenbatch.utils.FileUtils;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertarEstudianteTask implements Tasklet, StepExecutionListener {

    private RestTemplate restTemplate = new RestTemplate();
    private String URL = "http://localhost:8081/estudiante";


    @Override
    public void beforeStep(StepExecution stepExecution) {
        List<Estudiante> estudiantes = FileUtils.leerArchivo("D:/VSCode/examen")
    }

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        ResponseEntity<Estudiante[]> response = restTemplate.postForEntity(URL, estudiantes, responseType:Estudiante[].class);
        Estudiante[] array = response.getBody();
        estudiantes = Arrays.asList(array);
        return RepeatStatus.FINISHED;
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        return ExitStatus.COMPLETED;
    }

}
