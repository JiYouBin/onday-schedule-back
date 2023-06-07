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
import ondaySchedule.dto.EventDto;
import ondaySchedule.service.EventService;

@Slf4j
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EventController {

	@Autowired
	private EventService eventService;

	// 일정 작성
	@PostMapping("/ondayschedule/insertevent")
	public ResponseEntity<Map<String, Object>> insertTodo(@RequestBody EventDto eventDto) throws Exception {
		int insertedCount = 0;
		try {
			insertedCount = eventService.insertEvent(eventDto);
			if (insertedCount > 0) {
				Map<String, Object> result = new HashMap<>();
				result.put("message", "정상적으로 등록되었습니다.");
				result.put("count", insertedCount);
				result.put("eventId", eventDto.getEventId());
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

	// 캘린더용 데일리 일정 조회
	@GetMapping("/ondayschedule/dailyevent")
	public ResponseEntity<List<EventDto>> selectDailyEventList() throws Exception {

		List<EventDto> list = eventService.selectDailyEventList();
		if (list != null && list.size() > 0) {
			return ResponseEntity.status(HttpStatus.OK).body(list);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(null);
		}
	}

	// 일정 상세 조회
	@GetMapping("/ondayschedule/eventdetail/{eventId}")		
	public ResponseEntity<List<EventDto>> selectEventDetail(@PathVariable("eventId") int eventId) throws Exception {

		List<EventDto> list = eventService.selectEventDetail(eventId);
		if (list != null && list.size() > 0) {
			return ResponseEntity.status(HttpStatus.OK).body(list);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	// 사이드 바 일정 리스트 조회
	@GetMapping("/ondayschedule/eventlist")
	public ResponseEntity<List<EventDto>> selectEventList() throws Exception {

		List<EventDto> list = eventService.selectEventList();
		if (list != null && list.size() > 0) {
			return ResponseEntity.status(HttpStatus.OK).body(list);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(null);
		}
	}

	// 일정 수정
	@PutMapping("/ondayschedule/eventupdate/{eventId}")
	public ResponseEntity<Integer> updateEvent(@PathVariable("eventId") int eventId, @RequestBody EventDto eventDto)
			throws Exception {
		eventDto.setEventId(eventId);
		int updatedCount = eventService.updateEvent(eventDto);
		if (updatedCount != 1) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(updatedCount);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(updatedCount);
		}
	}

	// 일정 삭제
	@PutMapping("/ondayschedule/eventdelete/{eventId}")
	public ResponseEntity<Integer> deleteEvent(@PathVariable("eventId") int eventId) throws Exception {
		int deletedCount = eventService.deleteEvent(eventId);
		if (deletedCount != 1) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(deletedCount);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(deletedCount);
		}
	}

}
