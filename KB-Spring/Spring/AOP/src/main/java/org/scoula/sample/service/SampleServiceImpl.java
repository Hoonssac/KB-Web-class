package org.scoula.sample.service;

import org.springframework.stereotype.Service;

@Service
public class SampleServiceImpl implements SampleService {

	@Override
	public Integer doAdd(String str1, String st2) throws Exception {
		return Integer.parseInt(str1) + Integer.parseInt(st2);
	}
}
