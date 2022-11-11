package peer.sendAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {
		@Autowired
		AuthService authService;

		@Autowired
		CustomMessageService customMessageService;

		@GetMapping("/Send.TEST")
		public String serviceStart(String code) {
			if(authService.getKakaoAuthToken(code)) {
				customMessageService.sendMyMessage();
				return "메시지 전송 성공";
			}else {
				return "토큰발급 실패";
			}
		}
	}

