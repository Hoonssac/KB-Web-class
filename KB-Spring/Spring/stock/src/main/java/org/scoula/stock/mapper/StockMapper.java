package org.scoula.stock.mapper;

import java.util.List;

import org.scoula.stock.domain.StockVO;

public interface StockMapper {

	public List<StockVO> getList();

	public List<StockVO> getMesuList();

	public StockVO get(Long no);

	public void create(StockVO stock);

	public void mesu(StockVO stock);

	public int delete(Long no);
}
