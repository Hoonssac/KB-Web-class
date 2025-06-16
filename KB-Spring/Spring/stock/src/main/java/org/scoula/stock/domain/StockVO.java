package org.scoula.stock.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StockVO {
	private Long no;
	private String stockCode;
	private String stockName;
	private int price;
	private String description;
	private Date regDate;
}
