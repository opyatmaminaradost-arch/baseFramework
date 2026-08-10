package dto.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthRequest {
	private String password;
	private String username;

	public String getPassword(){
		return password;
	}

	public String getUsername(){
		return username;
	}
}
