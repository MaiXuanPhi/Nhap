package com.example.nhap.searchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;

import com.example.nhap.R;

import java.util.ArrayList;
import java.util.List;

public class SearchViewActivity extends AppCompatActivity {

    private RecyclerView rcvUsers;
    private UserAdapter userAdapter;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view);

        searchView = findViewById(R.id.searchView);

        rcvUsers = findViewById(R.id.rcv_users);
        rcvUsers.setLayoutManager(new LinearLayoutManager(this));

        userAdapter = new UserAdapter(getListUsers());
        rcvUsers.setAdapter(userAdapter);

        // set gạch ngang cho các item
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rcvUsers.addItemDecoration(itemDecoration);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                userAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                userAdapter.getFilter().filter(newText);
                return false;
            }
        });
    }

    private List<User> getListUsers() {
        List<User> list = new ArrayList<>();
        list.add(new User("Mai Xuân Phi", "Thừa Thiên Huế"));
        list.add(new User("Nguyên Trãi", "Hồ Chí Minh"));
        list.add(new User("Phan Bảo Châu", "Long An"));
        list.add(new User("Phạm Nhật Vượng", "Hà Nội"));
        list.add(new User("Nguyễn Minh Khang", "Quãng Ngãi"));
        return list;
    }

    @Override
    public void onBackPressed() {
        if (!searchView.isIconified()){
            searchView.setIconified(true);
            return;
        }
        super.onBackPressed();
    }
}