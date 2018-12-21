package persistencia;

import java.io.IOException;
import java.io.Writer;

/**
 * Beans that support customized output of dominio.JSON text to a writer shall implement this interface.
 * @author FangYidong<fangyidong@yahoo.com.cn>
 */
public interface JSONStreamAware {
	/**
	 * write dominio.JSON string to out.
	 */
	void writeJSONString(Writer out) throws IOException;
}
