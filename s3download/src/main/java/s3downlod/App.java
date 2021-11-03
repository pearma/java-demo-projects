package s3downlod;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import software.amazon.awssdk.core.client.config.SdkAdvancedAsyncClientOption;
import software.amazon.awssdk.http.crt.AwsCrtAsyncHttpClient;
import software.amazon.awssdk.services.s3.S3AsyncClient;
import software.amazon.awssdk.utils.ThreadFactoryBuilder;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(50, 50, 10, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(10_000),
                new ThreadFactoryBuilder().threadNamePrefix("sdk-async-response").build());

        // Allow idle core threads to time out
        executor.allowCoreThreadTimeOut(true);

        S3AsyncClient clientThread = S3AsyncClient.builder()
                .asyncConfiguration(
                        b -> b.advancedOption(SdkAdvancedAsyncClientOption.FUTURE_COMPLETION_EXECUTOR, executor))
                .build();
        System.out.println("Hello World!");
    }
}
