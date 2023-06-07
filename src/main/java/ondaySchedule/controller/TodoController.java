package ondaySchedule.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import ondaySchedule.dto.TodoDto;
import ondaySchedule.service.TodoService;

@Slf4j
@RestController
@CrossOrigin(origins="*", allowedHeaders="*")
public class TodoController {
	
	@Autowired
	private TodoService todoService;
	
	// 할일 작성
	@PostMapping("/ondayschedule/inserttodo")
	   public ResponseEntity<Map<String, Object>> insertTodo(@RequestBody TodoDto todoDto) throws Exception {
	      int insertedCount = 0;
	      try {
	         insertedCount = todoService.insertTodo(todoDto);
	         if (insertedCount > 0) {
	            Map<String, Object> result = new HashMap<>();
	            result.put("message", "정상적으로 등록되었습니다.");
	            result.put("count", insertedCount);
	            result.put("todoId", todoDto.getTodoId());      
	            return ResponseEntity.status(HttpStatus.OK).body(result);
	         } else {
	            Map<String, Object> result = new HashMap<>();
	            result.put("message", "등록된 내용이 없습니다.");
	            result.put("count", insertedCount);
	            return ResponseEntity.status(HttpStatus.OK).body(result);
	         }
	      } catch (Exception e) {
	         Map<String, Object> result = new HashMap<>();
	         System.out.println(e);
	         result.put("message", "등록 중 오류가 발생했습니다.");
	         result.put("count", insertedCount);
	         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
	      }	      
	   }
	
	// 할일 조회	
	@GetMapping("/ondayschedule/todo")
	   public ResponseEntity<List<TodoDto>> selectTodoList() throws Exception {
     
	      List<TodoDto> list = todoService.selectTodoList();
	      if(list != null && list.size() > 0) {
	         return ResponseEntity.status(HttpStatus.OK).body(list);
	      } else {
	         return ResponseEntity.status(HttpStatus.OK).body(null);
	      }
	   }
	
	// 완료한 일 조회
	@GetMapping("/ondayschedule/endtodo")
	   public ResponseEntity<List<TodoDto>> selectEndTodoList() throws Exception {
        
	      List<TodoDto> list = todoService.selectEndTodoList();
	      if(list != null && list.size() > 0) {
	         return ResponseEntity.status(HttpStatus.OK).body(list);
	      } else {
	         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	      }
	   }
	
	// 완료 체크
	@PutMapping("/ondayschedule/completetodocheck/{todoId}")
	public ResponseEntity<Integer> completeTodoCheck(@PathVariable("todoId") int todoId, @RequestBody TodoDto todoDto) throws Exception {
    int completeCheck = todoService.completeTodoCheck(todoDto);
    if (completeCheck != 1) {
       return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(completeCheck);
    } else {
       return ResponseEntity.status(HttpStatus.OK).body(completeCheck);
    }
 }
	
	// 완료 체크 해제 
	@PutMapping("/ondayschedule/completetodouncheck/{todoId}")
	public ResponseEntity<Integer> completeTodoUnCheck(@PathVariable("todoId") int todoId, @RequestBody TodoDto todoDto) throws Exception {
    int completeUnCheck = todoService.completeTodoUnCheck(todoDto);
    if (completeUnCheck != 1) {
       return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(completeUnCheck);
    } else {
       return ResponseEntity.status(HttpStatus.OK).body(completeUnCheck);
    }
 }
	
	// 할일 수정
	@PutMapping("/ondayschedule/updatetodo/{todoId}")
	   public ResponseEntity<Integer> updateTodo(@PathVariable("todoId") int todoId, @RequestBody TodoDto todoDto) throws Exception {
	      todoDto.setTodoId(todoId);
	      int updatedCount = todoService.updateTodo(todoDto);
	      if (updatedCount != 1) {
	         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(updatedCount);
	      } else {
	         return ResponseEntity.status(HttpStatus.OK).body(updatedCount);
	      }
	   }
	
	// 할일 삭제
	@PutMapping("/ondayschedule/deletetodo/{todoId}")
	public ResponseEntity<Integer> deleteTodo(@PathVariable("todoId") int todoId) throws Exception {
		int deletedCount = todoService.deleteTodo(todoId);
		if (deletedCount != 1) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(deletedCount);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(deletedCount);
		}
	}

}
