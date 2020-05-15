package base.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.*;

/**
 *
 * 首先，通过 Selector.open() 创建一个 Selector，作为类似调度员的角色；
 * 然后，创建一个 ServerSocketChannel，并且向 Selector 注册，通过指定 SelectionKey.OP_ACCEPT，
 * 告诉调度员，它关注的是新的连接请求；
 * 为什么我们要明确配置非阻塞模式呢？这是因为阻塞模式下，注册操作是不允许的，会抛出 IllegalBlockingModeException 异常；
 * Selector 阻塞在 select 操作，当有 Channel 发生接入请求，就会被唤醒；
 *
 * 作者：王磊的博客
 * 链接：http://www.imooc.com/article/265871
 * 来源：慕课网
 * 本文原创发布于慕课网 ，转载请注明出处，谢谢合作
 *
 * @Author: kongweichang
 * @Date: 2019/9/23 15:58
 */
public class NioSocket {

    static ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
            4, 4,
            60L, TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>(),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.CallerRunsPolicy()
            );


    public static void main(String[] args) {
        int port = 22333;

        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try (Selector selector = Selector.open();
                     ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {
                    serverSocketChannel.bind(new InetSocketAddress(InetAddress.getLocalHost(), port));
                    serverSocketChannel.configureBlocking(false);
                    serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
                    while (true) {
                        selector.select(); // 阻塞等待就绪的Channel
                        Set<SelectionKey> selectionKeys = selector.selectedKeys();
                        Iterator<SelectionKey> iterator = selectionKeys.iterator();
                        while (iterator.hasNext()) {
                            SelectionKey key = iterator.next();
                            try (SocketChannel channel = ((ServerSocketChannel) key.channel()).accept()) {
                                channel.write(Charset.defaultCharset().encode("你好，世界"));
                            }
                            iterator.remove();
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        // Socket 客户端（接收信息并打印）
        try (Socket cSocket = new Socket(InetAddress.getLocalHost(), port)) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(cSocket.getInputStream()));
            bufferedReader.lines().forEach(s -> System.out.println("NIO 客户端：" + s));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
