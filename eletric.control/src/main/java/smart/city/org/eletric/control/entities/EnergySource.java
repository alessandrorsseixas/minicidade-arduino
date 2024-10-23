package smart.city.org.eletric.control.entities;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;

@Document(Collection ="energysources" )
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnergySource extends entity{


    public String type;
    @NotBlank
    public String location;
    @NotBlank
    public Double capacity;
    @NotBlank
    public Double currentGeneration;
    @NotBlank
    public String status;
    @NotBlank
    public String lastMaintenance;
    @NotBlank
    public String installationDate;
}
