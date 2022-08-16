import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.IOUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;

/**
 * @Description Hdfs工具类，提供连接，上传，下载等服务
 * @Author ws
 * @Date 2022/08/11
 */
public class HdfsUtil {
    Configuration configuration = null;
    FileSystem fileSystem = null;
    public static final String HDFS_PATH = "hdfs://39.99.245.209:9000";

    /**
     * 建立通道
     * @throws Exception
     */
    public void setUp() throws Exception {
        System.out.println("开始建立与HDFS的连接");
        configuration = new Configuration();
        fileSystem = FileSystem.get(new URI(HDFS_PATH),configuration, "hadoop");
    }

    /**
     * 关闭通道
     * @throws Exception
     */
    public void tearDown(){
        configuration = null;
        fileSystem = null;
        System.out.println("关闭与HDFS的连接");
    }

    /**
     * 在 hdfs中新建文件夹
     * @throws Exception
     */
    public void createmkdir(String dirpath) throws Exception {
        setUp();
        fileSystem.mkdirs(new Path(dirpath));
        tearDown();
    }

    /**
     * 创建文件     向文件中写入字符串：无则创建，有则追加
     * @throws Exception
     */
    public void createfile(String filepath) throws Exception {
        Path path = new Path(filepath);
        setUp();
        FSDataOutputStream outputStream = fileSystem.create(path);
        tearDown();
    }
    /**
     * 向文件中写入字符串：无则创建，有则追加
     * @throws Exception
     */
    private static Configuration conf = new Configuration();
    static {
        conf.setBoolean("dfs.support.append", true);
        conf.set("dfs.client.block.write.replace-datanode-on-failure.policy", "NEVER");
        conf.setBoolean("dfs.client.block.write.replace-datanode-on-failure.enable", true);
        String mgs = "hhh";
    }
    public static void appendwrite(String filePath) throws IOException {
        FileSystem fs = null;
        Path path = new Path(filePath);
        FSDataOutputStream output = null;
        fs = path.getFileSystem(conf);
        //如果此文件不存在则创建新文件
        if (!fs.exists(path)) {
            fs.createNewFile(path);
        }
        output = fs.append(new Path(filePath));
        output.write("hello ws".getBytes());
        output.write("\n".getBytes("UTF-8"));//换行
        fs.close();
        output.close();
    }

    /**
     * 查看文件
     * @throws Exception
     * hdfs -fs -cat path
     */
    public void cat(String pathString) throws Exception {
        setUp();
        FSDataInputStream in = fileSystem.open(new Path(pathString));
        IOUtils.copyBytes(in, System.out, 1024);
        in.close();
        tearDown();
    }
    /**
     * 上传文件到HDFS
     * @throws Exception
     */
    public void copyFromLocalFile(String loacalPath,String hdfsPath) throws Exception {
        setUp();
        Path loacalPath1 = new Path(loacalPath);
        Path hdfsPath1 = new Path(hdfsPath);
        fileSystem.copyFromLocalFile(loacalPath1, hdfsPath1);
        tearDown();
    }

    /**
     * 从HDFS下载文件到本地
     * @throws Exception
     */
    public void copyToLocalFile(String hdfsPath,String loacalPath) throws Exception {
        // 1 获取文件系统
        Configuration configuration = new Configuration();
        FileSystem fs = FileSystem.get(new URI(HDFS_PATH), configuration, "hadoop");

        // 2 获取输入流
        FSDataInputStream fis = fs.open(new Path(hdfsPath));
        // 3 获取输出流
        FileOutputStream fos = new FileOutputStream(new File(loacalPath));
        // 4 流的对拷
        IOUtils.copyBytes(fis, fos, configuration);
        // 5 关闭资源
        IOUtils.closeStream(fos);
        IOUtils.closeStream(fis);
        fs.close();
    }
    /**
     * 查看某个目录下所有文件
     * @throws Exception
     */
    public void listFiles(String pathString) throws Exception{
        setUp();
        FileStatus[] fileStatuses = fileSystem.listStatus(new Path(pathString));
        for (FileStatus f :fileStatuses){
            String isDir =  f.isDirectory()? "文件夹" : "文件";
            short replication = f.getReplication();
            long len = f.getLen();
            String path = f.getPath().toString();

            System.out.println(isDir + "\t" + replication +"\t" + len + "\t" +path);

        }
        tearDown();
    }

    /**
     * 删除文件
     * @throws Exception
     */
    public void  delete(String pathString) throws Exception {
        setUp();
        fileSystem.delete(new Path(pathString), true);
        tearDown();
    }


}
