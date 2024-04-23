package com.smartlock.Business.Lock;

import com.smartlock.Business.entities.Lock;
import com.smartlock.Infra.database.Database;
import java.util.UUID;
import java.util.List;
import java.util.ArrayList;

public class LockManager {
    Database data;

    public LockManager(Database database) {
        data = database;
    }

    public void registerLockController(Lock lock) {
        lock.setId(UUID.randomUUID());

        data.saveLock(lock);
    }

    public List<Lock> listLockController() {
        List<Lock> locks = new ArrayList<>();

        locks = data.listLocks();

        return locks;
    }

    public void updateLockController(Lock lock, UUID id) {
        data.updateLock(lock, id);
    }

    public void deleteLockController(UUID id) {
        data.deleteLock(id);
    }
}
