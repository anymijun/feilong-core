/*
 * Copyright (C) 2008 feilong
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.feilong.core.text;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.feilong.core.util.Validator;

/**
 * {@link DateFormat}是日期/时间格式化子类的抽象类.
 * 
 * <h3>关于{@link SimpleDateFormat}非线程安全:</h3>
 * 
 * <blockquote>
 * see {@link <a href="http://newslxw.iteye.com/blog/1114851">SimpleDateFormat在多线程下不安全</a>}
 * <br>
 * 也可以查看 {@link SimpleDateFormat} Synchronization部分注释内容
 * </blockquote>
 * 
 * @author feilong
 * @version 1.0.1 2012-3-27 上午1:39:38
 * @see java.text.Format
 * @see java.text.DateFormat
 * @see java.text.SimpleDateFormat
 * @see org.apache.commons.beanutils.converters.DateConverter
 * @see org.apache.commons.beanutils.locale.converters.DateLocaleConverter
 * @see <a href="http://newslxw.iteye.com/blog/1114851">SimpleDateFormat在多线程下不安全</a>
 * @since 1.0.1
 */
public class DateFormatUtil{

    /** Don't let anyone instantiate this class. */
    private DateFormatUtil(){
        //AssertionError不是必须的. 但它可以避免不小心在类的内部调用构造器. 保证该类在任何情况下都不会被实例化.
        //see 《Effective Java》 2nd
        throw new AssertionError("No " + getClass().getName() + " instances for you!");
    }

    // [start] format

    /**
     * format日期类型格式化成字符串类型.
     * 
     * <p>
     * 不建议直接调用此方法,建议使用 {@link com.feilong.core.date.DateUtil#date2String(Date, String)}替代
     * </p>
     * 
     * <p>
     * 调用的是 {@link #format(Date, String, Locale)},locale使用 {@link Locale#getDefault()}.
     * </p>
     * 
     * @param date
     *            the date
     * @param pattern
     *            建议使用 {@link com.feilong.core.date.DatePattern} 内置的时间格式
     * @return the string
     * @see #format(Date, String, Locale)
     * @see com.feilong.core.date.DateUtil#date2String(Date, String)
     */
    public static String format(Date date,String pattern){
        return format(date, pattern, Locale.getDefault());
    }

    /**
     * format日期类型格式化成字符串类型.
     * 
     * <p>
     * 适用于格式化时间,有 {@link Locale}的需求
     * </p>
     * 
     * @param date
     *            the date
     * @param pattern
     *            建议使用 {@link com.feilong.core.date.DatePattern} 内置的时间格式
     * @param locale
     *            the locale
     * @return the string
     * @see SimpleDateFormat#format(Date)
     */
    public static String format(Date date,String pattern,Locale locale){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, locale);
        return simpleDateFormat.format(date);
    }

    // [end]

    // [start]parse

    /**
     * parse字符串类型转成日期类型.
     * 
     * <p>
     * 不建议直接调用此方法,建议使用 {@link com.feilong.core.date.DateUtil#string2Date(String, String)}替代
     * </p>
     * 
     * <p>
     * 调用的是 {@link #parse(String, String, Locale)},locale使用 {@link Locale#getDefault()}
     * </p>
     * 
     * @param dateString
     *            the date string
     * @param pattern
     *            建议使用 {@link com.feilong.core.date.DatePattern} 内置的时间格式
     * @return the date
     * @see #parse(String, String, Locale)
     */
    public static Date parse(String dateString,String pattern){
        return parse(dateString, pattern, Locale.getDefault());
    }

    /**
     * 字符串类型转成日期类型.
     * 
     * @param dateString
     *            the date string
     * @param pattern
     *            建议使用 {@link com.feilong.core.date.DatePattern} 内置的时间格式
     * @param locale
     *            the locale
     * @return the date
     * @see SimpleDateFormat
     * @see SimpleDateFormat#parse(String)
     * @see SimpleDateFormat#parse(String, ParsePosition)
     */
    public static Date parse(String dateString,String pattern,Locale locale){
        if (Validator.isNullOrEmpty(dateString)){
            throw new NullPointerException("param dateString can not NullOrEmpty");
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, locale);
        ParsePosition parsePosition = new ParsePosition(0);
        return simpleDateFormat.parse(dateString, parsePosition);
    }

    // [end]
}