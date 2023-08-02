package si.deisinger.interceptor;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

import java.util.concurrent.atomic.AtomicInteger;

@Interceptor
@Priority(Interceptor.Priority.APPLICATION)
@RequestCounted
public class RequestCounterInterceptor {

	private static final AtomicInteger requestCounter = new AtomicInteger(0);

	@AroundInvoke
	public Object countRequests(InvocationContext context) throws Exception {
		requestCounter.incrementAndGet();
		return context.proceed();
	}

	public static int getRequestCount() {
		return requestCounter.get();
	}
}
