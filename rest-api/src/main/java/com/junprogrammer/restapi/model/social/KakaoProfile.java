package com.junprogrammer.restapi.model.social;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// 카카오 유저 정보를 담을 객체 생성
@Getter
@Setter
@ToString
public class KakaoProfile {
    private Long id;
    private Properties properties;

    @Getter
    @Setter
    @ToString
    private static class Properties {
        private String nickname;
        private String thumbnail_image;
        private String profile_image;
    }
}
