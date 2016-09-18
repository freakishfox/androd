/**
 * Created by Administrator on 9/15 0015.
 */
package com.freakishfox.xxq.NativeUtil;

public class NativeUtil {
    public native String printNative();
    public native int add(int a, int b);

    static {
        System.loadLibrary("NativeUtil");
    }
}
