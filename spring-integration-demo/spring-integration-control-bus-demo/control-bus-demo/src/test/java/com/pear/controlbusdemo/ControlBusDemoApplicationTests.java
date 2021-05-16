package com.pear.controlbusdemo;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;
import org.springframework.messaging.support.GenericMessage;

import lombok.extern.slf4j.Slf4j;

@Slf4j

public class ControlBusDemoApplicationTests {
	/*
	@BeforeAll
	static void setup()
	{
		LoggingSystem.get(ClassLoader.getSystemClassLoader()).setLogLevel(Logger.ROOT_LOGGER_NAME, LogLevel.INFO);
		log.info("@BeforeAll - executes once before all test methods in this class");
	}
	*/
	@Test
	public void demoControlBus(){
		ConfigurableApplicationContext ac = new ClassPathXmlApplicationContext(
				"/META-INF/spring/integration/ControlBus.xml");
		MessageChannel controlChannel = ac.getBean("controlChannel", MessageChannel.class);
		PollableChannel adapterOutputChanel = ac.getBean("adapterOutputChanel", PollableChannel.class);
		log.info("Received before adapter started: " + adapterOutputChanel.receive(1000));
		controlChannel.send(new GenericMessage<String>("@inboundAdapter.start()"));
		log.info("Received before adapter started: " + adapterOutputChanel.receive(1000));
		controlChannel.send(new GenericMessage<String>("@inboundAdapter.stop()"));
		log.info("Received after adapter stopped: " + adapterOutputChanel.receive(1000));
		ac.close();
	}
}