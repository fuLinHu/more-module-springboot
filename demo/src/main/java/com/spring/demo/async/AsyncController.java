/**
 * 
 */
package com.spring.demo.async;


import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;

/*import org.slf4j.Logger;
import org.slf4j.LoggerFactory;*/

/**
 * @author zhailiang
 *
 */
@RestController
@Slf4j
public class AsyncController {
	
	@Autowired
	private MockQueue mockQueue;
	
	@Autowired
	private DeferredResultHolder deferredResultHolder;
	
	//private Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping("/order")
	public DeferredResult<String> order() throws Exception {
		log.info("主线程开始");
		String orderNumber = RandomStringUtils.randomNumeric(8);
		mockQueue.setPlaceOrder(orderNumber);
		
		DeferredResult<String> result = new DeferredResult<>();
		deferredResultHolder.getMap().put(orderNumber, result);
		
		return result;

	}
	@RequestMapping("orderCall")
	public Callable<String> orderCall(){
		log.info("主线程开始");
		Callable<String> call=new Callable<String>() {
			@Override
			public String call() throws Exception {
				log.info("副线程开始");
				Thread.sleep(1000);
				log.info("副线程结束");
				return "success";
			}
		};
		log.info("主线程结束始");
		return call;
	}

}
