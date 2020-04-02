package com.example.phase1proj.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\bH\u0016J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u0018\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0005H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/example/phase1proj/adapters/SpecificCategoryListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/phase1proj/adapters/SpecificCategoryListAdapter$MyViewHolder1;", "vegetableList", "", "Lcom/example/phase1proj/models/Vegetable;", "(Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "openActivity", "item", "MyViewHolder1", "app_debug"})
public final class SpecificCategoryListAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.phase1proj.adapters.SpecificCategoryListAdapter.MyViewHolder1> {
    private final java.util.List<com.example.phase1proj.models.Vegetable> vegetableList = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.phase1proj.adapters.SpecificCategoryListAdapter.MyViewHolder1 onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.phase1proj.adapters.SpecificCategoryListAdapter.MyViewHolder1 holder, int position) {
    }
    
    private final void openActivity(com.example.phase1proj.adapters.SpecificCategoryListAdapter.MyViewHolder1 holder, com.example.phase1proj.models.Vegetable item) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public SpecificCategoryListAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.phase1proj.models.Vegetable> vegetableList) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R\u001a\u0010\u001a\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010\u00a8\u0006\u001d"}, d2 = {"Lcom/example/phase1proj/adapters/SpecificCategoryListAdapter$MyViewHolder1;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemsView", "Landroid/view/View;", "(Landroid/view/View;)V", "cardLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getCardLayout", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setCardLayout", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "rateVegetable", "Landroid/widget/TextView;", "getRateVegetable", "()Landroid/widget/TextView;", "setRateVegetable", "(Landroid/widget/TextView;)V", "vegetableThumbnail", "Landroid/widget/ImageView;", "getVegetableThumbnail", "()Landroid/widget/ImageView;", "setVegetableThumbnail", "(Landroid/widget/ImageView;)V", "vegetableTitle", "getVegetableTitle", "setVegetableTitle", "weightVegetable", "getWeightVegetable", "setWeightVegetable", "app_debug"})
    public static final class MyViewHolder1 extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView vegetableTitle;
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView rateVegetable;
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView weightVegetable;
        @org.jetbrains.annotations.NotNull()
        private android.widget.ImageView vegetableThumbnail;
        @org.jetbrains.annotations.NotNull()
        private androidx.constraintlayout.widget.ConstraintLayout cardLayout;
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getVegetableTitle() {
            return null;
        }
        
        public final void setVegetableTitle(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getRateVegetable() {
            return null;
        }
        
        public final void setRateVegetable(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getWeightVegetable() {
            return null;
        }
        
        public final void setWeightVegetable(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getVegetableThumbnail() {
            return null;
        }
        
        public final void setVegetableThumbnail(@org.jetbrains.annotations.NotNull()
        android.widget.ImageView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.constraintlayout.widget.ConstraintLayout getCardLayout() {
            return null;
        }
        
        public final void setCardLayout(@org.jetbrains.annotations.NotNull()
        androidx.constraintlayout.widget.ConstraintLayout p0) {
        }
        
        public MyViewHolder1(@org.jetbrains.annotations.NotNull()
        android.view.View itemsView) {
            super(null);
        }
    }
}