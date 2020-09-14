package com.xt.th;

import java.util.ArrayList;
import java.util.List;

/**
 * 生产者-消费者：仓库
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月14日]
 * @since V1.00
 */
public class Stock
{
    private List<String> goods=new ArrayList<>();
    
    private static final int MAX=10;
    
    public boolean isEmpty() {
        return goods.isEmpty();
    }
    public boolean isFull() {
        return goods.size()==MAX;
    }
    public void store(String goods) {
        this.goods.add(goods);
    }
    public String sell() {
        return this.goods.remove(0);
    }
}
