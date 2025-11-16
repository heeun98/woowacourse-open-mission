package com.woowacourse.open_mission.servletJspSession.domain;

import java.util.PriorityQueue;

public class Member {

    private Long id;
    private String loginId; // 로그인 아이디
    private String username; // 사용자 이름
    private String password; // 사용자 비밀번호

    public Member(Long id, String loginId, String username, String password) {
        this.id = id;
        this.loginId = loginId;
        this.username = username;
        this.password = password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getLoginId() {
        return loginId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
