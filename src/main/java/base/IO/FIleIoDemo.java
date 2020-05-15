package base.IO;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @Author: kongweichang
 * @Date: 2019/9/23 15:44
 */
public class FIleIoDemo {


    static void streamDemo () throws IOException {

        // inputstream
        InputStream inputStream = new FileInputStream("D:\\log.txt");
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);
        String str = new String(bytes, "utf-8");
        System.out.println(str);
        inputStream.close();

        // outputstream
        // 参数二，表示是否追加，true=追加
        OutputStream outputStream = new FileOutputStream("D:\\log.txt",true);
        outputStream.write("你好，老王".getBytes("utf-8"));
        outputStream.close();

        //Writer  // 参数二，是否追加文件，true=追加
        Writer writer = new FileWriter("D:\\log.txt",true);
        writer.append("老王，你好");
        writer.close();

        // reader
        Reader reader = new FileReader("D:\\log.txt");
        BufferedReader bufferedReader = new BufferedReader(reader);
        StringBuffer bf = new StringBuffer();
        String str1;
        while ((str1 = bufferedReader.readLine()) != null) {
            bf.append(str1 + "\n");
        }
        bufferedReader.close();
        reader.close();
        System.out.println(bf.toString());

    }

    static void filesClassDemo (String filePath, String content) throws IOException {

        // 写入文件（追加方式：StandardOpenOption.APPEND）
        Files.write(Paths.get(filePath), content.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);

        // 读取文件
        byte[] data = Files.readAllBytes(Paths.get(filePath));
        System.out.println(new String(data, StandardCharsets.UTF_8));

        // 创建多（单）层目录（如果不存在创建，存在不会报错）
        boolean mkdirs = new File("D://a//b").mkdirs();
    }
}
