package vo;

public class ProductVO {
	private int appleCnt;
	private int bananaCnt;
	private int halabongCnt;
	
	public ProductVO() {
		appleCnt = bananaCnt = halabongCnt = 0;
	}
	
	public int getAppleCnt() {
		return appleCnt;
	}
	public void setAppleCnt() {
		this.appleCnt += 1;
	}
	public int getBananaCnt() {
		return bananaCnt;
	}
	public void setBananaCnt() {
		this.bananaCnt += 1;
	}
	public int getHalabongCnt() {
		return halabongCnt;
	}
	public void setHalabongCnt() {
		this.halabongCnt += 1;
	}
	
	
}
