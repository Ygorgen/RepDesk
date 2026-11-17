package com.repdesk.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.repdesk.enums.ServiceOrderStatus;
import jakarta.persistence.*;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "service_orders")
@EntityListeners(AuditingEntityListener.class)
public class ServiceOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 30)
    private String protocol;

    @Column(nullable = false,length = 100)
    private String clientName;

    @Column(length = 100)
    private String contactNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 40)
    private ServiceOrderStatus status;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String problem;

    private Boolean turnsOn;

    private Boolean screenWorking;

    private Boolean touchWorking;

    private Boolean chargingWorking;

    private Boolean physicalDamage;

    private boolean wetDevice;

    @Column(precision = 10, scale = 2)
    private BigDecimal budgetAmount;

    //Data de recebimento
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime receivedAt;

    @Column(length = 100)
    private String estimatedCompletionTime;

    //Data de entrega
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime deliveredAt;

    //Data da ultima atualização
    @LastModifiedDate
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime updatedAt;

    public ServiceOrder() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public ServiceOrderStatus getStatus() {
        return status;
    }

    public void setStatus(ServiceOrderStatus status) {
        this.status = status;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public Boolean getTurnsOn() {
        return turnsOn;
    }

    public void setTurnsOn(Boolean turnsOn) {
        this.turnsOn = turnsOn;
    }

    public Boolean getScreenWorking() {
        return screenWorking;
    }

    public void setScreenWorking(Boolean screenWorking) {
        this.screenWorking = screenWorking;
    }

    public Boolean getTouchWorking() {
        return touchWorking;
    }

    public void setTouchWorking(Boolean touchWorking) {
        this.touchWorking = touchWorking;
    }

    public Boolean getChargingWorking() {
        return chargingWorking;
    }

    public void setChargingWorking(Boolean chargingWorking) {
        this.chargingWorking = chargingWorking;
    }

    public Boolean getPhysicalDamage() {
        return physicalDamage;
    }

    public void setPhysicalDamage(Boolean physicalDamage) {
        this.physicalDamage = physicalDamage;
    }

    public BigDecimal getBudgetAmount() {
        return budgetAmount;
    }

    public void setBudgetAmount(BigDecimal budgetAmount) {
        this.budgetAmount = budgetAmount;
    }

    public LocalDateTime getReceivedAt() {
        return receivedAt;
    }

    public void setReceivedAt(LocalDateTime receivedAt) {
        this.receivedAt = receivedAt;
    }

    public String getEstimatedCompletionTime() {
        return estimatedCompletionTime;
    }

    public void setEstimatedCompletionTime(String estimatedCompletionTime) {
        this.estimatedCompletionTime = estimatedCompletionTime;
    }

    public LocalDateTime getDeliveredAt() {
        return deliveredAt;
    }

    public void setDeliveredAt(LocalDateTime deliveredAt) {
        this.deliveredAt = deliveredAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ServiceOrder that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getProtocol(), that.getProtocol()) && getStatus() == that.getStatus() && Objects.equals(getProblem(), that.getProblem()) && Objects.equals(getTurnsOn(), that.getTurnsOn()) && Objects.equals(getScreenWorking(), that.getScreenWorking()) && Objects.equals(getTouchWorking(), that.getTouchWorking()) && Objects.equals(getChargingWorking(), that.getChargingWorking()) && Objects.equals(getPhysicalDamage(), that.getPhysicalDamage()) && Objects.equals(getBudgetAmount(), that.getBudgetAmount()) && Objects.equals(getReceivedAt(), that.getReceivedAt()) && Objects.equals(getEstimatedCompletionTime(), that.getEstimatedCompletionTime()) && Objects.equals(getDeliveredAt(), that.getDeliveredAt()) && Objects.equals(getUpdatedAt(), that.getUpdatedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getProtocol(), getStatus(), getProblem(), getTurnsOn(), getScreenWorking(), getTouchWorking(), getChargingWorking(), getPhysicalDamage(), getBudgetAmount(), getReceivedAt(), getEstimatedCompletionTime(), getDeliveredAt(), getUpdatedAt());
    }
}
