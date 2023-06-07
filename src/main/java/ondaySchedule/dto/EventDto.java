package ondaySchedule.dto;

import lombok.Data;

@Data
public class EventDto {
	private int eventId;
	private String eventName;
	private String eventColor;
	private String startDate;
	private String endDate;
	private boolean allDay;
}
