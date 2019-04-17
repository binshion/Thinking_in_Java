package thinkingInJava.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 文件复制：
 *  打开一个FileChannel用于读，打开另一个用于写。
 *  ByteBuffer被分配空间，每次read()操作后将数据输入到缓冲器中，flip()则是准备缓冲器以便他的信息可以由write()提取。
 *  write之后信息仍在缓冲器中，接着clear以便下一个read()能做好接受数据的准备。
 *
 *
 *  使用cmd运行传参方式：
 *  进入当前类编译后的目录，在包名的上一层：
 *  本例中存放在e:\JavaProject\bin\Thinking_in_Java
 *  使用 java thinkingInJava.io.ChannelCopy "参数一" "参数二"     命令即可
 *  ps:手工编译：javac -encoding -utf-8
 */
public class ChannelCopy {
    private static final int BSIZE = 1024;
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("arguments: sourcefile destfile");
            System.exit(1);
        }

        FileChannel in = new FileInputStream(args[0]).getChannel(),
                out = new FileOutputStream(args[1]).getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        while (in.read(buffer) != -1) {
            buffer.flip();  //准备写
            out.write(buffer);
            buffer.clear();  //准备读
        }
    }
}
