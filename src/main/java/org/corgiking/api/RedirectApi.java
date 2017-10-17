package org.corgiking.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/redirect")
public class RedirectApi {

	/**
	 * 重定向
	 * 
	 */
	@GetMapping("/a")
	public String aaa() {
		// redirect:后面字符串加'/'表示从根路径开始
		return "redirect:/redirect/hello";
	}

	/**
	 * 路径方式传递参数
	 * 
	 * String 构建 URL
	 * 
	 */
	@GetMapping("/b")
	public String ccc() {
		// redirect:后面字符串没有加'/'表示从当前路径开始
		return "redirect:hello/Corgi King";
	}

	/**
	 * 路径方式传递参数
	 * 
	 * 模板 构建 URL 
	 * 所有的不安全字符都会进行转义
	 * 
	 */
	@GetMapping("/c")
	public String eee(Model model) {
		model.addAttribute("name", "I am model");
		return "redirect:hello/{name}";
	}
	
	/**
	 * 查询参数 方式传递参数
	 * 
	 * 模板 构建 URL 
	 * 
	 */
	@GetMapping("/d")
	public String fff(Model model) {
		model.addAttribute("name", "I am model");
		model.addAttribute("age", 20);
		return "redirect:hello/req/{name}";
	}
	
	/**
	 * flash
	 * model 当重定向发生的时候，这些数据就会丢失
	 * flash 属性会一直携带这些数据直到下一次请求，然后才会消失
	 * 
	 * 在重定向执行之前，所有的flash属性都会复制到会话中。
	 * 在重定向后，存在会话中的flash属性会被取出，并从会话转移到模型之中。
	 * 
	 */
	@GetMapping("/e")
	public String hhh(RedirectAttributes model) {
		model.addAttribute("name", "flash");
		//flash中可以放复杂对象
		model.addFlashAttribute("describe", "我是一个程序猿！");
		return "redirect:hello/{name}";
	}

	@GetMapping("/hello/{name}")
	@ResponseBody
	public String ddd(@PathVariable String name,Model model) {
		if(model.containsAttribute("describe"))
		{
			System.out.println(model.asMap().get("describe"));
		}
		return "已重定向到 ：hello " + name + "!";
	}

	@GetMapping("/hello/req/{name}")
	@ResponseBody
	public String ggg(@PathVariable String name, @RequestParam Integer age) {
		return "已重定向到 ：I am " + name + "! 我的年龄是 "+age;
	}
	
	@GetMapping("/hello")
	@ResponseBody
	public String bbb() {
		return "已重定向到 ：hello world!";
	}

}
