package kpi.trspo.machineryms.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.UUID;

@EnableAutoConfiguration
@Entity
@Table(name = "machinery")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Machinery {

    @Id
    @GeneratedValue
    private UUID machineryId;

    @Column(name = "person_id")
    private UUID operator;
    @NotNull
    @Column(name = "type_id")
    private UUID machineryType;

}
