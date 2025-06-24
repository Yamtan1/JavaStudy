package com.example.alram.service;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Service
public class SseService {
	// username → SseEmitter (SSE 연결 객체) 저장
	private final Map<String, SseEmitter> emitters = new ConcurrentHashMap<>();
	
	// 구독 요청 처리
	public SseEmitter subscribe(String username) {
		SseEmitter emitter = new SseEmitter(60 * 1000L);// 1분 유지
		
		//사용자의 emitter 등록
		emitters.put(username, emitter);
		//클라이언트가 연결종료하면 emitter 제거
		emitter.onCompletion(() -> emitters.remove(username));
		emitter.onTimeout(() -> emitters.remove(username));
		
		return emitter;
	}
	//특정 사용자에게 메시지 보내기
	public void sendToUser(String username, String message) {
		SseEmitter emitter = emitters.get(username);
		if(emitter != null) {
			try {
				emitter.send(SseEmitter.event().name("notification").data(message));
			} catch (IOException e) {
				//전송 실패 시 emitter 제거
				emitters.remove(username);
			}
		}
	}
}
