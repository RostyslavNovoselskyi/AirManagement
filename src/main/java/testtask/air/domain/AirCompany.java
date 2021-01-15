package testtask.air.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class AirCompany {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String companyType;

//    @ElementCollection(targetClass = CompanyType.class, fetch = FetchType.EAGER)
//    @CollectionTable(name = "company_type", joinColumns = @JoinColumn(name = "aircompany_id"))
//    @Enumerated(EnumType.STRING)
//    private Set<CompanyType> companyTypes;

    private LocalDate foundedAt;

    public AirCompany() {
    }

    public AirCompany(String name, String companyType, LocalDate foundedAt) {
        this.name = name;
        this.companyType = companyType;
        this.foundedAt = foundedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public LocalDate getFoundedAt() {
        return foundedAt;
    }

    public void setFoundedAt(LocalDate foundedAt) {
        this.foundedAt = foundedAt;
    }
}
