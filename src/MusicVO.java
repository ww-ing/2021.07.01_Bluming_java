public class MusicVO {
	
	private int idx;
	private String name;
	private String local;
	private String username;
	

	public MusicVO() {
	}
	
		public MusicVO(int idx, String name, String local, String username) {
		this.idx = idx;
		this.name = name;
		this.local = local;
		this.username = username;
		
	}
	public MusicVO(int idx, String name, String local) {
		super();
		this.idx = idx;
		this.name = name;
		this.local = local;
		
	}
	public MusicVO(String name, String local, String username) {
		super();
		this.name = name;
		this.local = local;
		this.username = username;
		
	}
	public MusicVO(String name, String local) {
		super();
		this.name = name;
		this.local = local;
		
	}
	public MusicVO(int idx, String local) {
		super();
		this.idx = idx;
		this.local = local;
		
	}
	public MusicVO(String name, int idx) {
		super();
		this.name = name;
		this.idx = idx;
		
	}
	public MusicVO(String local) {
		super();
		this.local = local;
		
	}
	
	//setter getter
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLocal() {
		return local;
	}
	
	public void setLocal(String local) {
		this.local = local;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
