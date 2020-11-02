/* * Copyright 2013-2020 Smartdot Technologies Co., Ltd. All rights reserved. * SMARTDOT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.

 * */
package com.smart.normal.test;

/**
 * <p>
 *
 * @author <a href="mailto:caob@smartdot.com.cn">caob</a>
 * @version 1.0, 2020/10/27
 */
public enum FlowLockStatus {
    UNLOCKED,
    EDIT,
    SUBMIT;

    private FlowLockStatus() {
    }
}
