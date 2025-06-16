package org.scoula.stock.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.scoula.stock.domain.StockVO;
import org.scoula.stock.dto.StockDTO;
import org.scoula.stock.mapper.StockMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class StockServiceImpl implements StockService {

	final private StockMapper mapper;

	@Override
	public List<StockDTO> getList() {
		log.info("get list of stock....");

		return mapper.getList().stream()
			.map(StockDTO::of)
			.toList();
	}

	@Override
	public List<StockDTO> getMesuList() {
		return mapper.getMesuList().stream()
			.map(StockDTO::of)
			.toList();
	}

	@Override
	public StockDTO get(Long no) {
		log.info("get stock info.....");
		StockDTO stock = StockDTO.of(mapper.get(no));
		return Optional.ofNullable(stock)
			.orElseThrow(NoSuchElementException::new);
	}

	@Transactional
	@Override
	public void create(StockDTO stock) {
		log.info("create stock......");
		StockVO stockVO = stock.toVo();
		mapper.create(stockVO);
	}

	@Transactional
	@Override
	public void mesu(StockDTO stock) {
		StockVO stockVO = stock.toVo();
		mapper.mesu(stockVO);
	}

	@Override
	public boolean delete(Long no) {
		return mapper.delete(no) == 1;
	}
}
