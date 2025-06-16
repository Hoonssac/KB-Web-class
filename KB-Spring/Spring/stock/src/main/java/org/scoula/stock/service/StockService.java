package org.scoula.stock.service;

import java.util.List;

import org.scoula.stock.dto.StockDTO;

public interface StockService {

	public List<StockDTO> getList();

	public List<StockDTO> getMesuList();

	public StockDTO get(Long no);

	public void create(StockDTO stock);

	public void mesu(StockDTO stock);

	public boolean delete(Long no);
}
