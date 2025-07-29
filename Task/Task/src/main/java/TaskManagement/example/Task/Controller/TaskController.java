package TaskManagement.example.Task.Controller;

import TaskManagement.example.Task.model.Task;
import TaskManagement.example.Task.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskRepo taskRepo;

    @PostMapping("/createNewTask")
    public ResponseEntity<Task> createNewTask(@RequestBody Task task) {
        if (task.getTitle() == null) {
            Task errorTask = new Task();
            errorTask.setTitle("Invalid: title is required");
            return ResponseEntity.badRequest().body(errorTask);
        }

        Task savedTask = taskRepo.save(task);
        return ResponseEntity.ok(savedTask);
    }



    @GetMapping("/getAllTasks")
    public ResponseEntity<List<Task>> getAllTasks(){
        try{
            List<Task> tasks = taskRepo.findAll();
            return new ResponseEntity<>(tasks, HttpStatus.CREATED);
        }
        catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/getTaskById/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable int id){
        try {
            if(taskRepo.findById(id).isPresent()){
                Task task = taskRepo.findById(id).get();
                return new ResponseEntity<>(task, HttpStatus.OK);
            }

        }catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PutMapping("/taskComplete/{id}")
    public ResponseEntity<Task> taskComplete(@PathVariable int id){
        try{
            if(taskRepo.findById(id).isPresent()){
                Task task = taskRepo.findById(id).get();
                task.setCompleted(true);
                taskRepo.save(task);
                return new ResponseEntity<>(task, HttpStatus.OK);
            }

        }catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Task> taskDelete(@PathVariable int id){
        try{
            if(taskRepo.findById(id).isPresent()){
                Task task = taskRepo.findById(id).get();
                taskRepo.delete(task);
                return new ResponseEntity<>(task, HttpStatus.OK);
            }

        }catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
