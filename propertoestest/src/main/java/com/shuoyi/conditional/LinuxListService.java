package com.shuoyi.conditional;

/**
 * Created by zhaosy-c on 2017/12/23.
 */
public class LinuxListService implements ListService {
    @Override
    public String showListCmd() {
        return "ls";
    }
}
