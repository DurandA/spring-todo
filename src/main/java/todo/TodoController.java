package todo;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TodoController {
    private final TodoRepository repository;

    public TodoController(TodoRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/")
    public @ResponseBody String hello() {
        return "Hello, World!";
    }

    @RequestMapping(value = "/todos", method = POST)
    public @ResponseBody Todo create(@RequestBody Todo newTodo) {
        return repository.save(newTodo);
    }

    @RequestMapping(value = "/todos", method = GET)
    public @ResponseBody List<Todo> get() {
        return repository.findAll();
    }

}
