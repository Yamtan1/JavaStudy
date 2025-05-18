package com.example.exam0516.service;

public class ExamService {
	
	public int totalPoint(String q1, String q2, String q3, String q4, String q5) {
		
		int total = 0;
		if("3".equals(q1)) {
			total += 20;
		}
		if("4".equals(q2)) {
			total += 20;
		}
		if("3".equals(q3)) {
			total += 20;
		}
		if("2".equals(q4)) {
			total += 20;
		}
		if("4".equals(q5)) {
			total += 20;
		}
		return total;
	}

}
