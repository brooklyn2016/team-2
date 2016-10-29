package net.codeforgood.sciencebehindsports.Object;

/**
 * Created by VAIO-Jun on 10/28/2016.
 */

public class Module {
    private int id;
    private String module_name;
    private int module_time;
    private int num_of_activities;
    private String materials;
    private String objective;
    private String content;
    private String process;
    private int module_number;

    public Module(int id, String module_name, int module_time,
                  int num_of_activities, String materials,
                  String objective, String content,
                  String process, int module_number) {
        this.id = id;
        this.module_name = module_name;
        this.module_time = module_time;
        this.num_of_activities = num_of_activities;
        this.materials = materials;
        this.objective = objective;
        this.content = content;
        this.process = process;
        this.module_number = module_number;
    }

    public int getId() {
        return id;
    }

    public String getModule_name() {
        return module_name;
    }

    public int getModule_time() {
        return module_time;
    }

    public int getNum_of_activities() {
        return num_of_activities;
    }

    public String getMaterials() {
        return materials;
    }

    public String getObjective() {
        return objective;
    }

    public String getContent() {
        return content;
    }

    public String getProcess() {
        return process;
    }

    public int getModule_number() {
        return module_number;
    }
}
