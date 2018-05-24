package com.skywin.drools.dongtai.model.fact;

/**
 * Created by yanglq on 2018/5/22.
 */
public class AddressCheckResult {

    /**
     * true:通过校验；false：未通过校验
     */
    private boolean postCodeResult = false;

    public boolean isPostCodeResult() {
        return postCodeResult;
    }

    public void setPostCodeResult(boolean postCodeResult) {
        this.postCodeResult = postCodeResult;
    }
}