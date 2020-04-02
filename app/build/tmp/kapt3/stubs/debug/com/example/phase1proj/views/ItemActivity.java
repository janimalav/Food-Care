package com.example.phase1proj.views;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\nH\u0002J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J \u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aH\u0002J\u0012\u0010\u001d\u001a\u00020\u00152\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0003J\u001a\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u001a2\b\b\u0002\u0010\"\u001a\u00020\u001aH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/example/phase1proj/views/ItemActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "addToCart", "Landroid/widget/Button;", "backButton", "Landroid/widget/ImageButton;", "hurry", "Landroid/widget/TextView;", "hurry_value", "", "image", "Landroid/widget/ImageView;", "imageTitle", "minus", "plus", "quantity", "rate", "weight", "getQuantity", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setAddToCart", "text", "", "textColor", "setBackgroundColor", "setValues", "itemDetails", "Lcom/example/phase1proj/models/Vegetable;", "showDialog", "message", "setTitle", "app_debug"})
public final class ItemActivity extends androidx.appcompat.app.AppCompatActivity {
    private android.widget.Button minus;
    private android.widget.Button plus;
    private android.widget.TextView quantity;
    private android.widget.Button addToCart;
    private android.widget.ImageButton backButton;
    private android.widget.ImageView image;
    private android.widget.TextView imageTitle;
    private android.widget.TextView rate;
    private android.widget.TextView weight;
    private android.widget.TextView hurry;
    private int hurry_value;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    private final void setValues(com.example.phase1proj.models.Vegetable itemDetails) {
    }
    
    private final void showDialog(java.lang.String message, java.lang.String setTitle) {
    }
    
    private final void setAddToCart(java.lang.String text, java.lang.String textColor, java.lang.String setBackgroundColor) {
    }
    
    private final int getQuantity() {
        return 0;
    }
    
    public ItemActivity() {
        super();
    }
}