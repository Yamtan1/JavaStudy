package com.example.memo.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {
	
	Calculator calculator = new Calculator();
	
	@Test
	void testDivisionByZero() {
		assertThrows(NullPointerException.class, () -> calculator.divide(10, 0), "0으로 나누면 IllegalArgumentException이 발생해야 합니다.");
	}
	
	//@Test
	void testFalse() {
		assertFalse(calculator.subtract(10, 2) == 8 , "10-2는 5가 아니어야 합니다.");
	}
	
	//@Test
	void testTrue() {
		assertTrue(calculator.multiply(3, 3) == 10, "3*3은 9이어야 합니다.");
	}
	
	
	//@Test
	void testNotEquals() {
		int result = calculator.add(2, 2);
		assertEquals(5, result, "2+2는 5가 아니어야 합니다.");
	}
	
	@Test
	void testSubtraction() {
		int result = calculator.subtract(3, 5);
		assertEquals(-2, result);
	}
	
	@Test
	void testMul() {
		int result = calculator.multiply(3, 5);
		assertEquals(15, result);
	}
	
	@Test
	void div() {
		int result = calculator.divide(3, 5);
		assertEquals(0, result);
	}
	
	
	
	
	//@Test
	void testAddtion() {
		int result = calculator.add(3, 5);
		
		assertEquals(6, result, 1,"8에서 오차 +1, -1을 허용합니다."); //미자믹 1은 오차의 허용 범위임 +1, -1 허용범위
	}

}
