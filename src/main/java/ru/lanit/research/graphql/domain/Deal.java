package ru.lanit.research.graphql.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "DEAL")
public class Deal extends DomainObject {
    private String num;
    private BigDecimal sum;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL) // без EAGER вылетает ошибка при запросе deal.participants
    @JoinColumn(name = "deal_id", nullable = false)
    private List<LegalEntity> participants;
}
