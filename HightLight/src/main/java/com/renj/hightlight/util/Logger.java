package com.renj.hightlight.util;

import android.util.Log;

/**
 * ======================================================================
 * <p/>
 * 作者：Renj
 * <p/>
 * 创建时间：2016-08-02    17:19
 * <p/>
 * 描述：Log日志工具类，打印结果形式 类名.方法名(所在行数)：打印的信息
 * <p/>
 * 修订历史：
 * <p/>
 * ======================================================================
 */
public class Logger {
    /**
     * 打印日志时显示的TAG
     */
    private static String TAG = "Logger";
    /**
     * 是否显示类的全路径名
     */
    private static boolean IS_FULL_CLASSNAME;
    /**
     *
     */
    private static int LOG_LEVEL = Log.VERBOSE;

    /**
     * 设置是打印类的全路径名，默认 false
     *
     * @param isFullClassName
     */
    public static void setFullClassName(boolean isFullClassName) {
        Logger.IS_FULL_CLASSNAME = isFullClassName;
    }

    /**
     * 设置日志打印级别，如果不想打印任何日志，level 大于 7 即可
     *
     * @param level
     */
    public static void setLogLevel(int level) {
        Logger.LOG_LEVEL = level;
    }

    /**
     * 设置打印的 TAG 名
     *
     * @param tag
     */
    public static void setAppTAG(String tag) {
        Logger.TAG = tag;
    }


    public static void v(String msg) {
        if (LOG_LEVEL <= Log.VERBOSE) {
            Log.v(TAG, getLogTitle() + msg);
        }
    }


    public static void d(String msg) {
        if (LOG_LEVEL <= Log.DEBUG) {
            Log.d(TAG, getLogTitle() + msg);
        }
    }

    public static void i(String msg) {
        if (LOG_LEVEL <= Log.INFO) {
            Log.i(TAG, getLogTitle() + msg);
        }
    }

    public static void w(String msg) {
        if (LOG_LEVEL <= Log.WARN) {
            Log.w(TAG, getLogTitle() + msg);
        }
    }

    public static void e(String msg) {
        if (LOG_LEVEL <= Log.ERROR) {
            Log.e(TAG, getLogTitle() + msg);
        }
    }

    /**
     * 根据是否需要打印类的全路径名获取打印日志的基本信息
     *
     * @return
     */
    private static String getLogTitle() {
        StackTraceElement elm = Thread.currentThread().getStackTrace()[4];
        String className = elm.getClassName();
        if (!IS_FULL_CLASSNAME) {
            int dot = className.lastIndexOf('.');
            if (dot != -1) {
                className = className.substring(dot + 1);
            }
        }
        return className + "." + elm.getMethodName() + "(" + elm.getLineNumber() + ")" + ": ";
    }

}