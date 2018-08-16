package spring.boot.swagger.common;

public class ResponseMessage<T> {
	
	private static final int OK_CODE = 200;
	private static final String OK_MESSAGE = "成功";
	
	private static final int ERROR_CODE = 500;
	
	private int code;
	private String message;
	private T data;
	
	public static <T> ResponseMessage<T> getInstance() {
		return new ResponseMessage<T>();
	}
	
	public static <T> ResponseMessage<T> ok(T data) {
		ResponseMessage<T> instance = getInstance();
		instance.setCode(OK_CODE);
		instance.setMessage(OK_MESSAGE);
		instance.setData(data);
		return instance;
	}
	
	public static <T> ResponseMessage<T> error(String message) {
		ResponseMessage<T> instance = getInstance();
		instance.setCode(ERROR_CODE);
		instance.setMessage(message);
		return instance;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "ResponseMessage [code=" + code + ", message=" + message + ", data=" + data + "]";
	}

}
