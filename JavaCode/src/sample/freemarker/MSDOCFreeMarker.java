package sample.freemarker;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

/**
 * 
 * @author wasabi
 * 
 */
public class MSDOCFreeMarker {

	public static final String TECH = "FreeMarkerSample.ftl";
	private static MSDOCFreeMarker freeMaker = null;
	private final String DOC = ".doc";

	private Configuration configuration = null;

	/**
	 * 应该使用单实例配置。 要注意不管一个系统有多少独立的组件来使用FreeMarker， 它们都会使用他们自己私有的Configuration实例。
	 * 
	 * @return
	 */
	public static MSDOCFreeMarker getInstance() {
		if (null == freeMaker) {
			freeMaker = new MSDOCFreeMarker();
		}
		return freeMaker;
	}

	private MSDOCFreeMarker() {
		configureFreeMarker(Main.TEMP_PATH);
	}

	/**
	 * 
	 * @param tempDir
	 *            模板文件夹路径(相对路径) = sample/freemarker/templates
	 */
	private void configureFreeMarker(String tempDir) {

		configuration = new Configuration(Configuration.VERSION_2_3_22);
		configuration.setDefaultEncoding("utf-8");
		configuration.setObjectWrapper(new DefaultObjectWrapper(
				Configuration.VERSION_2_3_22));
		try {
			configuration.setDirectoryForTemplateLoading(new File(tempDir));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param tempName
	 *            模板名称 =FreeMarker.ftl
	 * @param dataMap
	 *            模板标签数据集
	 * @param outputDir
	 *            文档输出文件夹路径 = sample/freemarker/templates
	 */
	public void createDoc(String tempName, Map<String, Object> dataMap,
			String outputDir) {
		Template t = null;
		try {
			t = configuration.getTemplate(tempName);
			String name = tempName.split("\\.")[0];
			File outFile = new File(outputDir + "//" + name + DOC);
			Writer out = null;
			out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(outFile)));
			t.process(dataMap, out);
		} catch (TemplateNotFoundException e) {
			e.printStackTrace();
		} catch (MalformedTemplateNameException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
	}
}
