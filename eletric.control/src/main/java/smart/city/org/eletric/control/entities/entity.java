package smart.city.org.eletric.control.entities;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;

import java.util.Date;

public abstract class entity {
    @Id
    private String id;

    @NotBlank
    private Date createdAt;

    @NotBlank
    private String createdBy;


    private Date updatedAt;

    private String updatedBy;


}
