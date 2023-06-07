package ondaySchedule.dto;

import lombok.Data;

@Data
public class TodoDto {
	private int todoId;
	private String todoName;
	private String todoDeleteYn;
	private String todoComplete;
}
