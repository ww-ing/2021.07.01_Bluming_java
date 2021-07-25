public class FriendVO {

    private int idx;
    private String name;
    private String friend;

    public FriendVO()
    {

    }
    public FriendVO(int idx,String name,String friend)
    {
        this.idx=idx;
        this.name=name;
        this.friend=friend;
    }

    public FriendVO(String friend) {
        this.friend = friend;
    }

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
    public String getFriend() {
        return friend;
    }
    public void setFriend(String friend) {
        this.friend = friend;
    }

}