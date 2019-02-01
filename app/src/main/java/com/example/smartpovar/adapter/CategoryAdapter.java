package com.example.smartpovar.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.smartpovar.R;
import com.example.smartpovar.entity.Category;

import java.util.Collections;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    private List<Category> categoryList  = Collections.emptyList();

    public void setCategoryList(List<Category> categories){
        categoryList = categories;
        notifyDataSetChanged();
    }
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_category,viewGroup,false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int i) {
        categoryViewHolder.bind(categoryList.get(i));
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    static class CategoryViewHolder extends RecyclerView.ViewHolder{

        private TextView id;
        private TextView categoryName;
        public CategoryViewHolder(View itemView){
            super(itemView);

            id = itemView.findViewById(R.id.id);
            categoryName = itemView.findViewById(R.id.categoryName);
        }

        public void bind(Category category){
            id.setText(category.getId() + "");
            categoryName.setText(category.getCategoryName());
        }

    }
}
