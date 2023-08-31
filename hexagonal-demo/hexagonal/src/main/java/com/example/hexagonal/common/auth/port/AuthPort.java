package com.example.hexagonal.common.auth.port;

/**
 * [description]
 *
 * @author miniyus
 * @date 2023/08/30
 */
public interface AuthPort {
    public Long getId();

    public String getName();

    public String getEmail();

    public String getApp();

    public String getProvider();
}
