package ondaySchedule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import ondaySchedule.dto.TodoDto;
import ondaySchedule.mapper.TodoMapper;

@Slf4j
@Service
public class TodoServiceImpl implements TodoService {
	
	@Autowired
	private TodoMapper todoMapper;
	
	// 할일 작성
	@Override
	public int insertTodo(TodoDto todoDto) throws Exception {
		return todoMapper.insertTodo(todoDto);
	}	

	// 할일 조회
	@Override
	public List<TodoDto> selectTodoList() throws Exception {
		return todoMapper.selectTodoList();
	}

	// 완료한 일 조회
	@Override
	public List<TodoDto> selectEndTodoList() throws Exception {
		return todoMapper.selectEndTodoList();
	}

	// 완료한 일 체크
	@Override
	public int completeTodoUnCheck(TodoDto todoDto) throws Exception {
		return todoMapper.completeTodoUnCheck(todoDto);
	}

	// 완료한 일 체크 해제
	@Override
	public int completeTodoCheck(TodoDto todoDto) throws Exception {
		return todoMapper.completeTodoCheck(todoDto);
	}
	
	// 할일 수정
	@Override
	public int updateTodo(TodoDto todoDto) throws Exception {
		return todoMapper.updateTodo(todoDto);
	}

	// 할일 삭제
	@Override
	public int deleteTodo(int todoId) throws Exception {
		return todoMapper.deleteTodo(todoId);
	}

}
