package com.kkb.b2c.gciantispider.util;

import org.apache.commons.io.FilenameUtils;

import java.io.File;

/**
 * 文件夹工具
 * 
 */
public class FolderUtils {

    /**
     * 创建完整路径
     *
     * @param path
     *            a {@link String} object.
     */
    public static final void mkdirs(final String... path) {
        for (String foo : path) {
            final String realPath = FilenameUtils.normalizeNoEndSeparator(foo, true);
            final File folder = new File(realPath);
            if (!folder.exists() || folder.isFile()) {
                folder.mkdirs();
            }
        }
    }

}