package reactive.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author FS001338
 * @date 2021/6/24
 */
@Data
@AllArgsConstructor
public class Student {

    private String name;

    private Integer age;

    private Integer sex;

    private List<String> course;
}
