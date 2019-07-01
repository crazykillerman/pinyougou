package entity;

import java.io.Serializable;
import java.util.List;

/*分页结果类*/
public class PageResult implements Serializable{
		private long total;
		private List row;
		
		public PageResult(long total, List row) {
			super();
			this.total = total;
			this.row = row;
		}
		public long getTotal() {
			return total;
		}
		public void setTotal(long total) {
			this.total = total;
		}
		public List getRow() {
			return row;
		}
		public void setRow(List row) {
			this.row = row;
		}
			
		
}
