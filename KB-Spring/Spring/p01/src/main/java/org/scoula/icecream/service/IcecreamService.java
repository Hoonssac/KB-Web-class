package org.scoula.icecream.service;

import java.util.List;

import org.scoula.icecream.dto.IcecreamDTO;

public interface IcecreamService {
	public List<IcecreamDTO> getList();
	public void register(IcecreamDTO dto);
	public void delete(int no);
}
