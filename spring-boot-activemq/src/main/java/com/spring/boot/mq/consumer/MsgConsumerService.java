package com.spring.boot.mq.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * 消息消费
 * @创建时间：2018年6月11日
 */
@Service
public class MsgConsumerService {
	
	@JmsListener(destination = "mldn.msg.queue")
	public void receiveMessage(String msg) {
		System.err.println("======消费消息======" + msg);
	}

}
