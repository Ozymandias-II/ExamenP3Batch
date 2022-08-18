package ec.edu.espe.examenbatch.config;

import ec.edu.espe.examenbatch.process.AsignarEstudianteTask;
import ec.edu.espe.examenbatch.process.GenerarListasTask;
import ec.edu.espe.examenbatch.process.InsertarEstudianteTask;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@EnableBatchProcessing
@RequiredArgsConstructor
public class JobConfig {

    private final JobBuilderFactory jobs;

    private final  StepBuilderFactory steps;

    @Bean
    protected Step insertarEstudiante(){
        return steps
                .get("insertarEstudiante")
                .tasklet(new InsertarEstudianteTask())
                .build();
    }

    @Bean
    protected Step asignarStudent(){
        return steps
                .get("asignarEstudiante")
                .tasklet(new AsignarEstudianteTask())
                .build();
    }

    @Bean
    protected Step generarLista(){
        return steps
                .get("generarListas")
                .tasklet(new GenerarListasTask())
                .build();
    }
}
