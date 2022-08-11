import org.apache.kafka.clients.producer.*;

import java.util.concurrent.ExecutionException;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;

import java.util.Collections;
import java.util.Properties;

/**
 * @Description kafka工具类，提供消息发送与监听
 * @Author ws
 * @Date 2022/08/11
 */

public class KafkaUtil {

    static String bootstrapservers = "8.142.30.177:9092";
    public static  void kafkaproducer(String topic,String msg)throws ExecutionException,InterruptedException {
        Properties props = new Properties();
        //kafka 集群，broker-list
        props.put("bootstrap.servers", bootstrapservers);
        //重试次数
        props.put("retries",1);
        //批次大小
        props.put("batch.size",16384);//16k
        //等待时间
        props.put("linger.ms",1);
        //RecordAccumulator缓冲区大小
        props.put("buffer.memory",33554432);//32m
        //Key,Value的序列化类
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        //创建生产者对象
        Producer<String,String>	producer = new KafkaProducer<>(props);
        //发送数据
        producer.send(new ProducerRecord<String, String>("first",msg));
        //关闭资源
        producer.close();
    }
    public static void kafkaconsumer()throws ExecutionException,InterruptedException {
        //1.创建消费者配置信息
        Properties properties = new Properties();
        //链接的集群
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapservers);
        //开启自动提交
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,true);
        //自动提交的延迟
        properties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG,"1000");
        //key,value的反序列化
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringDeserializer");
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringDeserializer");
        //消费者组
        properties.put(ConsumerConfig.GROUP_ID_CONFIG,"test-consumer-group");
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"latest");//重置消费者offset的方法（达到重复消费的目的），设置该属性也只在两种情况下生效：1.上面设置的消费组还未消费(可以更改组名来消费)2.latest最新、earliest也返回历史数据
        //创建生产者
        KafkaConsumer<String,String> consumer = new KafkaConsumer<>(properties);
        consumer.subscribe(Collections.singletonList("first")); //Arrays.asList()
        while (true) {
            //获取数据
            ConsumerRecords<String, String> consumerRecords = consumer.poll(100);
            //解析并打印consumerRecords
            for (ConsumerRecord consumerRecord : consumerRecords) {
                System.out.println(consumerRecord.key() + "----" + consumerRecord.value());
            }
        }
    }
}
