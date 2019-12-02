package cn.tblack.bookstack.handler;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * <span>用于整个BookStack异常的处理。</span>
 * @author TD唐登
 * @Date:2019年8月22日
 * @Version: 1.0(测试版)
 */
@ControllerAdvice
public class BSExceptionHandler {

	@ExceptionHandler(value=RuntimeException.class)
	public String runtimeError(Exception e,Model model) {
		
		System.out.println("运行到此处发生了运行时异常: " +  e);
		model.addAttribute("exception",e);
		
		return "runtime_error";
	}
}
