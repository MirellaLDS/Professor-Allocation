package com.example.apptest.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.apptest.R;
import com.example.apptest.model.Course;
import com.example.apptest.model.Teacher;
import com.example.apptest.repository.CourseRepository;
import com.example.apptest.repository.RequestResult;
import com.example.apptest.repository.TeacherRepository;

import java.util.ArrayList;
import java.util.List;


public class ListCoursesFragment extends Fragment {

    private CourseRepository courseRepository = null;
    private CourseAdapter listAdapter;
    private List<Course> courses = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_courses, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        courseRepository = new CourseRepository();

        RecyclerView recyclerView = view.getRootView().findViewById(R.id.list_recycler);
        listAdapter = new CourseAdapter(getContext(), courses);


        recyclerView.setAdapter(listAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        getAll();
    }

    private void getAll() {
        final LoaddingDialog dialog = new LoaddingDialog(getActivity());
        dialog.startDialog();
        courseRepository.getAll(new RequestResult() {
            @Override
            public <T> void returnSuccess(T requestResult) {
                courses = (List<Course>) requestResult;
                listAdapter.setList(courses);
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