package org.scoula.icecream.service;

import java.util.List;

import org.scoula.icecream.domain.IcecreamVO;
import org.scoula.icecream.dto.IcecreamDTO;
import org.scoula.icecream.mapper.IcecreamMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class IcecreamServiceImpl implements IcecreamService {

	private final IcecreamMapper mapper;

	@Override
	public List<IcecreamDTO> getList() {
		List<IcecreamVO> list = mapper.getList();
		return list.stream()
			.map(IcecreamDTO::of)
			.toList();
	}

	@Override
	public void register(IcecreamDTO dto) {
		IcecreamVO vo = dto.toVo();
		mapper.insert(vo);
	}
}
