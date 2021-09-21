package com.epam.tc.hw6.utils;

import io.qameta.allure.Attachment;

public class AttachmentUtils {

    @Attachment(type="image/png", value = "try to use param {name}")
    public static byte[] makeScreenshotAttachment(final String name, final byte[] source) {
        return source;
    }
}
