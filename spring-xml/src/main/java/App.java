import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.MessageService;


/**
 * @author walker
 * @since 2022/4/18 20:20
 */
public class App {
	public static final Log log = LogFactory.getLog(App.class);

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");
		log.info("context 启动成功");
		MessageService messageService = context.getBean(MessageService.class);
		log.info("bean messageService:" + messageService.getMessage());

		// 重启
		context.refresh();
	}
}
