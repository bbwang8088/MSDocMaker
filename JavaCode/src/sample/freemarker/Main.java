package sample.freemarker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author wasabi
 * 
 */
public class Main {

	public static final String TEMP_PATH = System.getProperty("user.dir")+"\\template";
	public static final String OUTPUT_PATH = System.getProperty("user.dir")+"\\output";
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		 MSDOCFreeMarker maker = MSDOCFreeMarker.getInstance();
		 maker.createDoc(
		 MSDOCFreeMarker.TECH,
		 getDataMap(),
		 OUTPUT_PATH);
	}

	private static Map<String, Object> getDataMap() {

		Map<String, Object> root = new HashMap<String, Object>();
		root.put("docTitle", "WEB技术选型");
		root.put("projectNo", "20150322-CS-C#");
		root.put("projectName", "实验室管理系统");
		root.put("picker", "wasabi");
		Map<String, String> pickerDate = new HashMap<String, String>();
		pickerDate.put("year", "2016");
		pickerDate.put("month", "07");
		pickerDate.put("day", "29");
		root.put("pickerDate", pickerDate);
		List<HistoryItem> histories = new ArrayList<HistoryItem>();
		histories.add(new HistoryItem("No.1","2015年03月21日","wasabi","新建文档，初版内容做成。"));
		histories.add(new HistoryItem("No.2","2015年03月22日","wasabi","修改了作者名称。"));
		root.put("histories", histories);
		root.put("language", "Java1.6");
		root.put("backFrame", "Struts2");
		root.put("frontFrame", "jQuery+Bootstrap");
		root.put("pesistentFrame", "ibatis");
		root.put("databse", "Mysql");
		root.put("projectManage", "Maven");
		return root;

	}
}
