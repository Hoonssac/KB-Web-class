package org.scoula.stock.dto;

import java.util.Date;

import org.scoula.stock.domain.StockVO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StockDTO {
	private Long no;
	private String stockCode;
	private String stockName;
	private int price;
	private String description;
	private Date regDate;

	public static StockDTO of(StockVO vo) {
		return vo == null ? null : StockDTO.builder()
			.no(vo.getNo())
			.stockCode(vo.getStockCode())
			.stockName(vo.getStockName())
			.price(vo.getPrice())
			.description(vo.getDescription())
			.regDate(vo.getRegDate())
			.build();
	}

	public StockVO toVo() {
		return StockVO.builder()
			.no(no)
			.stockCode(stockCode)
			.stockName(stockName)
			.price(price)
			.description(description)
			.regDate(regDate)
			.build();
	}

}

// CREATE TABLE tbl_stock (
// 	no INT AUTO_INCREMENT PRIMARY KEY,         -- 고유 번호 (PK)
// stock_code VARCHAR(20) NOT NULL,           -- 종목 코드
// stock_name VARCHAR(100) NOT NULL,          -- 종목 이름
// price INT NOT NULL,                        -- 현재가
// description TEXT,                          -- 종목 설명
// reg_date DATETIME DEFAULT NOW()            -- 등록일
// );