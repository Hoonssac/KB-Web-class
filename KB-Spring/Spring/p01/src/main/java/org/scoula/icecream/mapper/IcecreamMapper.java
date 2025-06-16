package org.scoula.icecream.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.scoula.icecream.domain.IcecreamVO;

@Mapper
public interface IcecreamMapper {

	public List<IcecreamVO> getList();

	public void insert(IcecreamVO vo);

	public void delete(int no);
}
