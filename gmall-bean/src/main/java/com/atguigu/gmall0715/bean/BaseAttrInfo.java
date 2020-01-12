package com.atguigu.gmall0715.bean;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class BaseAttrInfo implements Serializable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 获取主键自增
    private String id;
    @Column
    private String attrName;
    @Column
    private String catalog3Id;

    @Transient // 表示数据库中没有的字段，但是在业务中需要！
    private List<BaseAttrValue>  attrValueList;


    public static void main(String[] args) {
        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("1");
        stringArrayList.add("2");
        stringArrayList.add("3");
        stringArrayList.add("4");
        stringArrayList.add("5");
        
        //普通循环
        for (int i = 0; i < stringArrayList.size(); i++) {

            if ("5".equals(stringArrayList.get(i))){
                stringArrayList.remove(i);
            }
        }
        System.out.println(stringArrayList+"itar");
        //        for (String str : stringArrayList) {
//            if ("5".equals(str)){
//                stringArrayList.remove(str);
//            }
//        }
//        System.out.println(stringArrayList+"iter");

//        for (Iterator<String> iterator = stringArrayList.iterator(); iterator.hasNext(); ) {
//            String next =  iterator.next();
//            if ("5".equals(next)){
//                // stringArrayList.remove(next);
//                iterator.remove();
//            }
//        }
//        System.out.println(stringArrayList+"itco");
    }
}
