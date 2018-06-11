package com.spring.boot.mq.producer;

import com.spring.boot.entity.UserEntity;

public interface MsgProducerService {

	public void sendMessage(String msg);
	
}
