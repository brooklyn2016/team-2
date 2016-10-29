package net.codeforgood.sciencebehindsports.Object;

/**
 * Created by VAIO-Jun on 10/28/2016.
 */

public class Activity{

    private int id;
    private int activity_number;
    private String description;
    private int module_id;
    private String activity_objective;
    private String result;
    private int activity_time;
    private String materials;
    private String instruction;

    public Activity(int id, int activity_number, String description,
                    int module_id, String activity_objective, String result,
                    int activity_time, String materials, String instruction) {
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

    public int getId() {
        return id;
    }

    public int getActivity_number() {
        return activity_number;
    }

    public String getDescription() {
        return description;
    }

    public int getModule_id() {
        return module_id;
    }

    public String getActivity_objective() {
        return activity_objective;
    }

    public String getResult() {
        return result;
    }

    public int getActivity_time() {
        return activity_time;
    }

    public String getMaterials() {
        return materials;
    }

    public String getInstruction() {
        return instruction;
    }
}
