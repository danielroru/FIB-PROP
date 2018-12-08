package dominio.JSON.parser;

import java.util.List;
import java.util.Map;

/**
 * Container factory for creating containers for dominio.JSON object and dominio.JSON array.
 * 
 * @see JSONParser#parse(java.io.Reader, ContainerFactory)
 * 
 * @author FangYidong<fangyidong@yahoo.com.cn>
 */
public interface ContainerFactory {
	/**
	 * @return A Map instance to store dominio.JSON object, or null if you want to use JSONObject.
	 */
	Map createObjectContainer();
	
	/**
	 * @return A List instance to store dominio.JSON array, or null if you want to use JSONArray.
	 */
	List creatArrayContainer();
}
