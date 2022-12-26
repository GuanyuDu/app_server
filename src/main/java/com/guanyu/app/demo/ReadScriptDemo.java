package com.guanyu.app.demo;


import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * 加载 lua 脚本的样例代码
 *
 * @author Guanyu
 */
public class ReadScriptDemo {

    public static void main(String[] args) throws InterruptedException, IOException {

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources("classpath*:/lua/*.lua");
        for (Resource resource : resources) {
            String content = convertToString(resource.getInputStream());
            System.out.println(content);
            // call ScriptLoad() load on redis
        }
    }

    public static String convertToString(InputStream stream) throws IOException {
        StringBuilder builder = new StringBuilder();
        byte[] bs = new byte[1024];
        int length;
        while ((length = stream.read(bs)) != -1) {
            builder.append(new String(bs, 0, length, StandardCharsets.UTF_8));
        }
        return builder.toString();
    }
}
