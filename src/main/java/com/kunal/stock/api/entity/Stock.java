package com.kunal.stock.api.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.ObjectUtils;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @author Kumar.Kunal
 * @project Stock API
 */

@Data
@Builder(toBuilder = true)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "stock")
public class Stock {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @NotBlank
    @Size(min = 0, max = 20)
    @Column(name = "name")
    private String name;

    @Column(name = "currentPrice")
    private BigDecimal currentPrice;

    @CreationTimestamp
    @Column(name = "lastUpdate", nullable = false, updatable = false)
    private Timestamp lastUpdate;

    @PrePersist
    @PreUpdate
    public void prePersist() {
        if (ObjectUtils.isEmpty(this.lastUpdate) && ObjectUtils.isNotEmpty(this.id)) {
            lastUpdate = Timestamp.valueOf(LocalDateTime.now());
        }
    }

}
