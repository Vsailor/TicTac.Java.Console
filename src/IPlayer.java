public interface IPlayer {

    public char getMark ();

    public void setMark (char mark);

    public String getPlayerName();

    public void setPlayerName(String playerName);

    public void go (Square square, Round round);

}