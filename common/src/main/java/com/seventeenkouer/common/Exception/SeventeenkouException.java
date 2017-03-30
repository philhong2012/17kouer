package com.seventeenkouer.common.Exception;



/**
 * 自定义异常类
* @author zhongyq
* @version 1.0.0, 2015-5-27
*/
public class SeventeenkouException extends BaseRuntimeException{
	private static final long serialVersionUID = -8211729708677743232L;
//	private static Logger logger = Logger.getLogger(BaseRuntimeException.class);
	public SeventeenkouException(String code) {
		super();
		this.setCode(code);
	}

	public SeventeenkouException(Throwable cause) {
		super(cause);
		if (cause instanceof SeventeenkouException) {
			this.setCode(((SeventeenkouException) cause).getCode());
		}
	}

	public SeventeenkouException(String code, Throwable cause) {
		super(code,cause);
	}

	public SeventeenkouException(String code, String message) {
		super(code, message);
	}

	public SeventeenkouException(String code, String message, Throwable cause) {
		super(code, message, cause);
	}
}
