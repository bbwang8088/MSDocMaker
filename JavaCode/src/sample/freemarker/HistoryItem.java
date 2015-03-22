package sample.freemarker;

/**
 * 
 * @author wasabi
 *
 */
public class HistoryItem {

	private String no = "";
	private String date = "";
	private String author = "";
	private String content = "";

	public HistoryItem() {
		super();
	}

	public HistoryItem(String no, String date, String author, String content) {
		super();
		this.no = no;
		this.date = date;
		this.author = author;
		this.content = content;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
