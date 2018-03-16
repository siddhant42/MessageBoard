package com.board.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.board.domain.Message;

@Service("messageBoardService")
public class MessageBoardServiceImpl implements MessageBoardService {
	private Map<Long, Message> messages = new LinkedHashMap<Long, Message>();
	public List<Message> listMessages() {
		return new ArrayList<Message>(messages.values());
	}
	public synchronized void postMessage(Message message) {
		message.setId(System.currentTimeMillis());
		messages.put(message.getId(), message);
	}
	public synchronized void deleteMessage(Message message) {
		messages.remove(message.getId());
	}
	public Message findMessageById(Long messageId) {
		return messages.get(messageId);
	}
}
