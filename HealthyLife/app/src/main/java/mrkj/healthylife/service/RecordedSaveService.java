package mrkj.healthylife.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import mrkj.healthylife.db.DatasDao;

/**
 * 记录保存服务(此处用于记录值)
 */
public class RecordedSaveService extends Service {

    public static final String cancelSaveService = "mrkj.healthylife.RECORDED";
    private DatasDao datasDao;
    public RecordedSaveService() {
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
