
public class Book {
 private String bookName;
 private String author;
 private String publisher;
 private String publishDate;
 
 public Book(String bookName,String author,String publisher,String publishDate)
 {
	 this.setBookName(bookName);
	 this.setAuthor(author);
	 this.setPublisher(publisher);
	 this.setPublishDate(publishDate);
 }
 
 public void setBookName(String bookName)
 {
	 this.bookName = bookName;
 }
 public String getBookName(){return bookName;}
 
 public void setAuthor(String author)
 {
	 this.author = author;
 }
 public String getAuthor(){return author;}
 
 public void setPublisher(String publisher)
 {
	 this.publisher = publisher;
 }
 public String getPublisher(){return publisher;}
 
 public void setPublishDate(String publishDate)
 {
	 this.publishDate = publishDate;
 }
 public String getPublishDate(){return publishDate;}
 
 public String toString()
 {
	 return "书名："+this.getBookName()+"\n作者："+this.getAuthor()
			 +"\n出版社："+this.getPublisher()+"\n出版时间："+this.getPublishDate();
 }
}

