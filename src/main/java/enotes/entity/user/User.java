package enotes.entity.user;

import enotes.entity.userrole.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "users")
@Getter @Setter
@EqualsAndHashCode(exclude = {"password", "decryptedPassword"})
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"password", "decryptedPassword"})
@Builder
public class User implements Serializable {
    @Id
    @Positive
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Integer version;

    @NotBlank
    @Size(max = 25)
    private String firstName;

    @NotBlank
    @Size(max = 25)
    private String lastName;

    @NotBlank
    @Size(max = 50)
    private String email;

    @NotBlank
    @Size(max = 2000)
    private String password;

    @Transient
    private String decryptedPassword;

    @Min(3)
    @Max(100)
    private int age;

    @NotBlank
    @Size(max = 25)
    private String country;

    @PastOrPresent
    @NotNull
    private Date registration;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "role_id")
    private UserRole role;
}
