package cn.tblack.bookstack.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import cn.tblack.bookstack.util.UploadPropertiesMap;

@WebListener
public class ApplicationListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
	
		/* @每次启动服务器的时候为其设置文件上传的绝对路径，因为初始默认为空 
		 * @并且每次启动的时候进行类加载， 之后使用UploadPropertiesMap的时候类已经保存了所有的配置信息 */
		
		/* @ 拿到当前项目的绝对路径*/
		UploadPropertiesMap.getInstance().put("absPath", sce.getServletContext().getRealPath("./"));
		
		/*@管理员上传文件到项目的根目录下*/
		UploadPropertiesMap.getInstance().put("adminPath", sce.getServletContext().getRealPath("./"));
		
		
		System.out.println(UploadPropertiesMap.getInstance());
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
		
	}

}