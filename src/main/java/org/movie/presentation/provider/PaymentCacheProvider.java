package org.movie.presentation.provider;

import org.movie.data.cache.PaymentCache;
import org.movie.data.cache.PaymentCacheImpl;
import org.movie.data.cache.PaymentManager;
import org.movie.data.db.dao.PaymentDAO;

public class PaymentCacheProvider implements Provider<PaymentCache> {
    @Override
    public PaymentCache provide() {
        PaymentManager paymentManager = new PaymentManager(new PaymentDAO());
        PaymentCache paymentCache = new PaymentCacheImpl(paymentManager);
        return paymentCache;
    }
}
