package io.bootify.my_app.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@EntityListeners(AuditingEntityListener.class)
public class FmwsAlarm {

    @Id
    @Column(nullable = false, updatable = false, length = 256)
    private String alarmId;

    @Column(length = 256)
    private String alarmReferenceType;

    @Column(length = 256)
    private String alarmReferenceValue;

    @Column(length = 256)
    private String alarmFraudCategory;

    @Column(precision = 28, scale = 6)
    private BigDecimal alarmRocMinutes;

    @Column(precision = 28, scale = 6)
    private BigDecimal alarmRocValue;

    @Column(precision = 10, scale = 2)
    private BigDecimal alarmRocCdr;

    @Column(precision = 10, scale = 2)
    private BigDecimal alarmFmssCdr;

    @Column(precision = 10, scale = 2)
    private BigDecimal alerts;

    @Column(precision = 10, scale = 2)
    private BigDecimal callerDistinctCount;

    @Column(precision = 10, scale = 2)
    private BigDecimal calledDistinctCount;

    @Column(precision = 28, scale = 6)
    private BigDecimal alarmFmssMinutes;

    @Column(precision = 28, scale = 6)
    private BigDecimal alarmFmssValue;

    @Column(precision = 28, scale = 6)
    private BigDecimal alarmAdjustValue;

    @Column(length = 256)
    private String alarmOwner;

    @Column(length = 256)
    private String alarmNote;

    @Column(length = 256)
    private String ticketId;

    @Column
    private OffsetDateTime creationDate;

    @Column(precision = 10, scale = 2)
    private BigDecimal ranking;

    @Column(precision = 10, scale = 2)
    private BigDecimal asr;

    @Column(precision = 10, scale = 2)
    private BigDecimal aloc;

    @Column(length = 256)
    private String statusCode;

    @Column(length = 256)
    private String statusDesc;

    @Column(length = 256)
    private String countryCode;

    @Column
    private OffsetDateTime lastModifiedDate;

    @Column
    private OffsetDateTime trafficStartDate;

    @Column
    private OffsetDateTime trafficEndDate;

    @Column(length = 100)
    private String pippo;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private OffsetDateTime dateCreated;

    @LastModifiedDate
    @Column(nullable = false)
    private OffsetDateTime lastUpdated;

    public String getAlarmId() {
        return alarmId;
    }

    public void setAlarmId(final String alarmId) {
        this.alarmId = alarmId;
    }

    public String getAlarmReferenceType() {
        return alarmReferenceType;
    }

    public void setAlarmReferenceType(final String alarmReferenceType) {
        this.alarmReferenceType = alarmReferenceType;
    }

    public String getAlarmReferenceValue() {
        return alarmReferenceValue;
    }

    public void setAlarmReferenceValue(final String alarmReferenceValue) {
        this.alarmReferenceValue = alarmReferenceValue;
    }

    public String getAlarmFraudCategory() {
        return alarmFraudCategory;
    }

    public void setAlarmFraudCategory(final String alarmFraudCategory) {
        this.alarmFraudCategory = alarmFraudCategory;
    }

    public BigDecimal getAlarmRocMinutes() {
        return alarmRocMinutes;
    }

    public void setAlarmRocMinutes(final BigDecimal alarmRocMinutes) {
        this.alarmRocMinutes = alarmRocMinutes;
    }

    public BigDecimal getAlarmRocValue() {
        return alarmRocValue;
    }

    public void setAlarmRocValue(final BigDecimal alarmRocValue) {
        this.alarmRocValue = alarmRocValue;
    }

    public BigDecimal getAlarmRocCdr() {
        return alarmRocCdr;
    }

    public void setAlarmRocCdr(final BigDecimal alarmRocCdr) {
        this.alarmRocCdr = alarmRocCdr;
    }

    public BigDecimal getAlarmFmssCdr() {
        return alarmFmssCdr;
    }

    public void setAlarmFmssCdr(final BigDecimal alarmFmssCdr) {
        this.alarmFmssCdr = alarmFmssCdr;
    }

    public BigDecimal getAlerts() {
        return alerts;
    }

    public void setAlerts(final BigDecimal alerts) {
        this.alerts = alerts;
    }

    public BigDecimal getCallerDistinctCount() {
        return callerDistinctCount;
    }

    public void setCallerDistinctCount(final BigDecimal callerDistinctCount) {
        this.callerDistinctCount = callerDistinctCount;
    }

    public BigDecimal getCalledDistinctCount() {
        return calledDistinctCount;
    }

    public void setCalledDistinctCount(final BigDecimal calledDistinctCount) {
        this.calledDistinctCount = calledDistinctCount;
    }

    public BigDecimal getAlarmFmssMinutes() {
        return alarmFmssMinutes;
    }

    public void setAlarmFmssMinutes(final BigDecimal alarmFmssMinutes) {
        this.alarmFmssMinutes = alarmFmssMinutes;
    }

    public BigDecimal getAlarmFmssValue() {
        return alarmFmssValue;
    }

    public void setAlarmFmssValue(final BigDecimal alarmFmssValue) {
        this.alarmFmssValue = alarmFmssValue;
    }

    public BigDecimal getAlarmAdjustValue() {
        return alarmAdjustValue;
    }

    public void setAlarmAdjustValue(final BigDecimal alarmAdjustValue) {
        this.alarmAdjustValue = alarmAdjustValue;
    }

    public String getAlarmOwner() {
        return alarmOwner;
    }

    public void setAlarmOwner(final String alarmOwner) {
        this.alarmOwner = alarmOwner;
    }

    public String getAlarmNote() {
        return alarmNote;
    }

    public void setAlarmNote(final String alarmNote) {
        this.alarmNote = alarmNote;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(final String ticketId) {
        this.ticketId = ticketId;
    }

    public OffsetDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(final OffsetDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public BigDecimal getRanking() {
        return ranking;
    }

    public void setRanking(final BigDecimal ranking) {
        this.ranking = ranking;
    }

    public BigDecimal getAsr() {
        return asr;
    }

    public void setAsr(final BigDecimal asr) {
        this.asr = asr;
    }

    public BigDecimal getAloc() {
        return aloc;
    }

    public void setAloc(final BigDecimal aloc) {
        this.aloc = aloc;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(final String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(final String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(final String countryCode) {
        this.countryCode = countryCode;
    }

    public OffsetDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(final OffsetDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public OffsetDateTime getTrafficStartDate() {
        return trafficStartDate;
    }

    public void setTrafficStartDate(final OffsetDateTime trafficStartDate) {
        this.trafficStartDate = trafficStartDate;
    }

    public OffsetDateTime getTrafficEndDate() {
        return trafficEndDate;
    }

    public void setTrafficEndDate(final OffsetDateTime trafficEndDate) {
        this.trafficEndDate = trafficEndDate;
    }

    public String getPippo() {
        return pippo;
    }

    public void setPippo(final String pippo) {
        this.pippo = pippo;
    }

    public OffsetDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(final OffsetDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public OffsetDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(final OffsetDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

}
