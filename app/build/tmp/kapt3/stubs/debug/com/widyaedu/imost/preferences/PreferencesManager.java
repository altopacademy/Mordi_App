package com.widyaedu.imost.preferences;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\u000b\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\tJ\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\tJ\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\tJ\u000e\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\tJ\u000e\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\tR\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/widyaedu/imost/preferences/PreferencesManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "sp", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "getCity", "", "getPhoto", "getRole", "getUser", "isWelcomed", "", "putWelcomed", "", "setCity", "city", "setPhoto", "photo", "setRole", "role", "setUserId", "userId", "Companion", "app_debug"})
public final class PreferencesManager {
    private final android.content.SharedPreferences sp = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.widyaedu.imost.preferences.PreferencesManager.Companion Companion = null;
    private static final java.lang.String WELCOMED = "welcomed";
    private static final java.lang.String USER_ID = "userId_pref";
    private static final java.lang.String CITY = "city";
    private static final java.lang.String ROLE = "role_pref";
    private static final java.lang.String PHOTO = "photo";
    
    public PreferencesManager(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    public final void setCity(@org.jetbrains.annotations.NotNull()
    java.lang.String city) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCity() {
        return null;
    }
    
    public final void setUserId(@org.jetbrains.annotations.NotNull()
    java.lang.String userId) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUser() {
        return null;
    }
    
    public final void setRole(@org.jetbrains.annotations.NotNull()
    java.lang.String role) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRole() {
        return null;
    }
    
    public final void setPhoto(@org.jetbrains.annotations.NotNull()
    java.lang.String photo) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPhoto() {
        return null;
    }
    
    public final void putWelcomed() {
    }
    
    public final boolean isWelcomed() {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/widyaedu/imost/preferences/PreferencesManager$Companion;", "", "()V", "CITY", "", "PHOTO", "ROLE", "USER_ID", "WELCOMED", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}