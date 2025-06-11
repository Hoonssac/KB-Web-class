package org.scoula.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {

	// Annotation 기반 SQL - 현재 시간 조회
	@Select("SELECT sysdate()")
	public String getTime();

	// getTime2()는 XML Mapper에 SQL 정의 예정
	public String getTime2();
}
