package com.example.test.other;

import lombok.Getter;
import lombok.Setter;
import org.junit.Test;

import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author mistaker
 * @description：
 * @create 2018/07/17
 */
public class LambdaTest {

//    @Test
    public void a(){

    }

    public static void main(String[] args){
        List<DataBean> totalStocks = new ArrayList<>();

        DataBean stock1 = new DataBean();
        stock1.setDeptId(2);
        stock1.setType(2);
        stock1.setNum(2);
        totalStocks.add(stock1);

        DataBean stock2 = new DataBean();
        stock2.setDeptId(2);
        stock2.setType(2);
        stock2.setNum(3);
        totalStocks.add(stock2);

        DataBean stock3 = new DataBean();
        stock3.setDeptId(3);
        stock3.setType(3);
        stock3.setNum(5);
        totalStocks.add(stock3);

        DataBean stock4 = new DataBean();
        stock4.setDeptId(3);
        stock4.setType(3);
        stock4.setNum(4);
        totalStocks.add(stock4);

        DataBean stock5 = new DataBean();
        stock5.setDeptId(4);
        stock5.setType(4);
        stock5.setNum(10);
        totalStocks.add(stock5);

        List<DataBean> result = totalStocks.stream()
                //group
                .collect(Collectors.groupingBy(e -> e.getDeptId() + ":" + e.getType()))
                //分组后的list做reduce
                .values().stream().map(list -> list.stream().reduce(LambdaTest::combine).get())
                //收集到list
                .collect(Collectors.toList());

        for(DataBean d : result){
            print(d.getNum());
        }
    }

    private static DataBean combine(DataBean b1, DataBean b2){
        DataBean e = new DataBean();
        e.setDeptId(b1.getDeptId());
        e.setType(b1.getType());
        e.setNum(b1.getNum() + b2.getNum());
        return e;
    }

    private static void print(Object o){
        System.out.println(o.toString());
    }

}

@Getter
@Setter
class DataBean{
    private int type;
    private int deptId;
    private int num;
}
