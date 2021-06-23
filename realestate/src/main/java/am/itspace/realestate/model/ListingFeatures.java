package am.itspace.realestate.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
@Entity
@Table(name = "features")
public class ListingFeatures {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column
    private long id;
    @Column
    private String name;

}
