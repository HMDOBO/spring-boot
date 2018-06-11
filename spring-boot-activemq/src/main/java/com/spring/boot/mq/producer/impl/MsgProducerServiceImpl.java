package com.spring.boot.mq.producer.impl;

import javax.annotation.Resource;
import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import com.spring.boot.mq.producer.MsgProducerService;

/**
 * 消息发送
 * @创建时间：2018年6月11日
 */
@Service
public class MsgProducerServiceImpl implements MsgProducerService{

	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;
	@Resource
	private Queue queue;
	
	@Override
	public void sendMessage(String msg) {
		this.jmsMessagingTemplate.convertAndSend(this.queue, msg);
	}

}
