package ondaySchedule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import ondaySchedule.dto.EventDto;
import ondaySchedule.mapper.EventMapper;

@Slf4j
@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventMapper eventMapper;
	
	
	// 일정 작성
	@Override
	public int insertEvent(EventDto eventDto) throws Exception {
		return eventMapper.insertEvent(eventDto);
	}

	// 캘린더용 데일리 일정 조회
	@Override
	public List<EventDto> selectDailyEventList() throws Exception {
		return eventMapper.selectDailyEventList();
	}

	// 사이드 바 일정 리스트 조회
	@Override
	public List<EventDto> selectEventList() throws Exception {
		return eventMapper.selectEventList();
	}

	// 일정 수정
	@Override
	public int updateEvent(EventDto eventDto) throws Exception {
		return eventMapper.updateEvent(eventDto);
	}

	// 일정 삭제
	@Override
	public int deleteEvent(int eventId) throws Exception {
		return eventMapper.deleteEvent(eventId);
	}

	@Override
	public List<EventDto> selectEventDetail(int eventId) {
		return eventMapper.selectEventDetail(eventId);
	}
}
