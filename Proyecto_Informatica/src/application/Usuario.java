package application;

public class Usuario {
	String nick;
	String contasena;
	Boolean admin;
	
	public Usuario(String nick, String contasena, Boolean admin) {
		this.nick = nick;
		this.contasena = contasena;
		this.admin = admin;
	}
	
	public String getNick() {
		return nick;}
	public void setNick(String nick) {
		this.nick = nick;}
	public String getContasena() {
		return contasena;}
	public void setContasena(String contasena) {
		this.contasena = contasena;}
	public Boolean getAdmin() {
		return admin;}
	public void setAdmin(Boolean admin) {
		this.admin = admin;}
}