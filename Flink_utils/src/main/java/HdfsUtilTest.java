import java.util.concurrent.ExecutionException;

public class HdfsUtilTest {
    public static void main(String[] args) throws Exception {
        HdfsUtil test = new HdfsUtil();
        String dirpath = "/test";
        String filepath = "/test/hello1.txt";
        String loacalPath = "hi.txt";
        String hdfsPath = "/test/上传到hdfs.txt";
        test.createmkdir(dirpath);   //在 hdfs中新建文件夹
        test.createfile(filepath);   //创建文件
////        test.appendwrite(filepath);  //向文件中写入字符串：无则创建，有则追加
//        test.cat(filepath);          //查看文件
        test.copyFromLocalFile(loacalPath,hdfsPath); //上传文件到HDFS
        test.copyToLocalFile("/test/上传到hdfs.txt","从hdfs下载到本地.txt");  //从hdfs下载文件到本地
        test.listFiles("/"); //查看某个目录下所有文件
        test.delete("/test/上传到hdfs.txt");

    }
}