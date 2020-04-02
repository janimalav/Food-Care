package com.example.phase1proj.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000fH\u0017J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000fH\u0016J\u001a\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\rH\u0002J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\u0004*\b\u0012\u0004\u0012\u00020\n0\u0004R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/example/phase1proj/adapters/CategoryLogoViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/phase1proj/adapters/CategoryLogoViewAdapter$MyLogoViewHolder;", "logoList", "", "Lcom/example/phase1proj/models/CategoryLogo;", "home", "Lcom/example/phase1proj/views/home;", "(Ljava/util/List;Lcom/example/phase1proj/views/home;)V", "globalparents", "Lcom/example/phase1proj/models/Category;", "parents", "selectCategories", "", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "openActivity", "Lcom/example/phase1proj/adapters/ChildRecyclerViewAdapter$MyViewHolder;", "Name", "copy", "MyLogoViewHolder", "app_debug"})
public final class CategoryLogoViewAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.phase1proj.adapters.CategoryLogoViewAdapter.MyLogoViewHolder> {
    private java.util.List<com.example.phase1proj.models.Category> parents;
    private java.util.List<com.example.phase1proj.models.Category> globalparents;
    private java.util.List<java.lang.String> selectCategories;
    private final java.util.List<com.example.phase1proj.models.CategoryLogo> logoList = null;
    private final com.example.phase1proj.views.home home = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.phase1proj.adapters.CategoryLogoViewAdapter.MyLogoViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @android.annotation.SuppressLint(value = {"ResourceType"})
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.phase1proj.adapters.CategoryLogoViewAdapter.MyLogoViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    private final void openActivity(com.example.phase1proj.adapters.ChildRecyclerViewAdapter.MyViewHolder holder, java.lang.String Name) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.phase1proj.models.Category> copy(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.phase1proj.models.Category> $this$copy) {
        return null;
    }
    
    public CategoryLogoViewAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.phase1proj.models.CategoryLogo> logoList, @org.jetbrains.annotations.NotNull()
    com.example.phase1proj.views.home home) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\n \u0019*\u0004\u0018\u00010\u00180\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006\u001e"}, d2 = {"Lcom/example/phase1proj/adapters/CategoryLogoViewAdapter$MyLogoViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemsView", "Landroid/view/View;", "(Landroid/view/View;)V", "innerCard", "Landroidx/cardview/widget/CardView;", "getInnerCard", "()Landroidx/cardview/widget/CardView;", "setInnerCard", "(Landroidx/cardview/widget/CardView;)V", "logoImage", "Landroid/widget/ImageView;", "getLogoImage", "()Landroid/widget/ImageView;", "setLogoImage", "(Landroid/widget/ImageView;)V", "logoName", "Landroid/widget/TextView;", "getLogoName", "()Landroid/widget/TextView;", "setLogoName", "(Landroid/widget/TextView;)V", "textLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "kotlin.jvm.PlatformType", "getTextLayout", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setTextLayout", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "app_debug"})
    public static final class MyLogoViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView logoName;
        @org.jetbrains.annotations.NotNull()
        private android.widget.ImageView logoImage;
        @org.jetbrains.annotations.NotNull()
        private androidx.cardview.widget.CardView innerCard;
        private androidx.constraintlayout.widget.ConstraintLayout textLayout;
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getLogoName() {
            return null;
        }
        
        public final void setLogoName(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getLogoImage() {
            return null;
        }
        
        public final void setLogoImage(@org.jetbrains.annotations.NotNull()
        android.widget.ImageView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.cardview.widget.CardView getInnerCard() {
            return null;
        }
        
        public final void setInnerCard(@org.jetbrains.annotations.NotNull()
        androidx.cardview.widget.CardView p0) {
        }
        
        public final androidx.constraintlayout.widget.ConstraintLayout getTextLayout() {
            return null;
        }
        
        public final void setTextLayout(androidx.constraintlayout.widget.ConstraintLayout p0) {
        }
        
        public MyLogoViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemsView) {
            super(null);
        }
    }
}