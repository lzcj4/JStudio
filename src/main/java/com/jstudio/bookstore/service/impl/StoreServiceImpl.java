package com.jstudio.bookstore.service.impl;

import com.jstudio.bookstore.data.StoreMapper;
import com.jstudio.bookstore.domain.Store;
import com.jstudio.bookstore.service.IStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreServiceImpl extends AbstractServiceImpl<Store>
        implements IStoreService {
    @Autowired
    public StoreServiceImpl(StoreMapper storeMapper) {
        super(storeMapper);
    }
}
