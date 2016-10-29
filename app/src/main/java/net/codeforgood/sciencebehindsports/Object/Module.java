package net.codeforgood.sciencebehindsports.Object;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by VAIO-Jun on 10/28/2016.
 */

public class Module implements Parcelable {
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

    protected Module(Parcel in) {
        id = in.readInt();
        module_name = in.readString();
        module_time = in.readInt();
        num_of_activities = in.readInt();
        materials = in.readString();
        objective = in.readString();
        content = in.readString();
        process = in.readString();
        module_number = in.readInt();
    }

    public static final Creator<Module> CREATOR = new Creator<Module>() {
        @Override
        public Module createFromParcel(Parcel in) {
            return new Module(in);
        }

        @Override
        public Module[] newArray(int size) {
            return new Module[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(this.module_name);
        dest.writeInt(this.module_time);
        dest.writeInt(this.num_of_activities);
        dest.writeString(this.materials);
        dest.writeString(this.objective);
        dest.writeString(this.content);
        dest.writeString(this.process);
        dest.writeInt(this.module_number);
    }
}
