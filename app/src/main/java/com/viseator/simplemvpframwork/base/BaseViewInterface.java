package com.viseator.simplemvpframwork.base;

/**
 * Created by viseator on 5/24/17.
 * Wu Di
 * Email: viseator@gmail.com
 */

/**
 * The base interface of view in the contract.
 */
public interface BaseViewInterface<T> {
    void setPresenter(T presenter);
}
