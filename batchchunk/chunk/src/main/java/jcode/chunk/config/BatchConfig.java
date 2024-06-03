package jcode.chunk.config;

import jcode.chunk.entities.Person;
import jcode.chunk.steps.PersonItemProcessor;
import jcode.chunk.steps.PersonItemReader;
import jcode.chunk.steps.PersonItemWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableBatchProcessing
public class BatchConfig {



     @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;



    @Bean
    public PersonItemReader personItemReader() {
        return new PersonItemReader();
    }

     @Bean
    public PersonItemWriter personItemWriter(){
        return new PersonItemWriter();
    }

    @Bean
    public PersonItemProcessor personItemProcessor(){
        return new PersonItemProcessor();
    }


     @Bean
    public TaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(1);
        taskExecutor.setMaxPoolSize(5);
        taskExecutor.setQueueCapacity(5);
        return taskExecutor;
    }

    @Bean
    public Step readFile() {
        return stepBuilderFactory.get("step1")
                .<Person, Person>chunk(10)
                .reader(personItemReader())
                .processor(personItemProcessor())
                .writer(personItemWriter())
                .taskExecutor(taskExecutor())
                .build();
    }



    @Bean
    public Job job() {
        return jobBuilderFactory.get("job")
                .start(readFile())
                .build();
    }


}
