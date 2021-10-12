package ru.itis.dis.lab4.freemarkertest;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class MainFMTest {
    public static void main(String[] args) {

        Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);
        try {

            cfg.setDirectoryForTemplateLoading(new File(
                    "/home/ksenikeev/ideaprojects/dis/lab4/src/main/resources/templates"));
            cfg.setDefaultEncoding("UTF-8");

            List<Student> list = new ArrayList<>();
            list.add(new Student("0001","Али Хезам Абдулрахман Хезам"));
            list.add(new Student("0002","Аммар Нажи Али Саад"));
            list.add(new Student("0003","Барреро Гонсалес Кевин Джоан"));
            list.add(new Student("0004","Борейк Али Акиль Али"));
            list.add(new Student("0005","Боутифор Абд Ел Хак"));
            list.add(new Student("0006","Ван Шицзи"));
            list.add(new Student("0007","Ихсанов Искандар Ринатович"));

            Map<String, Object> params = new HashMap<>();
            params.put("groupp", "11-013");
            params.put("date", new SimpleDateFormat("dd.MM.yyyy").format(new Date()));
            params.put("groupp_list", list);

            Template temp = cfg.getTemplate("test.ftlh");

            Writer out = new FileWriter("groupp.html");
            temp.process(params, out);

        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }

    }
}
