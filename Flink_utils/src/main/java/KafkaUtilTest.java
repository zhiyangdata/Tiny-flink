import java.util.concurrent.ExecutionException;

public class KafkaUtilTest {
    public static void main(String[] args) throws ExecutionException,InterruptedException {
        // 生产数据
        String topic = "first";
        String msg = "hhh";
        KafkaUtil.kafkaproducer(topic,msg);
        // 消费数据
        KafkaUtil.kafkaconsumer();
    }
}
