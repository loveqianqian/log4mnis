package com.heren.log4mnis.control;

import org.apache.log4j.Level;
import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;

/**
 * <p>ProjectName:log4mnis</p>
 * <p>Description:</p>
 *
 * @author:diaozhiwei
 * @data:2016/2/17
 */
public class LogContextFilter extends Filter {

    /**
     * 如果没有说明，默认不通过
     */
    boolean acceptOnMatch = false;

    /**
     * 输出级别最大值
     */
    Level levelMin;
    /**
     * 输出级别最小值
     */
    Level levelMax;

    /**
     * 过滤关键字
     */
    String containWord;


    /**
     * 过滤器核心
     * <p/>
     * ACCEPT 过
     * DENY 不过
     * NEUTRAL 下一
     *
     * @param event
     * @return
     */
    @Override
    public int decide(LoggingEvent event) {
        if (this.levelMin != null) {
            if (event.getLevel().isGreaterOrEqual(levelMin) == false) {
                return Filter.DENY;
            }
        }
        if (this.levelMax != null) {
            if (event.getLevel().toInt() > levelMax.toInt()) {
                return Filter.DENY;
            }
        }
        String message = (String) event.getMessage();
        if (message.contains(containWord)) {
            return Filter.ACCEPT;
        }
        if (acceptOnMatch) {
            return Filter.ACCEPT;
        } else {
            return Filter.DENY;
        }
    }

    public Level getLevelMin() {
        return levelMin;
    }

    public void setLevelMin(Level levelMin) {
        this.levelMin = levelMin;
    }

    public Level getLevelMax() {
        return levelMax;
    }

    public void setLevelMax(Level levelMax) {
        this.levelMax = levelMax;
    }

    public String getContainWord() {
        return containWord;
    }

    public void setContainWord(String containWord) {
        this.containWord = containWord;
    }

    public boolean isAcceptOnMatch() {
        return acceptOnMatch;
    }

    public void setAcceptOnMatch(boolean acceptOnMatch) {
        this.acceptOnMatch = acceptOnMatch;
    }
}
