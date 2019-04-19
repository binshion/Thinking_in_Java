package thinkingInJava.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**复制测试命令
 * java thinkingInJava.io.TransferTo "f:\JavaProject\Thinking_in_Java\thinkingInJava\io\文件改名测试.png" "f:\JavaProject\Thinking_in_Java\thinkingInJava\io\改名测试2.png"
 */
public class TransferTo {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("需要参数： 源文件名，目标文件名");
            System.exit(1);
        }

        FileChannel in = new FileInputStream(args[0]).getChannel(),
                out = new FileOutputStream(args[1]).getChannel();

        in.transferTo(0, in.size(), out);

        //或者使用transferFrom.二选一
//        out.transferFrom(in, 0, in.size());
    }
}
