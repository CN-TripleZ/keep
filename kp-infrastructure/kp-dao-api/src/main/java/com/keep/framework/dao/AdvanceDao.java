package com.keep.framework.dao;

import java.io.Serializable;

/**
 * 高级DAO，所有dao的父类
 * 
 * @author zhangchaozheng
 */
public interface AdvanceDao<E extends Serializable, K extends Serializable>
		extends GenricDao<E, K> {

}
