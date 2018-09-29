package com.github.beisser.design_patterns.builder;

import java.util.HashMap;
import java.util.Map;

class Class {

    public String name;
    public Map<String, String> members = new HashMap<String, String>();



}

class CodeBuilder {

    private Class buildClass = new Class();

    public CodeBuilder(String className)
    {
        buildClass.name = className;
    }

    public CodeBuilder addField(String name, String type)
    {
        buildClass.members.put(name, type);
        return this;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("public class " + buildClass.name);
        sb.append(System.lineSeparator());
        sb.append("{");
        for(Map.Entry<String, String> entry : this.buildClass.members.entrySet()) {
            sb.append("  public " + entry.getValue() + " " + entry.getKey() + ";");
            sb.append(System.lineSeparator());
        }
        sb.append("}");
        return sb.toString();
    }
}

public class BuilderTraining {

    public static void main(String[] args) {
        CodeBuilder cb = new CodeBuilder("Person").addField("name", "String").addField("age", "int");
        System.out.println(cb);
    }
}
