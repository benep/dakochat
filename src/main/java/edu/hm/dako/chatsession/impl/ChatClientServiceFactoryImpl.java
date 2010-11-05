package edu.hm.dako.chatsession.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.hm.dako.chat.ChatEventListener;
import edu.hm.dako.chatsession.ChatClientService;
import edu.hm.dako.chatsession.impl.ChatClientServiceImpl;
import edu.hm.dako.chatsession.ChatClientServiceFactory;
import edu.hm.dako.chatsession.ex.ChatServiceException;
import edu.hm.dako.test.mocks.LWTRTServiceMock;
import edu.hm.dako.lwtrt.LWTRTConnection;
import edu.hm.dako.lwtrt.ex.*;

public class ChatClientServiceFactoryImpl implements ChatClientServiceFactory {
	private static Log log = LogFactory.getLog(BaseServiceImpl.class);

	// private LWTRTConnection lwtrtConnetion;
	LWTRTServiceMock lwtrtServiceMock = new LWTRTServiceMock();
	ChatClientServiceImpl chatClientService = new ChatClientServiceImpl();

	@Override
	public ChatClientService register(int port) throws ChatServiceException {

		try {

			lwtrtServiceMock.register(port);
			lwtrtServiceMock.connect("localhost", 50000);

			// chatClientService.registerChatSessionListener();

		} catch (LWTRTException e) {

			log.debug("Can't connect");
			log.error(e.getCause());
		}

		return chatClientService;
	}

}
