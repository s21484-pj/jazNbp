package pl.pjatk.jazs21484nbp.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "gold")
public class NbpResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "This is id of NbpResponse", required = true, value = "some id", example = "1")
    private Long id;

    @Enumerated(EnumType.STRING)
    @ApiModelProperty(notes = "This is gold", required = true, value = "gold", example = "gold")
    private Gold gold;

    @ApiModelProperty(notes = "This is start date", required = true, value = "some date", example = "1970.01.01")
    private LocalDate dateFrom;

    @ApiModelProperty(notes = "This is end date", required = true, value = "some date", example = "1977.01.01")
    private LocalDate dateTo;

    @ApiModelProperty(notes = "This is average price of gold", required = true, value = "some price", example = "160.00")
    private double average;

    @ApiModelProperty(notes = "This is date of create a request", required = true, value = "some date", example = "2021.07.04 17:45:00")
    private LocalDateTime createdAt;

    public NbpResponse() {
    }

    public NbpResponse(Long id, Gold gold, LocalDate dateFrom, LocalDate dateTo, double average, LocalDateTime createdAt) {
        this.id = id;
        this.gold = gold;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.average = average;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Gold getGold() {
        return gold;
    }

    public void setGold(Gold gold) {
        this.gold = gold;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
