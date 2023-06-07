package ondaySchedule.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ondaySchedule.dto.EventDto;

@Mapper
public interface EventMapper {
	// 일정 작성
	public int insertEvent(EventDto eventDto) throws Exception;	
	
	// 캘린더용 데일리 일정 조회
	public List<EventDto> selectDailyEventList() throws Exception;
	
	// 사이드 바 일정 리스트 조회
	public List<EventDto> selectEventList() throws Exception;
	
	// 일정 수정
	public int updateEvent(EventDto eventDto) throws Exception;
	
	// 일정 삭제
	public int deleteEvent(int eventId) throws Exception;
	
	// 일정 상세 조회
	public List<EventDto> selectEventDetail(int eventId);	
}
