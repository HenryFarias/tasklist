package br.com.supero.tasklist.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Where(clause="deleted_at is null")
@SQLDelete(sql = "UPDATE task SET deleted_at = NOW() WHERE id = ?", check = ResultCheckStyle.COUNT)
public class Task {

    @Id
    @Column
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @NotNull
    private String title;

    @Column
    @NotNull
    private String description;

    @Column
    @NotNull
    private boolean state;

    @Column
    @Temporal(TemporalType.DATE)
    private Date completedAt;

    @Column
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    @Column
    @Temporal(TemporalType.DATE)
    private Date updatedAt;

    @Column
    @Temporal(TemporalType.DATE)
    private Date deletedAt;

    @PrePersist
    protected void onCreate() {
        if (this.state) {
            this.completedAt = new Date();
        } else {
            this.completedAt = null;
        }
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        if (this.state) {
            this.completedAt = new Date();
        } else {
            this.completedAt = null;
        }
        this.updatedAt = new Date();
    }

    @PreRemove
    protected void onRemove() {
        this.deletedAt = new Date();
    }
}
