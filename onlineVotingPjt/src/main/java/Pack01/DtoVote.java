package Pack01;

public class DtoVote {
	// DTO  class
	
		String user_id;
		String user_pwd;
		String vote_isok;
		String vote_info;
		
		DtoVote(){}
		DtoVote(String user_id){
			
			System.out.println(" DtoVote DTO 생성자 call");
			this.user_id	= user_id; 
			this.user_pwd	= user_pwd;
			this.vote_isok	= vote_isok;
			this.vote_info	= vote_info;
		}
		public String getUser_id() {
			return user_id;
		}
		public void setUser_id(String user_id) {
			this.user_id = user_id;
		}
		public String getUser_pwd() {
			return user_pwd;
		}
		public void setUser_pwd(String user_pwd) {
			this.user_pwd = user_pwd;
		}
		public String getVote_isok() {
			return vote_isok;
		}
		public void setVote_isok(String vote_isok) {
			this.vote_isok = vote_isok;
		}
		public String getVote_info() {
			return vote_info;
		}
		public void setVote_info(String vote_info) {
			this.vote_info = vote_info;
		}		
		
}
