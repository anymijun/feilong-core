package com.feilong.core.lang.reflect.res;

import java.io.Serializable;

/**
 * Sku Item for solr.
 * 
 * @author feilong
 * @version 1.0 2012-2-18 下午8:01:33
 */
public class SkuItem implements Serializable{

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 8190409138133199386L;

    /** showOrder 显示顺序. */
    private float             showOrder;

    /**
     * @return the showOrder
     */
    public float getShowOrder(){
        return showOrder;
    }

    /**
     * @param showOrder
     *            the showOrder to set
     */
    public void setShowOrder(float showOrder){
        this.showOrder = showOrder;
    }

}