package persistencia;

/**
 * Beans that support customized output of dominio.JSON text shall implement this interface.
 * @author FangYidong<fangyidong@yahoo.com.cn>
 */
public interface JSONAware {
	/**
	 * @return dominio.JSON text
	 */
	String toJSONString();
}
