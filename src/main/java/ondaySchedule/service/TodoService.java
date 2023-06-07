package ondaySchedule.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ondaySchedule.dto.TodoDto;

@Service
public interface TodoService {
	// 할일 작성
	public int insertTodo(TodoDto todoDto) throws Exception;
	
	// 할일 조회
	public List<TodoDto> selectTodoList() throws Exception;
	
	// 완료한 일 조회
	public List<TodoDto> selectEndTodoList() throws Exception;
	
	// 완료한 일 체크
	public int completeTodoCheck(TodoDto todoDto) throws Exception;
	
	// 완료한 일 체크 해제
	public int completeTodoUnCheck(TodoDto todoDto) throws Exception;
	
	// 할일 수정
	public int updateTodo(TodoDto todoDto) throws Exception;
	
	// 할일 삭제
	public int deleteTodo(int todoId) throws Exception;
}
