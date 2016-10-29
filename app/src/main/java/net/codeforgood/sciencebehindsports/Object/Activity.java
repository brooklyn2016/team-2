package net.codeforgood.sciencebehindsports.Object;

/**
 * Created by VAIO-Jun on 10/28/2016.
 */

public class Activity {
    private String name;
    private int id;
    private int activity_number;
    private String description;
    private int module_id;
    private String activity_objective;
    private String result;
    private int activity_time;
    private String materials;
    private String instruction;

    public Activity(String name, int id, int activity_number, String description,
                    int module_id, String activity_objective, String result,
                    int activity_time, String materials, String instruction) {
        this.name = name;
        this.id = id;
        this.activity_number = activity_number;
        this.description = description;
        this.module_id = module_id;
        this.activity_objective = activity_objective;
        this.result = result;
        this.activity_time = activity_time;
        this.materials = materials;
        this.instruction = instruction;
    }

    public String getName() {
        return name;
    }

    public int getActivity_number() {
        return activity_number;
    }

    public int getId() {
        return id;
    }

    public int getModule_id() {
        return module_id;
    }

    public int getActivity_time() {
        return activity_time;
    }

    
}
