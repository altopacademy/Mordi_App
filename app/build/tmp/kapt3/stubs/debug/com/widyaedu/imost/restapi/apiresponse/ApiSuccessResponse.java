package com.widyaedu.imost.restapi.apiresponse;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 \u001f*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\u001fB\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006B!\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\b\u00a2\u0006\u0002\u0010\tJ\u000e\u0010\u0015\u001a\u00028\u0000H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000bJ\u0015\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\bH\u00c6\u0003J4\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u00002\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\bH\u00c6\u0001\u00a2\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u00d6\u0003J\t\u0010\u001d\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u001e\u001a\u00020\u0005H\u00d6\u0001R\u0013\u0010\u0003\u001a\u00028\u0000\u00a2\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u00108FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006 "}, d2 = {"Lcom/widyaedu/imost/restapi/apiresponse/ApiSuccessResponse;", "T", "Lcom/widyaedu/imost/restapi/apiresponse/ApiResponse;", "body", "linkHeader", "", "(Ljava/lang/Object;Ljava/lang/String;)V", "links", "", "(Ljava/lang/Object;Ljava/util/Map;)V", "getBody", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getLinks", "()Ljava/util/Map;", "nextPage", "", "getNextPage", "()Ljava/lang/Integer;", "nextPage$delegate", "Lkotlin/Lazy;", "component1", "component2", "copy", "(Ljava/lang/Object;Ljava/util/Map;)Lcom/widyaedu/imost/restapi/apiresponse/ApiSuccessResponse;", "equals", "", "other", "", "hashCode", "toString", "Companion", "app_debug"})
public final class ApiSuccessResponse<T extends java.lang.Object> extends com.widyaedu.imost.restapi.apiresponse.ApiResponse<T> {
    private final T body = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<java.lang.String, java.lang.String> links = null;
    @org.jetbrains.annotations.Nullable()
    private final kotlin.Lazy nextPage$delegate = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.widyaedu.imost.restapi.apiresponse.ApiSuccessResponse.Companion Companion = null;
    private static final java.util.regex.Pattern LINK_PATTERN = null;
    private static final java.util.regex.Pattern PAGE_PATTERN = null;
    private static final java.lang.String NEXT_LINK = "next";
    
    @org.jetbrains.annotations.NotNull()
    public final com.widyaedu.imost.restapi.apiresponse.ApiSuccessResponse<T> copy(T body, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.String> links) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public ApiSuccessResponse(T body, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.String> links) {
        super();
    }
    
    public final T component1() {
        return null;
    }
    
    public final T getBody() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.lang.String> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.lang.String> getLinks() {
        return null;
    }
    
    public ApiSuccessResponse(T body, @org.jetbrains.annotations.Nullable()
    java.lang.String linkHeader) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getNextPage() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\n*\u00020\u0007H\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/widyaedu/imost/restapi/apiresponse/ApiSuccessResponse$Companion;", "", "()V", "LINK_PATTERN", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "NEXT_LINK", "", "PAGE_PATTERN", "extractLinks", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        private final java.util.Map<java.lang.String, java.lang.String> extractLinks(java.lang.String $this$extractLinks) {
            return null;
        }
    }
}