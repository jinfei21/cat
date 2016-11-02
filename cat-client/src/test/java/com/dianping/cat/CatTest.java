package com.dianping.cat;

import org.junit.Test;

import com.dianping.cat.message.Message;
import com.dianping.cat.message.Trace;
import com.dianping.cat.message.Transaction;

import junit.framework.Assert;

public class CatTest {

	@Test
	public void test() {
		// Cat.logMetricForCount("logMetricForCount", 4);
		// Cat.logMetric("logMetric", "test", "test");
		//
		// Cat.newTransaction("logTransaction", "logTransaction");
		// Cat.newEvent("logEvent", "logEvent");
		// Cat.newTrace("logTrace", "logTrace");
		// Cat.newHeartbeat("logHeartbeat", "logHeartbeat");
		// Throwable cause = new Throwable();
		// Cat.logError(cause);
		// Cat.logError("message", cause);
		// Cat.logTrace("logTrace", "<trace>");
		// Cat.logTrace("logTrace", "<trace>", Trace.SUCCESS, "data");
		//
		// Cat.logMetricForCount("logMetricForCount");
		// Cat.logMetricForCount("logMetricForCount", 4);
		// Cat.logMetricForDuration("logMetricForDuration", 100);
		// Cat.logMetricForSum("logMetricForSum", 100);
		// Cat.logMetricForSum("logMetricForSum", 100, 100);
		// Cat.logEvent("RemoteLink", "Call", Message.SUCCESS,
		// "Cat-0a010680-384736-2061");
		// Cat.logEvent("EventType", "EventName");
		// Cat.logHeartbeat("logHeartbeat", "logHeartbeat", Message.SUCCESS,
		// null);
		//

		while (true) {

			Transaction t = Cat.newTransaction("test", "fsafas");

			for (int i = 0; i < 2000; i++) {
				Cat.logEvent("EventType", "EventName");
				testTransaction();
			}

			t.setStatus(Transaction.SUCCESS);
			t.complete();
			
			Assert.assertEquals(true, Cat.isInitialized());
		}
		
	}

	public static void testTransaction() {
		Transaction t = Cat.newTransaction("fyj", "tran");

		System.out.println("fsfsafsafsajflksdajfldasjfdsalkjfdaslkfdsjalk");

		t.setStatus(Transaction.SUCCESS);
		t.complete();

	}
}
