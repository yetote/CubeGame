package com.demo.yetote.cubegame.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.util.Log;

import com.demo.yetote.cubegame.application.MyApplication;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * com.demo.yetote.cubegame.utils
 * 异常处理类
 *
 * @author Swg
 * @date 2018/1/25 10:16
 */
public class CrashHandler implements Thread.UncaughtExceptionHandler {
    private static final String TAG = "CrashHandler";
    private Context mContext;

    /**
     * 文件夹目录
     */
    private static final String PATH = Environment.getExternalStorageDirectory().getPath() + "/crash_log";

    /**
     * 文件名
     */
    private static final String FILE_NAME = "crash";

    /**
     * 文件名后缀
     */
    private static final String FILE_NAME_SUFFIX = ".trace";

    private static final CrashHandler ourInstance = new CrashHandler();

    public static CrashHandler getInstance() {
        return ourInstance;
    }

    private CrashHandler() {
    }

    /**
     * 异常处理方法
     *
     * @param thread    线程
     * @param throwable 异常
     */
    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {

        saveThrowableToSDCard(throwable);

        uploadFileToServer(throwable);

        //退出应用
        MyApplication.getContext().exitApp();

    }

    public void init(Context context) {
        //将当前实例设为系统默认的异常捕捉器
        Thread.setDefaultUncaughtExceptionHandler(this);
        mContext = context.getApplicationContext();
    }

    /**
     * 保存异常信息至SD卡中
     *
     * @param throwable 异常信息
     */
    private void saveThrowableToSDCard(Throwable throwable) {
        if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            Log.e(TAG, "saveThrowableToSDCard: " + "sd卡未挂载");
            return;
        }
        File dir = new File(PATH);
        //若果文件夹不存在，则创建文件夹
        if (!dir.exists()) {
            //创建文件夹
            boolean mkdirsSuccessful = dir.mkdirs();
            if (!mkdirsSuccessful) {
                Log.e(TAG, "saveThrowableToSDCard: " + "创建文件夹失败");
                return;
            }
        }
        //获取当前时间
        long current = System.currentTimeMillis();
        String time = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.CHINA).format(current);

        //创建log文件
        File file = new File(PATH + FILE_NAME + time + FILE_NAME_SUFFIX);
        try {
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file)));

            PackageManager pm = mContext.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(mContext.getPackageName(), PackageManager.GET_ACTIVITIES);

            //打印应用信息
            printWriter.println("发生异常时间" + time);
            printWriter.println("应用版本" + pi.versionName);
            printWriter.println("应用版本号：" + pi.versionCode);
            printWriter.println("android版本号：" + Build.VERSION.RELEASE);
            printWriter.println("android版本号API：" + Build.VERSION.SDK_INT);
            printWriter.println("手机制造商:" + Build.MANUFACTURER);
            printWriter.println("手机型号：" + Build.MODEL);

            //打印异常信息
            throwable.printStackTrace(printWriter);

            printWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 将保存的异常文件上传至服务器
     *
     * @param throwable 异常信息
     */
    private void uploadFileToServer(Throwable throwable) {
    }
}
