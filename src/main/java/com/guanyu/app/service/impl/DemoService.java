package com.guanyu.app.service.impl;

import com.guanyu.app.model.user.MessageDO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 */
public class DemoService {

    public static void main(String[] args) {
        exportDemo();
    }

    public static void exportDemo() {

        String[] headers = {"用户ID", "评论", "点赞数", "创建时间"};
        String[] fieldNames = {"userOpenid", "comments", "isLike", "createTime"};

        List<MessageDO> messages = new ArrayList<>();
        messages.add(createMessage("fhi4uw3ijo2j3oa65dbt", "haha", 18, new Date()));
        messages.add(createMessage("fh5iuw3ijo2j3oa21sac", "nice", 28, new Date()));
        try {
            parseMsg(messages, fieldNames);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    private static <E> void parseMsg(List<E> messages, String[] filedNames) throws NoSuchFieldException {
        for (E message : messages) {
            Class<?> msgClass = message.getClass();
            for (String field : filedNames) {
//                Field declaredField = msgClass.getMethod();
            }
        }
    }

    private static MessageDO createMessage(String openId, String comments, Integer isLike, Date createTime) {
        MessageDO msg = new MessageDO();
        msg.setOpenId(openId);
        msg.setComments(comments);
        msg.setIsLike(isLike);
        msg.setCreateTime(createTime);
        return msg;
    }

    private static String upperFirst(String str) {
        final char a = 'a';
        final char z = 'z';
        char[] ch = str.toCharArray();
        if (ch[0] >= a && ch[0] <= z) {
            ch[0] = (char) (ch[0] - 32);
        }
        return new String(ch);
    }
}
