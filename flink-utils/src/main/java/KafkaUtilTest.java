import java.util.concurrent.ExecutionException;

/**
 * @Description kafka工具测试类，生产者提供（主题名，消息）参数，消费者直接消费数据
 * @Author ws
 * @Date 2022/08/11
 */
public class KafkaUtilTest {
    public static void main(String[] args) throws ExecutionException,InterruptedException {
        // 生产数据
        KafkaUtil kafkaUtil = new KafkaUtil();
        String host = "hadoop1";
        String topic = "first";
        String msg = "hhh";
        // 生产数据：
        kafkaUtil.kafkaproducer(host,topic,msg);
        // 消费数据
//        kafkaUtil.kafkaconsumer(host,topic);
    }
}
