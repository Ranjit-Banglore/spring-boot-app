package com.greenproject.data;

import com.greenproject.model.Project;
import com.greenproject.utils.DateUtils;
import java.util.ArrayList;

public class Data {

    private ArrayList<Project> projects=new ArrayList<>();

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public Data(){
        reset();
    }

    public void reset(){

        projects.add(new Project(1001,"commercial",100,"cr","north", DateUtils.date("2018-01-01"),
                DateUtils.date("2021-07-01"),Boolean.TRUE ));

        projects.add(new Project(1002,"residential",40,"cr","cental", DateUtils.date("2018-02-01"),
                DateUtils.date("2021-06-01"),Boolean.TRUE ));

        projects.add(new Project(1003,"commercial",150,"cr","north", DateUtils.date("2018-03-01"),
                DateUtils.date("2021-05-01"),Boolean.TRUE ));

        projects.add(new Project(1004,"commercial",90,"cr","north", DateUtils.date("2018-04-01"),
                DateUtils.date("2021-04-01"),Boolean.TRUE ));

        projects.add(new Project(1005,"government",20,"cr","north", DateUtils.date("2018-05-01"),
                DateUtils.date("2021-03-01"),Boolean.TRUE ));

        projects.add(new Project(1006,"commercial",1000,"cr","north", DateUtils.date("2018-06-01"),
                DateUtils.date("2021-02-01"),Boolean.TRUE ));

        projects.add(new Project(1007,"public",2000,"cr","city", DateUtils.date("2018-07-01"),
                DateUtils.date("2021-01-01"),Boolean.TRUE ));

    }



}
