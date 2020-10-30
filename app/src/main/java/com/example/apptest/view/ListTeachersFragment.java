package com.example.apptest.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apptest.R;
import com.example.apptest.model.Teacher;
import com.example.apptest.repository.RequestResult;
import com.example.apptest.repository.TeacherRepository;

import java.util.ArrayList;
import java.util.List;

import static com.example.apptest.view.CardsAdapter.LIST_KEY;

public class ListTeachersFragment extends Fragment {

    TeacherRepository teacherRepository = null;
    ListAdapter listAdapter;
    List<Teacher> teachers = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_teachers, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }





    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        teacherRepository = new TeacherRepository();

        RecyclerView recyclerView = view.getRootView().findViewById(R.id.list_recycler);
        listAdapter = new ListAdapter(getContext(), teachers);

        recyclerView.setAdapter(listAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        getAll();
    }

    private void getAll() {
        final LoaddingDialog dialog = new LoaddingDialog(getActivity());
        dialog.startDialog();
        teacherRepository.getAll(new RequestResult() {
            @Override
            public <T> void returnSuccess(T requestResult) {
                teachers = (List<Teacher>) requestResult;
                listAdapter.setList(teachers);
                listAdapter.notifyDataSetChanged();
                dialog.dismissDialog();
            }

            @Override
            public void returnError(String message) {
                dialog.dismissDialog();
                Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
                getActivity().finish();
            }
        });
    }
}
