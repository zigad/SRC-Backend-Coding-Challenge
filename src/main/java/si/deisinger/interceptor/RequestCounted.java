package si.deisinger.interceptor;

import jakarta.interceptor.InterceptorBinding;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@InterceptorBinding
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestCounted {
}